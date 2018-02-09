/**
 * 
 */
package com.person.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.person.dto.OrganizationDTO;
import com.person.dto.client.OrganizationClient;
import com.person.entity.Person;
import com.person.mapper.PersonMapper;
import com.person.model.PersonResponseModel;
import com.person.repository.PersonRepository;

/**
 * @author chandresh.mishra
 *
 */
@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private OrganizationClient organizationClient;
	
	@Autowired
	private PersonMapper personMapper;
	
	//BO to Entity should be used but BO is not used just for simplification.
	public void savePerson(Person person)
	{
		 personRepository.save(person);
	}
	
	//It should return a business object in place of model. Model used just for simplification.
	
	public PersonResponseModel getPerson(String nino,int id)
	{
		Person person=fetchPerson(nino);
		PersonResponseModel personResponseModel=personMapper.personToPersonResponse(person);
		
		ResponseEntity<OrganizationDTO> reponse= organizationClient.getOrganization(id);
		OrganizationDTO organizationDTO=reponse.getBody();
		
		personResponseModel.setEmployerName(organizationDTO.getOrganizationName());
		personResponseModel.setLocation(organizationDTO.getLocation());
		return personResponseModel;
		
	}
	
	@Transactional(readOnly = true)
	private Person fetchPerson(String nino)
	{
		return personRepository.findByNino(nino);
	}
}
