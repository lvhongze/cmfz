package com.baizhi.contorllers;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import com.baizhi.util.chapterutil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.UUID;

@Controller
@RequestMapping(value = "/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    @RequestMapping(value = "/insertChapter")
    @ResponseBody
    public String insertChapter(MultipartFile music,String album_id, HttpServletRequest request) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/chapter");
        String filename = music.getOriginalFilename();
        File targetFile=new File(realPath+"/"+filename);
        music.transferTo(targetFile);
        String uuid = UUID.randomUUID().toString();
        Chapter chapter=new Chapter();
        chapter.setAlbum_id(album_id);
        chapter.setId(uuid);
        chapter.setDownload_url("F:\\ideaWorkspace\\first\\target\\chapter\\"+filename);
        chapter.setName(filename);
        String s = chapterutil.ReadVideoTime(targetFile);
        chapter.setLength(s);
        String s1 = chapterutil.ReadVideoSize(targetFile);
        chapter.setSize(s1);
        System.out.println(chapter);
        chapterService.insertChapter(chapter);
        return "ok";
    }
    @RequestMapping(value = "/download")
    public void download(HttpServletResponse response, OutputStream os, String id) throws Exception {
        Chapter chapter = chapterService.queryChapterById(id);
        File file=new File(chapter.getDownload_url());
        String fileName = null;
        try {
            fileName = new String(chapter.getName().getBytes("UTF-8"), "ISO8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setHeader("content-disposition", "attachment;fileName=" + fileName);
        response.setContentType("audio/mpeg");
        //响应出去
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(FileUtils.readFileToByteArray(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
