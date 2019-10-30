/**
 * 
 */
package com.person.dto.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.person.dto.OrganizationDTO;

/**
 * @author chandresh.mishra
 *
 */
@FeignClient(name = "organizationservice", configuration = OrganizationClientConfig.class)
public interface OrganizationFeignClient {

	@GetMapping(path = "/getOrganization/{id}", produces = "application/json")
	public ResponseEntity<OrganizationDTO> getOrganization(@PathVariable("id") Integer id);

}
