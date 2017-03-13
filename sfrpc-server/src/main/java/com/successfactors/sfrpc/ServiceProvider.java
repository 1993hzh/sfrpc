package com.successfactors.sfrpc;

import com.successfactors.sfrpc.connection.ConnectionAware;
import com.successfactors.sfrpc.message.Invocation;

/**
 * Created by I322901 on 2/18/2017.
 */
public interface ServiceProvider extends ConnectionAware {

  int PORT = 9000;

  void init();

  Object receive(Invocation invocation) throws Throwable;

  void run();

  void stop();

  boolean isAvailable();
}
