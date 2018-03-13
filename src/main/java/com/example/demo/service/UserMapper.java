package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(int userid);

    int insert(User record);

    int updateByPrimaryKey(User record);
    
    User selectByPrimaryKey(int userid);
    
    List<User> selectAll();
    
    List<User> getUserByUsername(String username);
}