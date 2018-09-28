/**
 * 
 */
package com.person.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.person.entity.Person;

/**
 * @author chandresh.mishra
 *
 */
@Repository
public interface PersonRepository extends  JpaRepository<Person, String>{

	//@Query("select p from Person p where p.nino = :nino")
	Person findByNino( String nino);
	 
}
