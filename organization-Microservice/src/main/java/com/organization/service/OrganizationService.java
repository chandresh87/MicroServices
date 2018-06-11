/**
 * 
 */
package com.organization.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.entity.Organization;
import com.organization.repository.OrganizationRepository;

/**
 * @author chandresh.mishra
 *
 */
@Service
public class OrganizationService {

	@Autowired
	private OrganizationRepository repository;
	
	public Organization saveOrganization(Organization organization)
	{
		return repository.save(organization);
		
	}
	
	public Organization fetchOrganization(Integer id)
	{
		//randomlyRunLong(); //sleep for 3rd call
		sleep();  //sleep for every call
		return repository.findById(id);
	}
	//Test slow service from organisation side
	
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
