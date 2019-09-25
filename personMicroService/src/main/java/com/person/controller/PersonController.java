/**
 * 
 */
package com.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.person.config.MessageConfig;
import com.person.dto.JMSMessageQ1;
import com.person.entity.Person;
import com.person.mapper.PersonMapper;
import com.person.model.PersonRequestModel;
import com.person.model.PersonResponseModel;
import com.person.remote.jms.JMSSourceBean;
import com.person.repository.PersonRepository;
import com.person.service.PersonService;

/**
 * @author chandresh.mishra
 *
 */
@RestController
@RefreshScope
public class PersonController {
	
	@Autowired
	private PersonMapper personMapper;
	
	@Autowired
	private PersonService personService;
	
	@Autowired 
	private MessageConfig messageConfig;
	
	//@Autowired 
	private JMSSourceBean jmsSourceBean;
	
	@PostMapping(path="/savePerson" ,consumes="application/json")
	public ResponseEntity<String> savePerson(@RequestBody PersonRequestModel personModel)
	{
		Person person=personMapper.personModelToPerson(personModel);
		System.out.println("person is " + person );
		personService.savePerson(person);
		ResponseEntity<String> response= new ResponseEntity<String>(messageConfig.getSuccessMessage(), HttpStatus.CREATED);
		return response;
	}
	
	@GetMapping(path="/getPerson" ,produces="application/json")
	public PersonResponseModel getPersonDetails(@RequestParam String nino, @RequestParam int id)
	{
		
		return personService.getPerson(nino, id);
		
	}

	@PostMapping(path="/pushEvent" ,produces="application/json",consumes="application/json")
	public ResponseEntity<String> eventUpdate(@RequestBody JMSMessageQ1 message)
	{
		jmsSourceBean.pushToJMS(message);
		ResponseEntity<String> response= new ResponseEntity<String>(" {\"message\": \"Message queued\"}", HttpStatus.CREATED);
		return response;
	}
}
