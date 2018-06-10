package com.baizhi.service;

import com.baizhi.entity.User;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> queryAllUser();
    int[] queryCount();
    Map<String,Integer> queryRegional();
    User insertUser(String photoNum,String password);
    void deleteUser(String id);
    User userLogin(String photoNum,String password);
    void frontUpdateUser(User user);
    List<User> queryUserNotMi(String id);
    void userExport(String name,String value) throws IOException, NoSuchMethodException, Exception;
}
