package com.successfactors.sfrpc.exception;

/**
 * Created by I322901 on 3/13/2017.
 */
public class RpcException extends RuntimeException {
  public RpcException() {
    super();
  }

  public RpcException(String message) {
    super(message);
  }

  public RpcException(String message, Throwable cause) {
    super(message, cause);
  }

  public RpcException(Throwable cause) {
    super(cause);
  }
}
