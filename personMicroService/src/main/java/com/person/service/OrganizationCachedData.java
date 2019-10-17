package com.person.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.person.config.HytrixConfig;
import com.person.dto.OrganizationDTO;
import com.person.dto.client.OrganizationFeignClient;
import com.person.repository.OrganizationRedisRepository;

import brave.Span;
import brave.Tracer;

@Component
public class OrganizationCachedData {
	
	private static final Logger logger = LoggerFactory.getLogger(OrganizationCachedData.class);
	
	@Autowired
	public OrganizationFeignClient organizationClient;
	@Autowired
	public OrganizationRedisRepository orgRedisRepo;
	@Autowired
	public HytrixConfig hytrixConfig;
	@Autowired
	public Tracer tracer;


	@HystrixCommand(threadPoolKey="personRedisThreadPool",  // Following bulkhead pattern
			 threadPoolProperties=
		 {	@HystrixProperty (name="coreSize", value="25"), //request/sec at peak * 99 * latency/sec /100 + some extra overhead
			@HystrixProperty(name="maxQueueSize", value="5") // It will use LinkedBlockingQueue to hold  the request	if set -1 then synchronous queue will be used 
				 
		 })
	public OrganizationDTO checkRedisCache(int organizationId) {
		OrganizationDTO organizationDTO;

		Span newSpan = tracer.nextSpan().name("readOrgDataFromRedis").start();

		try {
			logger.info("Get the value from the redis");
			organizationDTO = orgRedisRepo.findOrganization(organizationId);
		} catch (Exception ex) {
			logger.error("Error encountered while trying to retrieve organization {} check Redis Cache.  Exception {}",
					organizationId, ex);
			return null;
		} finally {
			newSpan.tag("peer.service", "redis");
			newSpan.finish();
		}
		return organizationDTO;
	}
	
	public void cacheOrganizationObject(OrganizationDTO organizationDTO) {
		orgRedisRepo.saveOrganization(organizationDTO);
	}
}