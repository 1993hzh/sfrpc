package com.successfactors.sfrpc;

import com.successfactors.sfrpc.connection.Connection;
import com.successfactors.sfrpc.container.Container;
import com.successfactors.sfrpc.exception.RpcException;
import com.successfactors.sfrpc.message.Invocation;
import com.successfactors.sfrpc.message.Message;
import com.successfactors.sfrpc.message.impl.RPCObject;
import com.successfactors.sfrpc.message.impl.Request;
import com.successfactors.sfrpc.message.impl.Response;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by I322901 on 3/12/2017.
 */
public class DefaultProvider implements ServiceProvider {

  private ServerSocket serverSocket;
  private Container container;
  private int port;

  public DefaultProvider(Container container) {
    this(PORT, container);
  }

  public DefaultProvider(int port, Container container) {
    this.port = port;
    this.container = container;
  }

  @Override
  public void init() {
    try {
      serverSocket = new ServerSocket(port);
    } catch (IOException e) {
      throw new RpcException(e);
    }
  }

  @Override
  public Object receive(Invocation invocation) throws Throwable {
    String serviceName = invocation.serviceName();

    Object serviceImpl = container.getInstance(serviceName);
    Class serviceClass = serviceImpl.getClass();

    String methodName = invocation.methodName();
    Class[] parameterTypes = invocation.parameterTypes();

    Method method = serviceClass.getDeclaredMethod(methodName, parameterTypes);
    Object[] args = invocation.args();

    return new RPCObject(method.invoke(serviceImpl, args));
  }

  @Override
  public void run() {
    while (isAvailable()) {
      try {
        Socket socket = serverSocket.accept();

        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        Message request = (Message) inputStream.readObject();

        if (request instanceof Request) {
          String requestId = request.id();
          Response response;

          try {
            Object result = receive((Invocation) request.content());
            response = new Response(getSelf(), requestId, result);
          } catch (Throwable e) {
            response = new Response(getSelf(), requestId, e);
          }

          ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
          outputStream.writeObject(response);
          outputStream.flush();
        }
      } catch (IOException | ClassNotFoundException e) {
        throw new RpcException(e);
      }
    }
  }

  @Override
  public void stop() {
    try {
      serverSocket.close();
    } catch (IOException e) {
      throw new RpcException(e);
    }

    serverSocket = null;
  }

  @Override
  public boolean isAvailable() {
    return serverSocket != null && !serverSocket.isClosed();
  }

  @Override
  public Connection getSelf() {
    return null;
  }
}
