package me.gacl.service.test;

import me.gacl.domain.User;
import me.gacl.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: Chao Guo
 * @Date: 2018-12-03 2:05 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml", "classpath:spring-mybatis.xml"})
public class MyBatisTestBySpringTestFramework {
    //注入userService
    @Autowired
    private UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setAge(28);
        user.setName("chao");
        userService.addUser(user);
    }

    @Test
    public void testGetUserById() {
        int userId = 1;
        User user = userService.getUserById(userId);
        System.out.println(user);
    }
}
