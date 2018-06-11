package com.baizhi.contorllers;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping(value ="/album")
@ResponseBody
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @PostMapping(value="/queryAlbum",produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Map queryAlbumController(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows){
        List<Album> albums = albumService.queryAllAlbum();
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("total",albums.size());
        map.put("rows",albums);
        return map;
    }

    @RequestMapping(value = "/queryAlbumById")
    public Album queryAlbumById(String id){
        Album album = albumService.queryAlbumById(id);
        return album;
    }

    @RequestMapping(value = "insertAlbum")
    public void insertAlbumController(MultipartFile image, Album album, HttpServletRequest request) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/album-photo");
        String filename = image.getOriginalFilename();
        File targetFile=new File(realPath+"/"+filename);
        System.out.println(targetFile);
        image.transferTo(targetFile);
        String uuid = UUID.randomUUID().toString();
        album.setCover("../coverpic/"+filename);
        album.setId(uuid);
        album.setDownloadcodes(0);
        album.setScore("0");
        album.setDate(new Date());
        albumService.insertAlbum(album);
    }
}
