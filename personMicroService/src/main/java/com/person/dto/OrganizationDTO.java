/**
 * 
 */
package com.person.dto;

import java.io.Serializable;

/**
 * @author chandresh.mishra
 *
 */
public class OrganizationDTO implements Serializable{
	
	private static final long serialVersionUID = -3958163659593870535L;
	
	private Integer id;
	private String organizationName;
	private String location;
	/**
	 * @return the organizationName
	 */
	public String getOrganizationName() {
		return organizationName;
	}
	/**
	 * @param organizationName the organizationName to set
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "OrganizationDTO [id=" + id + ", organizationName=" + organizationName + ", location=" + location + "]";
	}
	

}
