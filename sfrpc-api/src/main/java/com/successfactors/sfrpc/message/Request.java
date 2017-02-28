package com.successfactors.sfrpc.message;

import java.lang.reflect.Method;

/**
 * Created by I322901 on 2/18/2017.
 */
public class Request implements Message {
  @Override
  public Class getService() {
    return null;
  }

  @Override
  public Method getMethod() {
    return null;
  }
}
