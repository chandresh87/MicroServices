/**
 * 
 */
package com.person.remote.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

import com.person.dto.OrganizationDTO;
import com.person.repository.OrganizationRedisRepository;

/**
 * Listener to organisation change and update the Redis database
 * 
 * @author chandresh.mishra
 *
 */
@EnableBinding(Sink.class)
@Component
public class OrganizationChangeListner {
	
	 @Autowired
	 private  OrganizationRedisRepository orgRedisRepo;
	 
	 @StreamListener("input")
	 public void orgChange(OrganizationDTO organizationDTO) {

		 orgRedisRepo.deleteOrganization(organizationDTO.getId());
}
}