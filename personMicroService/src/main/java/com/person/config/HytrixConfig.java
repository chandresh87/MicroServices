/**
 * 
 */
package com.person.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author chandresh.mishra
 *
 */
@Component
@RefreshScope
public class HytrixConfig {/*

	@Value(value = "${hystrix.command.circuitBreaker.requestVolumeThreshold}")
	private  String requestVolumeThreshold;
	
	@Value(value = "${hystrix.command.circuitBreaker.errorThresholdPercentage}")
	private String errorThresholdPercentage;
	
	@Value(value = "${hystrix.command.circuitBreaker.sleepWindowInMilliseconds}")
	private String sleepWindowInMilliseconds;
	
	@Value(value = "${hystrix.command.metrics.rollingStats.timeInMilliseconds}")
	private String timeInMilliseconds;
	
	@Value(value = "${hystrix.command.metrics.rollingStats.numBuckets}")
	private String numBuckets;

	public String getRequestVolumeThreshold() {
		return requestVolumeThreshold;
	}

	public void setRequestVolumeThreshold(String requestVolumeThreshold) {
		this.requestVolumeThreshold = requestVolumeThreshold;
	}

	public String getErrorThresholdPercentage() {
		return errorThresholdPercentage;
	}

	public void setErrorThresholdPercentage(String errorThresholdPercentage) {
		this.errorThresholdPercentage = errorThresholdPercentage;
	}

	public String getSleepWindowInMilliseconds() {
		return sleepWindowInMilliseconds;
	}

	public void setSleepWindowInMilliseconds(String sleepWindowInMilliseconds) {
		this.sleepWindowInMilliseconds = sleepWindowInMilliseconds;
	}

	public String getTimeInMilliseconds() {
		return timeInMilliseconds;
	}

	public void setTimeInMilliseconds(String timeInMilliseconds) {
		this.timeInMilliseconds = timeInMilliseconds;
	}

	public String getNumBuckets() {
		return numBuckets;
	}

	public void setNumBuckets(String numBuckets) {
		this.numBuckets = numBuckets;
	}
	
	
	
	
*/}
