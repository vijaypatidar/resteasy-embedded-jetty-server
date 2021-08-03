package org.example.configs;


import org.example.rest.UserController;

import javax.ws.rs.core.Application;
import java.util.Collection;
import java.util.Set;

public class AppConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return Set.of(UserController.class);
    }
}
