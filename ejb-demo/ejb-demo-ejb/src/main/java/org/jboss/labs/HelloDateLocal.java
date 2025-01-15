package org.jboss.labs;

import javax.ejb.Local;
import java.util.Date;

@Local
public interface HelloDateLocal {
    public String sayHelloDate();
}
