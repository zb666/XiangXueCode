package com.gupaoedu.service.impl;

import com.gupaoedu.mapper.UserMapper;
import com.gupaoedu.pojo.User;
import com.gupaoedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> query(User user) {
        return userMapper.query(user);
    }
}
