package com.successfactors.sfrpc.utils;

import com.successfactors.sfrpc.SerializableObject;
import com.successfactors.sfrpc.message.impl.RPCObject;

/**
 * Created by I322901 on 3/13/2017.
 */
public class RPCUtils {

  public static Class<?>[] getParameterTypes(Object... args) {
    if (args == null) {
      return new Class<?>[0];
    }

    Class<?>[] parameterTypes = new Class<?>[args.length];
    for (int i = 0; i < args.length; i++) {
      parameterTypes[i] = args[i].getClass();
    }
    return parameterTypes;
  }

  public static SerializableObject[] decorate(Object... args) {
    if (args == null) {
      return new SerializableObject[0];
    }

    SerializableObject[] serializableObjects = new SerializableObject[args.length];
    for (int i = 0; i < args.length; i++) {
      serializableObjects[i] = new RPCObject(args[i]);
    }
    return serializableObjects;
  }

  public static Object[] undecorate(SerializableObject... serializableObjects) {
    if (serializableObjects == null) {
      return new Object[0];
    }

    Object[] args = new Object[serializableObjects.length];
    for (int i = 0; i < args.length; i++) {
      args[i] = serializableObjects[i].get();
    }
    return args;
  }
}
