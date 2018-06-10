package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.dao.ArticleDao;
import com.baizhi.dao.TitlePicDao;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.Album;
import com.baizhi.entity.Article;
import com.baizhi.entity.TitlePic;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class FrontFirstPageServiceImpl implements FrontFirstPageService{
    @Autowired
    private TitlePicDao titlePicDao;
    @Autowired
    private AlbumDao albumDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ArticleDao articleDao;
    @Override
    public Map<String, Object> queryFirstPage(String id, String type, String sub_type) {
        Map<String,Object> map=new HashMap<>();
        if (type.equals("all")){
            List<TitlePic> titlePics = titlePicDao.queryTitlePicByStatus();
            List<Album> albums = albumDao.queryAlbumByTime();
            User user = userDao.queryOneUserById(id);
            List<Article> articles = articleDao.queryArticleByGuruId(user.getGuruid());
            map.put("header",titlePics);
            map.put("album",albums);
            map.put("artical",articles);
            return map;
        }else if (type.equals("wen")){
            List<Album> albums = albumDao.queryAllAlbum();
            map.put("album",albums);
            return map;
        }else{
            if (sub_type.equals("ssyj")){
                User user = userDao.queryOneUserById(id);
                List<Article> articles = articleDao.queryArticleByGuruId(user.getGuruid());
                map.put("artical",articles);
                return map;
            }else {
                List<Article> articles = articleDao.queryAllArticle();
                map.put("artical",articles);
                return map;
            }
        }
    }
}
