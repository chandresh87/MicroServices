/**
 * 
 */
package com.person.remote.jms;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import com.person.channel.OrganizationChannel;
import com.person.dto.OrganizationDTO;
import com.person.repository.OrganizationRedisRepository;

/**
 * Listener to organisation change and update the Redis database
 * 
 * @author chandresh.mishra
 *
 */
@EnableBinding(OrganizationChannel.class)
@Component
public class OrganizationChangeListner {
	
	 @Autowired
	 private  OrganizationRedisRepository orgRedisRepo;
	 private static Logger LOGGER =
		      LoggerFactory.getLogger(OrganizationChangeListner.class);
	 
	 @StreamListener("inboundOrgChanges")
	 public void orgChange(OrganizationDTO organizationDTO) {
		 LOGGER.debug("Received a message to evict cache for {}",organizationDTO);
		 orgRedisRepo.deleteOrganization(organizationDTO.getId());
}
}