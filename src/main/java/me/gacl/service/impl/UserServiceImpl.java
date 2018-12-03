package me.gacl.service.impl;

import me.gacl.dao.UserMapper;
import me.gacl.domain.User;
import me.gacl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Chao Guo
 * @Date: 2018-12-03 2:10 PM
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public void addUser(User user) {
        int result = userMapper.insert(user);
    }

    public User getUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
