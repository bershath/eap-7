package org.jboss.labs;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
public class HelloEJB implements HelloRemote{
    @Override
    public String sayHello(String name) {
        return "Hello "+ name;
    }
}
