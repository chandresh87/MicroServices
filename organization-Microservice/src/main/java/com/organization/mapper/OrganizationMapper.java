/**
 * 
 */
package com.organization.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.organization.entity.OrganizationEntity;
import com.organization.model.OrganizationModel;

/**
 * @author chandresh.mishra
 *
 */
@Mapper(componentModel="Spring" ,unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface OrganizationMapper {

	OrganizationEntity organizationModelToEntity(OrganizationModel model);
	
	
	OrganizationModel organizationEntityToModel(OrganizationEntity entity);
}
