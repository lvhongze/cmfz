package com.baizhi.frontControllers;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/member")
public class FrontGetUserController {
    JSONObject jsonObject=new JSONObject();
    @Autowired
    private UserService userService;
    @GetMapping(value = "/getUser",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public JSONObject getUser(String uid){
        List<User> users = userService.queryUserNotMi(uid);
        jsonObject.put("users",users);
        return jsonObject;
    }
}
