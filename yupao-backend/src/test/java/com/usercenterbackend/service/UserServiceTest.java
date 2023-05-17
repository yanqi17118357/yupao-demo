package com.usercenterbackend.service;

import com.usercenterbackend.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;

@SpringBootTest
public class UserServiceTest {

    @Resource
    UserService userService;


    @Test
    public void userAddTest() {

        User user = new User();
        user.setUsername("dog");
        user.setUserAccount("111");
        user.setAvatarUrl("https://npm.elemecdn.com/yanqi1711-picx@1.0.11/img/me.webp");
        user.setGender(0);
        user.setUserPassword("222");
        user.setPhone("333");
        user.setEmail("444");

        boolean result = userService.save(user);

        System.out.println(user.getId());

        Assertions.assertTrue(result);


    }

    @Test
    void userRegister() {

        String userAccount = "dog123";
        String userPassword = "";
        String checkPassword = "12345678";
        long result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        userAccount = "yu";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        userAccount = "dog123";
        userPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        userAccount = "dog 123";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        userAccount = "dog123";
        userPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        userAccount = "dogge";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

    }
}
