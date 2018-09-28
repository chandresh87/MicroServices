package com.organization.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.organization.dto.OrganizationDTO;
import com.organization.entity.OrganizationEntity;

/**
 * 
 * @author chandresh.mishra
 *
 */
@Mapper(componentModel="Spring" ,unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface OrganizationDTOMapper {
	
	OrganizationDTO entityToDTO(OrganizationEntity entity);

}
