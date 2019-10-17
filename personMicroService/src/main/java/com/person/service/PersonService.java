
package com.person.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import brave.Span;
import brave.Tracer;
import org.springframework.stereotype.Service;

import com.person.dto.OrganizationDTO;
import com.person.entity.Person;
import com.person.mapper.PersonMapper;
import com.person.model.PersonResponseModel;

/**
 * @author chandresh.mishra
 *
 */
@Service
public class PersonService {

	private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

	@Autowired
	private OrganizationServiceData organizationServiceData;

	@Autowired
	private PersonServiceData personServiceData;

	@Autowired
	private PersonMapper personMapper;

	@Autowired
	private OrganizationCachedData organizationCachedData;

	// BO to Entity should be used but BO is not used just for simplification.
	public void savePerson(Person person) {
		personServiceData.savePerson(person);
	}

	// It should return a business object in place of model. Model used just for
	// simplification.
	// Hystrix command works on separate class files. As it works on Spring AOP
	public PersonResponseModel getPerson(String nino, int id) {
		// logger.debug("PersonService.getPerson Correlation id: {}",
		// UserContextHolder.getContext().getCorrelationId());
		logger.debug("Entering the getPerson() method for the nino: {} and id {} ", nino, id);
	
		// person data from database
		Person person = null;
		person = personServiceData.fetchPerson(nino);

		logger.info("person data from db {}", person);
		PersonResponseModel personResponseModel = personMapper.personToPersonResponse(person);

		OrganizationDTO organizationDTO=null;
		// Get the value from the redis
		organizationDTO = organizationCachedData.checkRedisCache(id);

		if (organizationDTO == null) {
		// Get org data from extenal resource
		organizationDTO = organizationServiceData.getOrganizationData(id);
		
		}
		
		if(!organizationDTO.getOrganizationName().equals("Unknown"))
		{
			// saving data in redis
			logger.info("saving data in cache {} by {}", organizationDTO,Thread.currentThread().getName());
			organizationCachedData.cacheOrganizationObject(organizationDTO);
		}

		personResponseModel.setEmployerName(organizationDTO.getOrganizationName());
		personResponseModel.setLocation(organizationDTO.getLocation());
		return personResponseModel;

	}

}
