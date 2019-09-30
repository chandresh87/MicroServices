/**
 * 
 */
package com.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.person.entity.Person;
import com.person.repository.PersonRepository;

/**
 * @author chandresh.mishra
 *
 */
@Service
public class PersonServiceData {

	@Autowired
	private PersonRepository personRepository;
	
	public void savePerson(Person person)
	{
		 personRepository.save(person);
	}
	
	
	@HystrixCommand
	public Person fetchPerson(String nino)
	{
		return personRepository.findByNino(nino);
	}
	
}
