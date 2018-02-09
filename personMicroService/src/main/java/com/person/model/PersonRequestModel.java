/**
 * 
 */
package com.person.model;

/**
 * @author chandresh.mishra
 *
 */
public class PersonRequestModel {

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
	public String getNino() {
		return nino;
	}
	public void setNino(String nino) {
		this.nino = nino;
	}
	
	public Integer getEmploymentLevel() {
		return employmentLevel;
	}
	public void setEmploymentLevel(Integer employmentLevel) {
		this.employmentLevel = employmentLevel;
	}
	/**
	 * @return the employerId
	 */
	public Integer getEmployerId() {
		return employerId;
	}
	/**
	 * @param employerId the employerId to set
	 */
	public void setEmployerId(Integer employerId) {
		this.employerId = employerId;
	}
	
	
}
