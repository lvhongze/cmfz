package com.baizhi.frontControllers;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/detail")
public class FrontShowController {
    JSONObject jsonObject=new JSONObject();
    @Autowired
    private AlbumService albumService;
    @GetMapping(value = "/wen",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public JSONObject wenPage(String id,String uid){
        List<Album> albums = albumService.queryAllAlbum();
        jsonObject.put("introduction",albums);
        jsonObject.put("lists",albums.get(albums.size()-1));
        return jsonObject;
    }
}
