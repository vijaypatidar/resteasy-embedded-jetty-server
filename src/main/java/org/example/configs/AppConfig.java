package org.example.configs;


import org.example.rest.UserController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("/api")
public class AppConfig extends Application {

    /**
     * Resources that we want to be singleton across each request
     *
     * @return singleton object
     */
    @Override
    public Set<Object> getSingletons() {
        return Set.of(
                new UserController()
        );
    }

    /**
     * Resources that we want to be per request
     *
     * @return classes
     */
    @Override
    public Set<Class<?>> getClasses() {
        return super.getClasses();
    }
}
