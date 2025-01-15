package org.jboss.labs;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Stateless
@LocalBean
public class HelloDate implements HelloDateLocal{

    @EJB
    HelloLocal helloLocal;

    static DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss z");

    @Override
    public String sayHelloDate() {
        return helloLocal.sayHello() + " today date/time is : " + dateFormat.format(new Date());
    }
}
