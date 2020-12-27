package com.gupaoedu.service;

import com.gupaoedu.pojo.User;

import java.util.List;

public interface IUserService {

    List<User> query(User user);
}
