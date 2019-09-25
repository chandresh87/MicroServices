
package com.person.remote.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.person.dto.JMSMessageQ1;

/**
 * @author chandresh.mishra
 *
 */
//@Component
public class JMSSourceBean {

	
	private Source source;
	
	//@Autowired
	public JMSSourceBean(Source source){
	this.source = source;
	}
	
	public void pushToJMS(JMSMessageQ1 message)
	{
		/*JMSMessageQ1 message=new JMSMessageQ1();
		message.setLocation("C/data");
		message.setName("xyz.txt");*/
		
		this.source
		.output()
		.send(
		MessageBuilder
		.withPayload(message)
		.build());
	}
}
