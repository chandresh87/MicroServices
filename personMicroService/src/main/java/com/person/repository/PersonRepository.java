/**
 * 
 */
package com.person.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.person.entity.Person;

/**
 * @author chandresh.mishra
 *
 */
public interface PersonRepository extends  JpaRepository<Person, String>{

	//@Query("select p from Person p where p.nino = :nino")
	Person findByNino( String nino);
}
