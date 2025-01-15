package org.jboss.labs;

import javax.ejb.Remote;

@Remote
public interface HelloRemote {
    String sayHello(String name);
}
