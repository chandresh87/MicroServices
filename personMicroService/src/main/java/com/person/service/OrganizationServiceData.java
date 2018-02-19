/**
 * 
 */
package com.person.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.person.dto.OrganizationDTO;
import com.person.dto.client.OrganizationClient;

/**
 * @author chandresh.mishra
 *
 */
@Component
public class OrganizationServiceData {
	
	@Autowired
	private OrganizationClient organizationClient;
	
	@HystrixCommand(fallbackMethod="buildFallBackOrganization")
	public OrganizationDTO getOrganizationData(int OrganizationId)
	{
		randomlyRunLong();  // Testing 
		ResponseEntity<OrganizationDTO> reponse= organizationClient.getOrganization(OrganizationId);
		OrganizationDTO organizationDTO=reponse.getBody();
		return organizationDTO;
	}
	
	//FallBack method used by the Hytrix
	private  OrganizationDTO buildFallBackOrganization(int OrganizationId)
	{
		OrganizationDTO organizationDTO=new  OrganizationDTO();
		organizationDTO.setLocation("Unknown");
		organizationDTO.setOrganizationName("Unknown");
		return organizationDTO;
	}

	/*Testing Hytrix cirtuit Breaker
	{
	    "timestamp": 1518218372390,
	    "status": 500,
	    "error": "Internal Server Error",
	    "exception": "com.netflix.hystrix.exception.HystrixRuntimeException",
	    "message": "getPerson timed-out and fallback failed.",
	    "path": "/getPerson"
	}*/
	private void randomlyRunLong(){
		Random rand = new Random();
		int randomNum = rand.nextInt((3 - 1) + 1) + 1;
		if (randomNum==3) sleep();
		}
		private void sleep(){
		try {
		Thread.sleep(12000);
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
		}
}
