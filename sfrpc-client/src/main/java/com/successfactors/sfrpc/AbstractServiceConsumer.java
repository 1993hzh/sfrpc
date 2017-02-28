package com.successfactors.sfrpc;

import com.successfactors.sfrpc.router.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by I322901 on 2/18/2017.
 */
public abstract class AbstractServiceConsumer implements ServiceConsumer {

  protected final static Logger log = LogManager.getLogger(AbstractServiceConsumer.class);

  protected Router router;

  public AbstractServiceConsumer(Router router) {
    this.router = router;
  }

}
