package org.jboss.labs;

import org.jboss.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class HelloBean implements HelloLocal{
    private static final Logger log = Logger.getLogger(HelloBean.class);

    @Override
    public String sayHello() {
        return "Hello";
    }
}
