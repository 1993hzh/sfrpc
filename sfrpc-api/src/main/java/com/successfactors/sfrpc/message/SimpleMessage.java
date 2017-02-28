package com.successfactors.sfrpc.message;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * Created by I322901 on 2/18/2017.
 */
public class SimpleMessage implements Message, Serializable {

  private Message message;

  public SimpleMessage(Message message) {
    this.message = message;
  }

  @Override
  public Class getService() {
    return null;
  }

  @Override
  public Method getMethod() {
    return null;
  }
}
