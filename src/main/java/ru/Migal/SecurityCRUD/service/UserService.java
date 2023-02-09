package ru.Migal.SecurityCRUD.service;


import ru.Migal.SecurityCRUD.model.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();

    void updateUser(User user);

    void addUser(User user);

    User getUserById(Long id);

    User getUserByName(String name);

    void deleteUser(User user);
}
