package org.jboss.labs;

import org.wildfly.naming.client.WildFlyInitialContextFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.security.PrivilegedActionException;
import java.util.Properties;

public class EJBClient {
    public static void main(String[] args) throws NamingException, PrivilegedActionException, InterruptedException {
        InitialContext ctx = new InitialContext(getCtxProperties());
        String lookupName = "ejb:/ejbr/HelloEJB!org.jboss.labs.HelloRemote";
        HelloRemote bean = (HelloRemote)ctx.lookup(lookupName);
        System.out.println(bean.sayHello(" ejb "));
        ctx.close();
    }
    public static Properties getCtxProperties() {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, WildFlyInitialContextFactory.class.getName());
        props.put(Context.PROVIDER_URL, "remote+http://192.168.1.115:8080");
        props.put(Context.SECURITY_PRINCIPAL, "admin");
        props.put(Context.SECURITY_CREDENTIALS, "jboss10)");
        return props;
    }
}
