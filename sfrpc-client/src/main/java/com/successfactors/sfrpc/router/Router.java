package com.successfactors.sfrpc.router;

import com.successfactors.sfrpc.connection.Connection;

/**
 * Created by I322901 on 2/18/2017.
 */
public interface Router {

  Connection route(String serviceName);
}
