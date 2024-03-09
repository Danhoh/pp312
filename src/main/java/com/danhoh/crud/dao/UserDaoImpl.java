package com.danhoh.crud.dao;

import com.danhoh.crud.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> getAllUsers() {
        return entityManager
                .createQuery("FROM User", User.class)
                .getResultList();
    }

    @Override
    public void save(User user) {
        if (entityManager.find(User.class, user.getId()) != null) {
            entityManager.merge(user);
        } else {
            entityManager.persist(user);
        }
    }

    @Override
    public void removeById(long id) {
        entityManager.remove(findById(id));
    }

    @Override
    public User findById(long id) {
        return Optional
                .ofNullable(entityManager.find(User.class, id))
                .orElseThrow(EntityNotFoundException::new);
    }
}
