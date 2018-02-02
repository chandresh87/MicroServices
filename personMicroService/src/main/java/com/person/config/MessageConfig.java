/**
 * 
 */
package com.person.config;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author chandresh.mishra
 *
 */
@Component
@RefreshScope
public class MessageConfig {

	@Value(value = "${success.message}")
	private String successMessage;

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	
	
}
