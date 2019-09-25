package com.person.exception;

/**
 * Custom remote service exception class for Person.
 *
 * @author chandresh.mishra
 */
public class PersonRemoteServiceException extends RuntimeException {

  private static final long serialVersionUID = -1L;

  private final int code;

  /**
   * Constructs remote service exception with code, message and cause.
   *
   * @param code
   * @param message
   * @param rootCause
   */
  public PersonRemoteServiceException(int code, String message, Throwable cause) {
    super(message, cause);
    this.code = code;
  }

  /**
   * Call remote service exception with message and cause.
   *
   * @param message
   * @param cause
   */
  public PersonRemoteServiceException(String message, Throwable cause) {
    super(message, cause);
    this.code=500;
  }

  public PersonRemoteServiceException(int code, String reason) {
	    super(reason);
	    this.code =code;
  }

/** Returns a string consisting of the name, code, message and cause for this exception. */
  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    str.append("\nName : " + this.getClass().getSimpleName());
    str.append("\nCode : " + this.code);
    str.append("\nMessage : " + this.getMessage());
    str.append("\nCause : " + this.getCause());

    return str.toString();
  }
}
