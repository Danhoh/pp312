package com.danhoh.crud.service;


import com.danhoh.crud.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void save(User user);

    void removeById(long id);

    User findById(long id);
}
