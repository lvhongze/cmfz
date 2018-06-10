package com.baizhi.contorllers;



import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.Poi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.*;


@Controller
@RequestMapping(value ="/user")
@ResponseBody
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(value="/showUsers",produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Map queryUsersController(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows){
        List<User> users = userService.queryAllUser();
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("total",users.size());
        int begin=(page-1)*rows+1;
        int end=page*rows;
        List<User> users1=new ArrayList<User>();
        for(int i=0;i<users.size();i++){
            if((i>=(begin-1)&&i<=(end-1))||i==0){
                users1.add(users.get(i));
            }
        }
        map.put("rows",users1);
        return map;
    }
    @PostMapping(value="/distribution",produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
    public int[] queryDistribution(){
        int[] ints = userService.queryCount();
        return ints;
    }
    @RequestMapping(value = "/map")
    public JSONObject queryregional(){
        Map<String, Integer> map = userService.queryRegional();
        JSONObject jsonObject=new JSONObject();
        Set<Map.Entry<String,Integer>> set=map.entrySet();
        for (Map.Entry<String, Integer> ss : set) {
            String k=ss.getKey();
            Integer v=ss.getValue();
            jsonObject.put(""+k+"",v);
        }
        return jsonObject;
    }
    @RequestMapping(value = "/export")
    public String export(String name,String value) throws Exception {
        userService.userExport(name,value);
        return "ok";
    }
}
