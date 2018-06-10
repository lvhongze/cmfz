package com.baizhi.contorllers;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;
import java.io.OutputStream;

@Controller
@RequestMapping(value = "/admin")
public class  AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping(value = "/login")
    public String login(String name, String password,String vcode, HttpSession session){
        String vcode1 = (String) session.getAttribute("vcode");
        if(vcode1.equals(vcode)){
            Admin admin = adminService.queryAdmin(name, password);
            session.setAttribute("admin",admin);
            return "redirect:/main/main.jsp";
        }else{
            return null;
        }
    }
    @RequestMapping(value="/img")
    public void img(OutputStream os, HttpSession session) throws Exception {
        //1. 得到随机数
        CreateValidateCode cvc = new CreateValidateCode(100, 30, 5, 10);
        String code = cvc.getCode();
        session.setAttribute("vcode",code);
        //3. 调用工具类的方法画图片
        cvc.write(os);
    }
}
