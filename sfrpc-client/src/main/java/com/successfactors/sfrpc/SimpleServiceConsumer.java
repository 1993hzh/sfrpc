package com.successfactors.sfrpc;

import com.successfactors.sfrpc.connection.Connection;
import com.successfactors.sfrpc.message.Message;
import com.successfactors.sfrpc.message.SimpleMessage;
import com.successfactors.sfrpc.router.Router;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by I322901 on 2/18/2017.
 */
public class SimpleServiceConsumer extends AbstractServiceConsumer {

  private Socket socket;

  public SimpleServiceConsumer(Router router) {
    super(router);

    try {
      initialize();
    } catch (IOException e) {
      log.error(e);
    }
  }

  private void initialize() throws IOException {
    if (socket == null || socket.isClosed()) {
      socket = openConnection(router.route());
    }
  }

  @Override
  public void send(Message request) throws IOException {
    ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
    os.writeObject(request);
    os.flush();

    ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
    try {
      Message response = (Message) is.readObject();
    } catch (ClassNotFoundException e) {
      log.error(e);
    }
  }

  private Socket openConnection(Connection connection) throws IOException {
    Socket socket = new Socket(connection.getHost(), connection.getPort());
    return socket;
  }

}
