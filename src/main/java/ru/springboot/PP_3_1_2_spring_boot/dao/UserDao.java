package ru.springboot.PP_3_1_2_spring_boot.dao;

import ru.springboot.PP_3_1_2_spring_boot.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUser();

    public void saveUser(User user);

    public User getUser(Long id);

    public void deleteUser(Long id);
}
