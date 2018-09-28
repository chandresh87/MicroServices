/**
 * 
 */
package com.organization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.entity.OrganizationEntity;

/**
 * @author chandresh.mishra
 *
 */
public interface OrganizationRepository extends JpaRepository<OrganizationEntity, Integer>{

	OrganizationEntity findById(Integer id);
	
}
