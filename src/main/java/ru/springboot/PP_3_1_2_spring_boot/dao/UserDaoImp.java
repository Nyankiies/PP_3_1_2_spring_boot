package ru.springboot.PP_3_1_2_spring_boot.dao;


import org.springframework.stereotype.Repository;
import ru.springboot.PP_3_1_2_spring_boot.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements  UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<User> getAllUser() {
        return getEntityManager().createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
