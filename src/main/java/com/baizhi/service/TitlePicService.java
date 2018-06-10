package com.baizhi.service;

import com.baizhi.entity.TitlePic;

import java.util.List;

public interface TitlePicService {
    public List<TitlePic> queryAllTitlePic();
    public void deleteTitlePic(String id);
    public void updateTitlePic(TitlePic titlePic);
    public void insertTitlePic(TitlePic titlePic);
}
