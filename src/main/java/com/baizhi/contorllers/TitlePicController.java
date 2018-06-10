package com.baizhi.contorllers;

import com.baizhi.entity.TitlePic;
import com.baizhi.service.TitlePicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
@RequestMapping(value = "/titlePic")
@ResponseBody
public class TitlePicController {
    @Autowired
    private TitlePicService titlePicService;
    @PostMapping(value="/queryPic",produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Map queryPicContorller(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows){
        List<TitlePic> titlePics = titlePicService.queryAllTitlePic();
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("total",titlePics.size());
        int begin=(page-1)*rows+1;
        int end=page*rows;
        List<TitlePic> Pics=new ArrayList<TitlePic>();
        for(int i=0;i<titlePics.size();i++){
            if((i>=(begin-1)&&i<=(end-1))||i==0){
                Pics.add(titlePics.get(i));
            }
        }
        map.put("rows",Pics);
        return map;
    }
    @PostMapping(value="/deletePic")
    public void deletePiccontroller(String string){
        String[] s = string.split(",");
        for(int i=0;i<s.length;i++){
            titlePicService.deleteTitlePic(s[i]);
        }
    }
    @RequestMapping(value = "/update")
    public void updatePicController(TitlePic titlePic){
        titlePicService.updateTitlePic(titlePic);
    }
    @RequestMapping(value = "insert")
    public void insertPicController(MultipartFile image, TitlePic titlePic, boolean status,HttpServletRequest request) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/photo");
        String filename = image.getOriginalFilename();
        File targetFile=new File(realPath+"/"+filename);
        image.transferTo(targetFile);
        String uuid = UUID.randomUUID().toString();
        titlePic.setId(uuid);
        titlePic.setThumbnail("../photo/"+filename);
        if(status)titlePic.setStatus(1);
        else titlePic.setStatus(0);
        System.out.println(titlePic);
        titlePicService.insertTitlePic(titlePic);
    }
}
