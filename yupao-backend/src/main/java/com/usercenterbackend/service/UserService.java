package com.usercenterbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.usercenterbackend.model.domain.User;

import javax.servlet.http.HttpServletRequest;

/**
* @author 32248
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2023-04-23 19:01:44
*/
public interface UserService extends IService<User> {



    /**
     * 用户注释
     *
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @param checkPassword 校验密码
     * @return 新用户id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     *
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     *
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);

    /**
     * 用户注销
     *
     * @param request
     * @return
     */
    int userLogout(HttpServletRequest request);
}
