package com.successfactors.sfrpc.connection;

/**
 * Created by I322901 on 2/18/2017.
 */
public interface Connection {

  String host();

  int port();

  boolean isActive();

  void setStatus(ConnectionStatus status);

  public enum ConnectionStatus {
    ACTIVE, INACTIVE
  }
}
