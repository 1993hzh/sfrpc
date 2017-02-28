package com.successfactors.sfrpc;

import com.successfactors.sfrpc.message.Message;

import java.io.IOException;

/**
 * Created by I322901 on 2/18/2017.
 */
public interface ServiceConsumer {

  void send(Message request) throws IOException;
}
