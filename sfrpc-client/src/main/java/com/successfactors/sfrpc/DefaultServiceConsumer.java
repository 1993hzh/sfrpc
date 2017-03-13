package com.successfactors.sfrpc;

import com.successfactors.sfrpc.connection.Connection;
import com.successfactors.sfrpc.message.Message;
import com.successfactors.sfrpc.message.Result;
import com.successfactors.sfrpc.message.impl.Response;
import com.successfactors.sfrpc.router.Router;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by I322901 on 2/18/2017.
 */
public class DefaultServiceConsumer extends AbstractServiceConsumer {

  private Socket socket;

  public DefaultServiceConsumer(Router router, String serviceName) {
    super(router, serviceName);

    try {
      initialize(serviceName);
    } catch (IOException e) {
      log.error(e);
    }
  }

  private void initialize(String serviceName) throws IOException {
    if (socket == null || socket.isClosed()) {
      socket = openConnection(router.route(serviceName));
    }
  }

  @Override
  public Result send(Message request) throws Exception {
    ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
    os.writeObject(request);
    os.flush();

    ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
    Response response = (Response) is.readObject();

    return response.content();
  }

  @Override
  public Connection getSelf() {
    return null;
  }

  private Socket openConnection(Connection connection) throws IOException {
    Socket socket = new Socket(connection.host(), connection.port());
    return socket;
  }

}
