package com.successfactors.sfrpc;

import com.successfactors.sfrpc.message.Message;

/**
 * Created by I322901 on 2/18/2017.
 */
public interface ServiceProvider {

  void initialize();

  void register(Class serviceInterface, Class serviceImplement);

  void receive(Message message);

  void tearDown();

  boolean isAvailable();
}
