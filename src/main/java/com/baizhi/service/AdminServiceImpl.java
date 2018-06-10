package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDao adminDao;
    @Override
    public Admin queryAdmin(String name,String password) {
        Admin admin = adminDao.queryAdminByName(name);
        if (admin!=null&&password.equals(admin.getPassword())){
            return admin;
        }else {
            throw new RuntimeException("用户名或密码错误");
        }
    }
}
