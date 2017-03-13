package com.successfactors.sfrpc.proxy;

import com.successfactors.sfrpc.ServiceConsumer;
import com.successfactors.sfrpc.factory.ServiceConsumerFactory;
import com.successfactors.sfrpc.message.Message;
import com.successfactors.sfrpc.message.Result;
import com.successfactors.sfrpc.message.impl.Request;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by I322901 on 3/13/2017.
 */
public class InvocationProxy implements InvocationHandler {

  private Object instance;

  public InvocationProxy(Object instance) {
    this.instance = instance;
  }

  public static Object decorate(Object obj) {
    return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationProxy(obj));
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    String serviceName = instance.getClass().getSimpleName();

    ServiceConsumer consumer = ServiceConsumerFactory.getInstance().getConsumer(serviceName);

    Message request = new Request(consumer.getSelf(), serviceName, method.getName(), args);

    Result result = consumer.send(request);

    if (result.hasException()) {
      throw result.getException();
    }

    return result.getValue();
  }
}
