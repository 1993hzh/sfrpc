package com.successfactors.sfrpc.message;

import java.lang.reflect.Method;

/**
 * Created by I322901 on 2/18/2017.
 */
public interface Message {

  Class getService();

  Method getMethod();
}
