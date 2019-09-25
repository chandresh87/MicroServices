/**
 * 
 */
package com.organization.model;

/**
 * @author chandresh.mishra
 *
 */
public class OrganizationModel {

	private Integer id;
	private String organizationName;
	private String location;
	
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
