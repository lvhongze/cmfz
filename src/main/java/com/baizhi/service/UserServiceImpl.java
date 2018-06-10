package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.util.Md5Util;
import com.baizhi.util.Poi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> queryAllUser() {
        List<User> users = userDao.queryAllUser();
        return users;
    }

    @Override
    public int[] queryCount() {
        int[] ints=new int[3];
        for (int j=0;j<ints.length;j++){
            int i = userDao.queryCount1(j);
            ints[j]=i;
        }
        return ints;
    }

    @Override
    public Map<String, Integer> queryRegional() {
        Map<String,Integer> map=new HashMap<String, Integer>();
        Set<String> strings = userDao.queryAllProvince();
        for (String string : strings) {
            int count = userDao.queryCity(string);
            map.put(string,count);
        }
        return map;
    }

    @Override
    public User insertUser(String photoNum,String password) {
        User user = userDao.queryOneUser(photoNum);
        if (user!=null){
            user.setPassword(Md5Util.encryption(user.getPassword()));
            String uuid = UUID.randomUUID().toString();
            User user1=new User();
            user1.setId(uuid);
            user1.setPhotoNum(photoNum);
            user1.setPassword(password);
            userDao.insertUser(user);
            return user1;
        }else {
            throw new RuntimeException("您注册的用户已经存在");
        }

    }

    @Override
    public void deleteUser(String id) {
        userDao.deleteUser(id);
    }

    @Override
    public User userLogin(String photoNum, String password) {
        User user = userDao.queryOneUser(photoNum);
        String newPassword = Md5Util.encryption(password);
        if(newPassword.equals(user.getPassword())){
            return user;
        }else {
            throw new RuntimeException("密码错误");
        }
    }

    @Override
    public void frontUpdateUser(User user) {
        User user1 = userDao.queryOneUser(user.getId());
        user.setStatus(user1.getStatus());
        user.setDate(user1.getDate());
        if (user1!=null){
            userDao.frontUpdateUser(user);
        }else {
            throw new RuntimeException("您修改的用户不存在");
        }
    }

    @Override
    public List<User> queryUserNotMi(String id) {
        List<User> users = userDao.queryUserNotMi(id);
        return users;
    }

    @Override
    public void userExport(String name, String value) throws IOException {
        List<User> users = userDao.queryAllUser();
        Poi.exprot(name,value,users);
    }
}
