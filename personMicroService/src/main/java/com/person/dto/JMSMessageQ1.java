/**
 * 
 */
package com.person.dto;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author chandresh.mishra
 *
 */
public class JMSMessageQ1 implements Serializable {

	  private static final long serialVersionUID = 1L;
	  /* Name of the file */
	  private String fileName;
	  /* Location of the file */
	  private String fileLocation;
	  /* Source of the file */
	  private String source;
	  /* message Date Time stamp*/
	  //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	  private String messageDateTime;
	  
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getMessageDateTime() {
		return messageDateTime;
	}
	public void setMessageDateTime(String messageDateTime) {
		this.messageDateTime = messageDateTime;
	}
	

}
