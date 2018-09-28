package com.person.repository;

import com.person.dto.OrganizationDTO;


public interface OrganizationRedisRepository {
    void saveOrganization(OrganizationDTO org);
    void updateOrganization(OrganizationDTO org);
    void deleteOrganization(int organizationId);
    OrganizationDTO findOrganization(int organizationId);
}
