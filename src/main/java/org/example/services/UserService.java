package org.example.services;

import org.example.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    private final List<User> users = new ArrayList<>();

    public void insertUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

    public Optional<User> getUser(String email) {
        return users.stream().filter(u -> u.getEmail().equals(email)).findFirst();
    }

}
