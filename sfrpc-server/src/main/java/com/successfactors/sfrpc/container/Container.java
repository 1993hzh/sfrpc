package com.successfactors.sfrpc.container;

import com.successfactors.sfrpc.exception.ServiceNotFoundException;

import java.util.Collection;

/**
 * Created by I322901 on 3/13/2017.
 */
public interface Container {

  Object getInstance(String name) throws ServiceNotFoundException;

  Collection<Object> getInstances();
}
