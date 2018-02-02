/**
 * 
 */
package com.organization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.entity.Organization;

/**
 * @author chandresh.mishra
 *
 */
public interface OrganizationRepository extends JpaRepository<Organization, Integer>{

	Organization findById(Integer id);
	
}
