/**
 * 
 */
package com.person.mapper;

import org.mapstruct.Mapper;

import com.person.entity.Person;
import com.person.model.PersonModel;

/**
 * @author chandresh.mishra
 *
 */
@Mapper(componentModel="spring")
public interface PersonMapper {

	public Person personModelToPerson(PersonModel personModel); 
}
