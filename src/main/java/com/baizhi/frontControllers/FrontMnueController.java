package com.baizhi.frontControllers;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.service.AlbumService;

import com.baizhi.service.FrontFirstPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping(value = "/cmfz")
public class FrontMnueController {
    JSONObject jsonObject = new JSONObject();
    @Autowired
    private FrontFirstPageService frontFirstPageService;

    @GetMapping(value = "/first_page",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public JSONObject firstPage(String uid,String type,String sub_type){
        Map<String, Object> map = frontFirstPageService.queryFirstPage(uid, type, sub_type);
        Set<Map.Entry<String,Object>> set=map.entrySet();
        for (Map.Entry<String, Object> ss : set) {
            String k=ss.getKey();
            Object v=ss.getValue();
            jsonObject.put(""+k+"",v);
        }
        return jsonObject;
    }
}
