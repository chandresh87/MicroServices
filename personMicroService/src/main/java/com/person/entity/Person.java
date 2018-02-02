/**
 * 
 */
package com.person.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author chandresh.mishra
 *
 */
@Entity
public class Person {
	
private String name;
private String nino;
private String employerName;
private Integer employmentLevel;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Id
public String getNino() {
	return nino;
}
public void setNino(String nino) {
	this.nino = nino;
}
public String getEmployerName() {
	return employerName;
}
public void setEmployerName(String employerName) {
	this.employerName = employerName;
}
public Integer getEmploymentLevel() {
	return employmentLevel;
}
public void setEmploymentLevel(Integer employmentLevel) {
	this.employmentLevel = employmentLevel;
}



}
