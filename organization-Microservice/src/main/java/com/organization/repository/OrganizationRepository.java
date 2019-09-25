/**
 * 
 */
package com.organization.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.entity.OrganizationEntity;

/**
 * @author chandresh.mishra
 *
 */
public interface OrganizationRepository extends JpaRepository<OrganizationEntity, Integer>{

	Optional<OrganizationEntity> findById(Integer id);
	
}
