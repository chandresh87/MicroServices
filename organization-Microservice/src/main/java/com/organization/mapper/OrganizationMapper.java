/**
 * 
 */
package com.organization.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.organization.entity.Organization;
import com.organization.model.OrganizationModel;

/**
 * @author chandresh.mishra
 *
 */
@Mapper(componentModel="Spring" ,unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface OrganizationMapper {

	Organization organizationModelToEntity(OrganizationModel model);
	
	
	OrganizationModel organizationEntityToModel(Organization entity);
}
