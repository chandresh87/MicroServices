/**
 * 
 */
package com.person.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author chandresh.mishra
 *
 */
public interface OrganizationChannel {

	@Input("inboundOrgChanges")
    SubscribableChannel orgs();
}
