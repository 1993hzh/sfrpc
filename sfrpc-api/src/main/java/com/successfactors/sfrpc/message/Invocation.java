package com.successfactors.sfrpc.message;

/**
 * Created by I322901 on 3/12/2017.
 */
public interface Invocation extends MessageContent {

  String serviceName();

  String methodName();

  Object[] args();

  Class<?>[] parameterTypes();
}
