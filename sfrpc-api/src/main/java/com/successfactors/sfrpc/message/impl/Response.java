package com.successfactors.sfrpc.message.impl;

import com.successfactors.sfrpc.connection.Connection;
import com.successfactors.sfrpc.message.Message;
import com.successfactors.sfrpc.message.Result;

/**
 * Created by I322901 on 3/13/2017.
 */
public class Response implements Message {

  private String requestId;
  private Result content;
  private Connection self;

  public Response(Connection self, String requestId, Object result) {
    this(self, requestId);
    this.content = new ResponseContent(result);
  }

  public Response(Connection self, String requestId, Throwable exception) {
    this(self, requestId);
    this.content = new ResponseContent(exception);
  }

  private Response(Connection self, String requestId) {
    this.self = self;
    this.requestId = requestId;
  }

  @Override
  public String id() {
    return requestId;
  }

  @Override
  public Connection sender() {
    return self;
  }

  @Override
  public Result content() {
    return content;
  }

  @Override
  public long timeout() {
    return 0;
  }

  class ResponseContent implements Result {

    private Object result;
    private Throwable exception;

    public ResponseContent(Object result) {
      this.result = result;
    }

    public ResponseContent(Throwable exception) {
      this.exception = exception;
    }

    @Override
    public Object getValue() {
      return new RPCObject(result).get();
    }

    @Override
    public Throwable getException() {
      return exception;
    }

    @Override
    public boolean hasException() {
      return exception != null;
    }
  }
}
