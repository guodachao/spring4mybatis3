package me.gacl.dao;

import me.gacl.domain.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getUser(int id);

    void addUser(User user);

    void deleteUser(int id);

    void updateUser(User user);

    List<User> getAllUsers();
}