package com.sjz.mapper;

import com.sjz.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public int modUserInfo(User user);
    public List<User> getAllUser();
    public User getUserByName(String name);
    int addUser(User user);
    List<User> getAllUserLimit(Integer start,Integer size);

    int getTotal();
}
