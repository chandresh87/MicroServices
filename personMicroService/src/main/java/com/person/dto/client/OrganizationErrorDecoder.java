package com.person.dto.client;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;

import com.person.exception.BadRequestException;
import com.person.exception.PersonRemoteServiceException;

import feign.Response;
import feign.codec.ErrorDecoder;

/**
 * Custom error decoder for the Feign client calling a organisation microservice.
 *
 * @author chandresh.mishra
 */
public class OrganizationErrorDecoder implements ErrorDecoder {

 
  @Override
  public Exception decode(String methodKey, Response response) {

    final int status = response.status();

    try (InputStream input = response.body() == null ? null : response.body().asInputStream()) {

      return getErrorResponse(response, status, input);

    } catch (IOException e) {
      return new PersonRemoteServiceException(status, response.reason());
    }
  }

  private Exception getErrorResponse(Response response, final int status, InputStream input)
      throws IOException {

      if (status == HttpStatus.BAD_REQUEST.value()) {

      return input == null
          ? new BadRequestException(status, response.reason())
          : new BadRequestException(status, response.reason(), IOUtils.toString(input, "UTF-8"));

    } else {
      return new PersonRemoteServiceException(status, response.reason());
    }
  }
}
