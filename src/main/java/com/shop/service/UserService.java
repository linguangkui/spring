package com.shop.service;

import com.shop.domain.User;

public interface UserService {
    /**
     * 登录功能
     * @param username
     * @param password
     * @return
     */
    User login(String username,String password);
}
