/**
 * 
 */
package com.person.entity;

import javax.persistence.Column;
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

private Integer employerId;

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
@Column(name="employer_id")
public Integer getEmployerId() {
	return employerId;
}
public void setEmployerId(Integer employerId) {
	this.employerId = employerId;
}
@Column(name="employment_level")
public Integer getEmploymentLevel() {
	return employmentLevel;
}
public void setEmploymentLevel(Integer employmentLevel) {
	this.employmentLevel = employmentLevel;
	
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((nino == null) ? 0 : nino.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Person other = (Person) obj;
	if (nino == null) {
		if (other.nino != null)
			return false;
	} else if (!nino.equals(other.nino))
		return false;
	return true;
}






}
