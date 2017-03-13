package com.successfactors.sfrpc.connection;

/**
 * Created by I322901 on 3/12/2017.
 */
public class DefaultConnection implements Connection {

  private String host;
  private int port;
  private ConnectionStatus status;

  public DefaultConnection(String host, int port) {
    this.host = host;
    this.port = port;
    this.status = ConnectionStatus.ACTIVE;
  }

  @Override
  public String host() {
    return host;
  }

  @Override
  public int port() {
    return port;
  }

  @Override
  public boolean isActive() {
    return ConnectionStatus.ACTIVE.equals(status);
  }

  @Override
  public void setStatus(ConnectionStatus status) {

  }
}
