/**
 * 
 */
package com.person.dto.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.person.dto.OrganizationDTO;

/**
 * @author chandresh.mishra
 *
 */
//@FeignClient("organizationService")
@FeignClient(name="organizationService" ,configuration=OrganizationClientConfig.class)
public interface OrganizationClient {
	
	@GetMapping(path="/getOrganization/{id}" ,produces="application/json")
	public ResponseEntity<OrganizationDTO> getOrganization(@PathVariable("id") Integer id);
	

}
