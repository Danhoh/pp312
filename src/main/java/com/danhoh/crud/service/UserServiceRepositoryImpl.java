package com.danhoh.crud.service;

import com.danhoh.crud.model.User;
import com.danhoh.crud.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceRepositoryImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceRepositoryImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void removeById(long id) {
        User user = findById(id);
        userRepository.delete(user);
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
