/**
 * 
 */
package com.person.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.person.entity.Person;
import com.person.repository.PersonRepository;

import brave.Span;
import brave.Tracer;

/**
 * @author chandresh.mishra
 *
 */
@Service
public class PersonServiceData {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	Tracer tracer;
	
	private static final Logger logger = LoggerFactory.getLogger(PersonServiceData.class);
	
	public void savePerson(Person person)
	{
		 personRepository.save(person);
	}
	
	
	@HystrixCommand(threadPoolKey="personDataBaseThreadPool",  // Following bulkhead pattern
			 threadPoolProperties=
		 {	@HystrixProperty (name="coreSize", value="25"), //request/sec at peak * 99 * latency/sec /100 + some extra overhead
			@HystrixProperty(name="maxQueueSize", value="5") // It will use LinkedBlockingQueue to hold  the request	if set -1 then synchronous queue will be used 
				 
		 })
	public Person fetchPerson(String nino) {
		Span newSpan = tracer.nextSpan().name("personDataFromSQL").start();

		try {
			logger.info("Fetching person data from db");
			return personRepository.findByNino(nino);
		} finally {
			newSpan.tag("peer.service", "MySQL");
			newSpan.finish();
		}

	}
}