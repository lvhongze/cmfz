package com.baizhi.dao;

import com.baizhi.entity.TitlePic;

import java.util.List;

public interface TitlePicDao {
     List<TitlePic> queryAllTitlePic();
     void updateTitlePic(TitlePic titlePic);
     void insertTitlePic(TitlePic titlePic);
     void deleteTitlePic(String id);
     List<TitlePic> queryTitlePicByStatus();
}
