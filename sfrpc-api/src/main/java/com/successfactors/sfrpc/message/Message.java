package com.successfactors.sfrpc.message;

import com.successfactors.sfrpc.connection.Connection;

/**
 * Created by I322901 on 2/18/2017.
 */
public interface Message {

  String id();

  Connection sender();

  MessageContent content();

  long timeout();
}
