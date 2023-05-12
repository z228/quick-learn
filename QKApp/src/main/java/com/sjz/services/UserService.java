package com.sjz.services;

import com.sjz.pojo.User;

import java.util.List;

public interface UserService {
    //修改用户信息
    public int modUserInfo(User user);

    //查询所有用户信息
    public List<User> getAllUser();

    //查询指定用户信息
    public User getUserByName(String name);

    //添加一个用户
    int addUser(User user);

    List<User> getAllUserLimit(Integer current, Integer pageSize);

    int getTotal();
}
