package com.person.dto.client;

import com.person.exception.PersonRemoteServiceException;

import feign.Response;
import feign.codec.ErrorDecoder;

/**
 * Custom error decoder for the Feign client calling a person microservice.
 *
 * @author chandresh.mishra
 */
public class OrganizationErrorDecoder implements ErrorDecoder {

  @Override
  public Exception decode(String methodKey, Response response) {

    if (response.status() == 422) {
      return new PersonRemoteServiceException(
          String.valueOf(response.status()), "Not able to process the request", new Throwable());
    } else
      return new PersonRemoteServiceException(
          String.valueOf(response.status()), response.reason(), new Throwable());
  }
}
