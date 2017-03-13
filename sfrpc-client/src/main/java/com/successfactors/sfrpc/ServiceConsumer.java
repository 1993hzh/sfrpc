package com.successfactors.sfrpc;

import com.successfactors.sfrpc.connection.ConnectionAware;
import com.successfactors.sfrpc.message.Message;
import com.successfactors.sfrpc.message.Result;

/**
 * Created by I322901 on 2/18/2017.
 */
public interface ServiceConsumer extends ConnectionAware {

  Result send(Message request) throws Exception;

}
