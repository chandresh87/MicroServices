/**
 * 
 */
package com.organization.service;

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
		return repository.findById(id);
	}
}
