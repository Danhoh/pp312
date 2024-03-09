package com.danhoh.crud.service;


import com.danhoh.crud.dao.UserDao;
import com.danhoh.crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{
    private final UserDao userDao;
    @Autowired
    UserServiceImpl(@Qualifier("userDaoImpl") UserDao dao) {
        this.userDao = dao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void removeById(long id) {
        userDao.removeById(id);
    }

    @Override
    public User findById(long id) {
        return userDao.findById(id);
    }
}
