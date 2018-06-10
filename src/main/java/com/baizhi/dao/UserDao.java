package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;
import java.util.Set;

public interface UserDao {
    List<User> queryAllUser();
    int queryCount1(int j);
    Set<String> queryAllProvince();
    int queryCity(String province);
    void insertUser(User user);
    void deleteUser(String id);
    User queryOneUser(String photoNum);
    User queryOneUserById(String id);
    void frontUpdateUser(User user);
    List<User> queryUserNotMi(String id);
}
