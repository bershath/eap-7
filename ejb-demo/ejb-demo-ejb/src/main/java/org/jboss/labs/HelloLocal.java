package org.jboss.labs;

import javax.ejb.Local;

@Local
public interface HelloLocal {
    public String sayHello();
}
