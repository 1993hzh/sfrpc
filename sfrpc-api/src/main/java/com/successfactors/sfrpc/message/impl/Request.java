package com.successfactors.sfrpc.message.impl;

import com.successfactors.sfrpc.connection.Connection;
import com.successfactors.sfrpc.message.Invocation;
import com.successfactors.sfrpc.message.Message;
import com.successfactors.sfrpc.SerializableObject;
import com.successfactors.sfrpc.utils.RPCUtils;

import java.util.UUID;

/**
 * Created by I322901 on 3/13/2017.
 */
public class Request implements Message {

  private String id;
  private Invocation content;
  private Connection self;

  public Request(Connection self, String serviceName, String methodName, Object[] args) {
    this.content = new RequestContent(serviceName, methodName, RPCUtils.decorate(args));
    this.id = UUID.randomUUID().toString();
    this.self = self;
  }

  @Override
  public String id() {
    return id;
  }

  @Override
  public Connection sender() {
    return self;
  }

  @Override
  public Invocation content() {
    return content;
  }

  @Override
  public long timeout() {
    return 0;
  }

  class RequestContent implements Invocation {

    private String serviceName;
    private String methodName;
    private Class<?>[] parameterTypes;
    private SerializableObject[] args;

    public RequestContent(String serviceName, String methodName, SerializableObject[] args) {
      this.serviceName = serviceName;
      this.methodName = methodName;
      this.parameterTypes = RPCUtils.getParameterTypes(args);
      this.args = args;
    }

    @Override
    public String serviceName() {
      return serviceName;
    }

    @Override
    public String methodName() {
      return methodName;
    }

    @Override
    public Object[] args() {
      return RPCUtils.undecorate(args);
    }

    @Override
    public Class<?>[] parameterTypes() {
      return parameterTypes;
    }
  }
}
