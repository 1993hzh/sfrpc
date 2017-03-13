package com.successfactors.sfrpc.message.impl;

import com.successfactors.sfrpc.exception.RpcException;
import com.successfactors.sfrpc.SerializableObject;

import java.io.Serializable;

/**
 * Created by I322901 on 3/13/2017.
 */
public class RPCObject implements SerializableObject {

  private Object obj;

  public RPCObject(Object obj) {
    if (!obj.getClass().isAssignableFrom(Serializable.class)) {
      throw new RpcException("Not a serializable object: " + obj.getClass().getSimpleName());
    }
    this.obj = obj;
  }

  @Override
  public Object get() {
    return obj;
  }
}
