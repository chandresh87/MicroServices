/**
 * 
 */
package com.organization.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.entity.OrganizationEntity;
import com.organization.repository.OrganizationRepository;

/**
 * @author chandresh.mishra
 *
 */
@Service
public class OrganizationService {

	private static final Logger logger = LoggerFactory.getLogger(OrganizationService.class);
	
	@Autowired
	private OrganizationRepository repository;
	
	public OrganizationEntity saveOrganization(OrganizationEntity organization)
	{
		return repository.save(organization);
		
	}
	
	public OrganizationEntity updateOrganization(OrganizationEntity organization)
	{
		return repository.save(organization);
		
	}
	
	public OrganizationEntity fetchOrganization(Integer id)
	{
		logger.info("Entering the fetchOrganization() method for id {} ",id);
		
		//randomlyRunLong(); //sleep for 3rd call
		//sleep();  //sleep for every call
		return repository.findById(id).get(); // should not call get directly.
	}
	//Test slow service from organisation side
	
	private void randomlyRunLong(){
		Random rand = new Random();
		int randomNum = rand.nextInt((3 - 1) + 1) + 1;
		if (randomNum==3) 
			sleep();
		}
	
private void sleep(){
		try {
		logger.info("Thread going to sleep fetchOrganization()");
		Thread.sleep(12000);
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
		}
}
