package me.gacl.service;

import me.gacl.domain.User;

/**
 * @Author: Chao Guo
 * @Date: 2018-12-03 2:08 PM
 */
public interface UserService {
    void addUser(User user);

    User getUserById(int id);
}
