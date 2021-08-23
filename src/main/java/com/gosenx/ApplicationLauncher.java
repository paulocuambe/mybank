package com.gosenx;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

public class ApplicationLauncher {
  public static void main(String[] args) throws LifecycleException {
    Tomcat tomcat = new Tomcat();

    int port = 8080;
    if(System.getProperty("server.port") != null){
      port = Integer.parseInt(System.getProperty("server.port"));
    }

    tomcat.setPort(port);
    tomcat.getConnector();

    Context context = tomcat.addContext("", null);
    Wrapper servlet = Tomcat.addServlet(context, "mybank", new MyServlet());
    servlet.setLoadOnStartup(1);
    servlet.addMapping("/*");
    tomcat.start();
  }
}
