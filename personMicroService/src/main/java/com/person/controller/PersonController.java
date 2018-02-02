/**
 * 
 */
package com.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.person.config.MessageConfig;
import com.person.entity.Person;
import com.person.mapper.PersonMapper;
import com.person.model.PersonModel;
import com.person.repository.PersonRepository;

/**
 * @author chandresh.mishra
 *
 */
@RestController
public class PersonController {
	
	@Autowired
	private PersonMapper personMapper;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired 
	private MessageConfig messageConfig;
	
	
	
	@PostMapping(path="/savePerson" ,consumes="application/json")
	public ResponseEntity<String> savePerson(@RequestBody PersonModel personModel)
	{
		Person person=personMapper.personModelToPerson(personModel);
		personRepository.save(person);
		ResponseEntity<String> response= new ResponseEntity<String>(messageConfig.getSuccessMessage(), HttpStatus.CREATED);
		return response;
	}

}
