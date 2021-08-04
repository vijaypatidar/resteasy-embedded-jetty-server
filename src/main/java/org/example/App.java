package org.example;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.example.configs.AppConfig;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.setHandler(getHandlers());
        server.start();
        server.join();
    }

    private static Handler getHandlers() {
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        handler.addServlet(HttpServletDispatcher.class, "/");
        handler.setInitParameter("javax.ws.rs.Application", AppConfig.class.getCanonicalName());
        return handler;
    }
}
