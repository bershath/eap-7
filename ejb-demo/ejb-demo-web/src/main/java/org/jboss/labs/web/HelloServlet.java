package org.jboss.labs.web;

import org.jboss.labs.HelloDate;
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("hello")
public class HelloServlet extends HttpServlet {

    @EJB
    HelloDate helloDate;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().append("<html><body> Message from HelloDate: " + helloDate.sayHelloDate());
        response.getWriter().append("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

}
