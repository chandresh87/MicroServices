/**
 * 
 */
package com.person.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.person.entity.Person;
import com.person.model.PersonRequestModel;
import com.person.model.PersonResponseModel;

/**
 * @author chandresh.mishra
 *
 */
@Mapper(componentModel="spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface PersonMapper {

	public Person personModelToPerson(PersonRequestModel personModel); 
	
	public PersonResponseModel personToPersonResponse(Person person);
}
