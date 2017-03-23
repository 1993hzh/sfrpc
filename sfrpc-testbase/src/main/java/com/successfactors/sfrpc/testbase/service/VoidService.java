package com.successfactors.sfrpc.testbase.service;

import com.successfactors.sfrpc.testbase.StatusEnum;

/**
 * Created by I322901 on 3/20/2017.
 */
public class VoidService implements Service<Void> {

  private StatusEnum status = StatusEnum.INITIAL;

  public Void invoke() {
    status = StatusEnum.CHANGED;
    return null;
  }

  public StatusEnum getStatus() {
    return status;
  }
}
