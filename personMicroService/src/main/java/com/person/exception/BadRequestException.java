package com.person.exception;



/**
 * Response from Find Person MS on receiving Bad Request.
 *
 * @author chandresh.mishra
 */
public class BadRequestException extends PersonRemoteServiceException {

  private static final long serialVersionUID = 1L;

   private final String reason;

  /**
   * Constructs bad request exception with code, message ,reason and cause.
   *
   * @param code
   * @param message
   * @param reason
   * @param cause
   */
  public BadRequestException(int code, String message, String reason, Throwable cause) {
    super(code, message, cause);
    this.reason = reason;
  }

  /**
   * Constructs bad request exception with code, message and reason.
   *
   * @param code
   * @param message
   * @param reason
   */
  public BadRequestException(int code, String message, String reason) {
    super(code, message);
    this.reason = reason;
  }

  /**
   * Constructs bad request exception with code and message.
   *
   * @param code
   * @param message
   */
  public BadRequestException(int code, String message) {
    super(code, message);
    this.reason = "";
  }
  
  
}
