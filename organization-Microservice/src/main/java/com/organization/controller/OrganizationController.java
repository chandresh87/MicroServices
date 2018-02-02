/**
 * 
 */
package com.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.organization.entity.Organization;
import com.organization.mapper.OrganizationMapper;
import com.organization.model.OrganizationModel;
import com.organization.service.OrganizationService;

/**
 * @author chandresh.mishra
 *
 */
@RestController
public class OrganizationController {

	@Autowired
	private OrganizationMapper organizationMapper;
	
	@Autowired
	private OrganizationService organizationService;
	
	@PostMapping(path="/saveOrganization" ,consumes="application/json")
	public ResponseEntity<String> saveOrganization(@RequestBody OrganizationModel organizationModel)
	{
		Organization organization=organizationMapper.organizationModelToEntity(organizationModel);
		organizationService.saveOrganization(organization);
		ResponseEntity<String> response= new ResponseEntity<String>("saved successfully", HttpStatus.CREATED);
		return response;
	}
	
	@GetMapping(path="/getOrganization" ,produces="application/json")
	public ResponseEntity<OrganizationModel> getOrganization(@PathVariable Integer id)
	{
		OrganizationModel organizationModel=organizationMapper.organizationEntityToModel(organizationService.fetchOrganization(id));
		ResponseEntity<OrganizationModel> response= new ResponseEntity<OrganizationModel>(organizationModel, HttpStatus.OK);
		return response;
	}
}
