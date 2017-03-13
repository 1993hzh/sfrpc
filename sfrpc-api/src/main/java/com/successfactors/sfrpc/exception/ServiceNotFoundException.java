package com.successfactors.sfrpc.exception;

/**
 * Created by I322901 on 3/13/2017.
 */
public class ServiceNotFoundException extends Exception {
  public ServiceNotFoundException() {
    super();
  }

  public ServiceNotFoundException(String message) {
    super(message);
  }

  public ServiceNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public ServiceNotFoundException(Throwable cause) {
    super(cause);
  }
}
