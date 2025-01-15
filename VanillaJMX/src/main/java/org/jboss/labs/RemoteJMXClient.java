package org.jboss.labs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.management.ObjectName;
import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class JmxClientEAP7 {
    public static void main(String[] args) throws Exception {
        String host = "remote-hostname";
        int port = 9990;  // management-http port
        String urlString = "service:jmx:remote+http://" + host + ":" + port;
        System.out.println("\n\n\t****  urlString: "+urlString);;
        JMXServiceURL serviceURL = new JMXServiceURL(urlString);

        Map<String, Object> map = new HashMap<>();
        String[] credentials = new String[] { "admin", "jboss10)" };
        map.put("jmx.remote.credentials", credentials);
        JMXConnector jmxConnector = JMXConnectorFactory.connect(serviceURL, map);

        MBeanServerConnection connection = jmxConnector.getMBeanServerConnection();

        // Invoke on the JBoss AS MBean server
        int count = connection.getMBeanCount();
        System.out.println("MBean Count = " + count);

        /*
        // If you want to output all MBean names, you can obtain it from queryNames():
        Set<ObjectName> objectNames = connection.queryNames(null, null);
        objectNames.forEach(System.out::println);

        // If you want to output all MBean names with attributes and operations, you can obtain them from MBeanInfo.
        Iterator<ObjectName> iterator = objectNames.iterator();
        while (iterator.hasNext()) {
            ObjectName name = iterator.next();
            System.out.println("Object Name: " + name.toString());
            MBeanInfo info = connection.getMBeanInfo(name);
            MBeanAttributeInfo[] attrs = info.getAttributes();
            if (attrs.length > 0) {
                // Arrays.stream(attrs).forEach(System.out::println);
                for (MBeanAttributeInfo item : attrs) {
                    System.out.println("- Attribute Name = " + item.getName());
                    System.out.println("     Description = " + item.getDescription());
                    // System.out.println("     Descriptor  = " + item.getDescriptor());
                }
            }
            MBeanOperationInfo[] ops = info.getOperations();
            if (ops.length > 0) {
                // Arrays.stream(ops).forEach(System.out::println);
                for (MBeanOperationInfo item : ops) {
                    System.out.println("-  Operation Name = " + item.getName());
                    System.out.println("      Description = " + item.getDescription());
                    // System.out.println("      Descriptor  = " + item.getDescriptor());
                }
            }
            System.out.println("****************************************");
        }
        */

        ObjectName objectName = ObjectName.getInstance("jboss.as:management-root=server");
        String attributeName = "serverState";
        Object result = connection.getAttribute(objectName, attributeName);
        System.out.println("serverState = " + result);

        jmxConnector.close();
    }
}