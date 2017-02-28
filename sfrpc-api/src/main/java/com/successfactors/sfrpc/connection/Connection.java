package com.successfactors.sfrpc.connection;

import java.net.URL;

/**
 * Created by I322901 on 2/18/2017.
 */
public interface Connection {

  String getHost();

  int getPort();

  boolean isActive();
}
