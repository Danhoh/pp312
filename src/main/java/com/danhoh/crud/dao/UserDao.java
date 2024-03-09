package com.danhoh.crud.dao;

import com.danhoh.crud.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void save(User user);

    void removeById(long id);

    User findById(long id);
}
