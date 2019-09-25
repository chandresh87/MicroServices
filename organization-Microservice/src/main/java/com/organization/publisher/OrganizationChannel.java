/**
 * 
 */
package com.organization.publisher;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author chandresh.mishra
 *
 */
public interface OrganizationChannel {

	@Output("inboundOrgChanges")
    MessageChannel orgs();
}
