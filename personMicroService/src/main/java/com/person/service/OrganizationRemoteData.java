package com.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.person.dto.OrganizationDTO;
import com.person.dto.client.OrganizationFeignClient;

@Component
public class OrganizationRemoteData {
	@Autowired
	public OrganizationFeignClient organizationClient;


	public OrganizationDTO getRemoteOrgData(int organizationId) {
		OrganizationDTO organizationDTO;
		ResponseEntity<OrganizationDTO> reponse = organizationClient.getOrganization(organizationId);
		organizationDTO = reponse.getBody();
		return organizationDTO;
	}
}