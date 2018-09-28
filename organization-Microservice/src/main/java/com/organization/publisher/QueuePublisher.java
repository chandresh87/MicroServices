/**
 * 
 */
package com.organization.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.organization.dto.OrganizationDTO;

/**
 * Publish the message to the queue.
 * 
 * @author chandresh.mishra
 *
 */
@Component
public class QueuePublisher {
	

    private Source source;

    private static final Logger logger = LoggerFactory.getLogger(QueuePublisher.class);

    @Autowired
    public QueuePublisher(Source source){
        this.source = source;
    }

    public void publishOrgChange(OrganizationDTO organizationDTO){
       logger.debug("Sending  message {} for Organization Id: {}", organizationDTO.getId());
        

        source.output().send(MessageBuilder.withPayload(organizationDTO).build());
    }


}
