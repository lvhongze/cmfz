package com.baizhi.frontControllers;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/frontUser")
public class FrontUserController{
    JSONObject jsonObject = new JSONObject();
    @Autowired
    private UserService userService;
    @PostMapping(value = "/login",produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
    public JSONObject userLogin(String photoNum, String password, ModelMap modelMap){
        try {
            User user = userService.userLogin(photoNum,password);
            modelMap.put("user",user);
            jsonObject.put("id",user.getId());
            jsonObject.put("name",user.getName());
            jsonObject.put("photoNum",user.getPhotoNum());
            jsonObject.put("password",user.getPassword());
            jsonObject.put("farmington",user.getFarmington());
            jsonObject.put("sex",user.getSex());
            jsonObject.put("photo",user.getPhoto());
            jsonObject.put("localtion",user.getLocaltion());
            jsonObject.put("province",user.getProvince());
            jsonObject.put("city",user.getCity());
            jsonObject.put("description",user.getDescription());
            jsonObject.put("guruid",user.getGuruid());
            jsonObject.put("description",user.getDescription());
            return jsonObject;
        }catch (Exception e){
            jsonObject.put("error",-200);
            jsonObject.put("errmsg",e.getMessage());
            return jsonObject;
        }
    }
    @PostMapping(value = "/register",produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
    public JSONObject userRegister(String photoNUm,String password){
        try {
            User user = userService.insertUser(photoNUm, password);
            jsonObject.put("id",user.getId());
            jsonObject.put("name",user.getName());
            jsonObject.put("password",user.getPassword());
            return jsonObject;
        }catch (Exception e){
            jsonObject.put("error","-200");
            jsonObject.put("errmsg",e.getMessage());
            return jsonObject;
        }
    }

    @PostMapping(value = "/modify",produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
    public JSONObject userUpdate(User user){
        try {
            userService.frontUpdateUser(user);
            jsonObject.put("id",user.getId());
            jsonObject.put("name",user.getName());
            jsonObject.put("photoNum",user.getPhotoNum());
            jsonObject.put("password",user.getPassword());
            jsonObject.put("farmington",user.getFarmington());
            jsonObject.put("sex",user.getSex());
            jsonObject.put("photo",user.getPhoto());
            jsonObject.put("localtion",user.getLocaltion());
            jsonObject.put("province",user.getProvince());
            jsonObject.put("city",user.getCity());
            jsonObject.put("description",user.getDescription());
            jsonObject.put("guruid",user.getGuruid());
            jsonObject.put("description",user.getDescription());
            return jsonObject;
        }catch (Exception e){
            jsonObject.put("error",-200);
            jsonObject.put("errmsg",e.getMessage());
            return jsonObject;
        }
    }
}
