package org.example.services;

import org.example.models.User;

import java.util.*;

public class UserService {
    private final Map<String, User> users = new HashMap<>();

    public void insertUser(User user) {
        users.put(user.getEmail(), user);
    }

    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    public Optional<User> getUser(String email) {
        return Optional.of(users.get(email));
    }

}
