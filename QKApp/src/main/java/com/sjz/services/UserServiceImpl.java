package com.sjz.services;

import com.sjz.mapper.UserMapper;
import com.sjz.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public int modUserInfo(User user) {
        return userMapper.modUserInfo(user);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public List<User> getAllUserLimit(Integer current, Integer pageSize) {
        current = pageSize * (current - 1);
        return userMapper.getAllUserLimit(current,pageSize);
    }

    @Override
    public int getTotal() {
        return userMapper.getTotal();
    }
}
