/**
 * 
 */
package com.person.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.person.config.HytrixConfig;
import com.person.dto.OrganizationDTO;
import com.person.dto.client.OrganizationFeignClient;
import com.person.filter.UserContextHolder;
import com.person.repository.OrganizationRedisRepository;

/**
 * @author chandresh.mishra
 *
 */
@Component
/*@DefaultProperties(
commandProperties= {
		 @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="11000") // after 11 sec call will be timeout// default for whole class.
})*/

public class OrganizationServiceData {
	
	private static final Logger logger = LoggerFactory.getLogger(OrganizationServiceData.class);
	
	@Autowired
	private OrganizationFeignClient organizationClient;
	
	 @Autowired
	 private  OrganizationRedisRepository orgRedisRepo;
	
	@Autowired
	private HytrixConfig hytrixConfig;
	
	/*@HystrixCommand(fallbackMethod="buildFallBackOrganization"
	 ,threadPoolKey="organizationThreadPool",  // Following bulkhead pattern
	 threadPoolProperties=
	 {	@HystrixProperty (name="coreSize", value="30"), //request/sec at peak * 99 * latency/sec /100 + some extra overhead
		@HystrixProperty(name="maxQueueSize", value="10") // It will use LinkedBlockingQueue to hold  the request	if set -1 then synchronous queue will be used 
			 
	 },// Configured property for the Hystrix at method level.
	commandProperties={
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="10"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="75"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="7000"),
            @HystrixProperty(name="metrics.rollingStats.timeInMilliseconds", value="15000"),
            @HystrixProperty(name="metrics.rollingStats.numBuckets", value="5")})*/
	
	@HystrixCommand(fallbackMethod="buildFallBackOrganization",threadPoolKey="organizationThreadPool",  // Following bulkhead pattern
			 threadPoolProperties=
		 {	@HystrixProperty (name="coreSize", value="30"), //request/sec at peak * 99 * latency/sec /100 + some extra overhead
			@HystrixProperty(name="maxQueueSize", value="10") // It will use LinkedBlockingQueue to hold  the request	if set -1 then synchronous queue will be used 
				 
		 })
	public OrganizationDTO getOrganizationData(int organizationId)
	{
		OrganizationDTO organizationDTO=null;
		logger.debug("OrganizationServiceData.getOrganizationData  Correlation id: {}", UserContextHolder.getContext().getCorrelationId());
		
		//randomlyRunLong();  // Testing circuit breaker
		
		//Get the value from the redis
		organizationDTO=orgRedisRepo.findOrganization(organizationId);
		
		if(organizationDTO==null)
		{
			ResponseEntity<OrganizationDTO> reponse= organizationClient.getOrganization(organizationId);
			 organizationDTO=reponse.getBody();
			 logger.info("saving data in cache {}", organizationDTO);
			 //saving data in redis
			 orgRedisRepo.saveOrganization(organizationDTO);
		}
		
		return organizationDTO;
	}
	
	//FallBack method used by the Hytrix
	private  OrganizationDTO buildFallBackOrganization(int OrganizationId)
	{
		logger.info("calling fallback method to get the organization data for id {}",OrganizationId);
		OrganizationDTO organizationDTO=new  OrganizationDTO();
		organizationDTO.setLocation("Unknown");
		organizationDTO.setOrganizationName("Unknown");
		return organizationDTO;
	}

	/*Testing Hytrix cirtuit Breaker
	{
	    "timestamp": 1518218372390,
	    "status": 500,
	    "error": "Internal Server Error",
	    "exception": "com.netflix.hystrix.exception.HystrixRuntimeException",
	    "message": "getPerson timed-out and fallback failed.",
	    "path": "/getPerson"
	}*/
	private void randomlyRunLong(){
		Random rand = new Random();
		int randomNum = rand.nextInt((3 - 1) + 1) + 1;
		if (randomNum==3) sleep();
		}
	
private void sleep(){
		try {
		Thread.sleep(12000);
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
		}
}
