package com.baizhi.service;

import com.baizhi.dao.TitlePicDao;
import com.baizhi.entity.TitlePic;
import com.baizhi.objcetAdvices.LogAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TitlePicServiceImpl implements TitlePicService {
    @Autowired
    private TitlePicDao titlePicDao;
    @Override
    public List<TitlePic> queryAllTitlePic() {
        List<TitlePic> titlePics = titlePicDao.queryAllTitlePic();
        return titlePics;
    }

    @Override
    @LogAnnotation(name="删除轮播图")
    public void deleteTitlePic(String id) {
        titlePicDao.deleteTitlePic(id);
    }

    @Override
    @LogAnnotation(name="修改轮播图")
    public void updateTitlePic(TitlePic titlePic) {
        titlePicDao.updateTitlePic(titlePic);
    }

    @Override
    @LogAnnotation(name="添加轮播图")
    public void insertTitlePic(TitlePic titlePic) {
        titlePicDao.insertTitlePic(titlePic);
    }
}
