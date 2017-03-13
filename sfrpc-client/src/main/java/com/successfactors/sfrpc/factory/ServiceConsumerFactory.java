package com.successfactors.sfrpc.factory;

import com.successfactors.sfrpc.DefaultServiceConsumer;
import com.successfactors.sfrpc.ServiceConsumer;
import com.successfactors.sfrpc.router.Router;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by I322901 on 3/13/2017.
 */
public class ServiceConsumerFactory {

  private Map<String, ServiceConsumer> map;
  private Router router;

  public ServiceConsumerFactory() {
    map = new ConcurrentHashMap<>();
    //    router;
  }

  public ServiceConsumer getConsumer(String serviceName) {
    ServiceConsumer consumer = map.get(serviceName);

    if (consumer == null) {
      consumer = new DefaultServiceConsumer(router, serviceName);
      map.put(serviceName, consumer);
    }
    return consumer;
  }

  public static ServiceConsumerFactory getInstance() {
    return ServiceConsumerFactoryHolder.INSTANCE;
  }

  private static class ServiceConsumerFactoryHolder {
    private static final ServiceConsumerFactory INSTANCE = new ServiceConsumerFactory();
  }
}
