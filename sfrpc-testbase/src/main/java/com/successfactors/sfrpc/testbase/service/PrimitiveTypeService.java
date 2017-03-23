package com.successfactors.sfrpc.testbase.service;

import com.successfactors.sfrpc.testbase.StatusEnum;

/**
 * Created by I322901 on 3/20/2017.
 */
public class PrimitiveTypeService implements Service<Integer> {

  public static final int RETURN_VALUE = 1;
  private StatusEnum status = StatusEnum.INITIAL;

  public StatusEnum getStatus() {
    return status;
  }

  @Override
  public Integer invoke() {
    status = StatusEnum.CHANGED;
    return RETURN_VALUE;
  }
}
