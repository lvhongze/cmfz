package com.baizhi.service;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import com.baizhi.objcetAdvices.LogAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService{
    @Autowired
    private ChapterDao chapterDao;

    @Override
    @LogAnnotation(name="添加音频章节")
    public void insertChapter(Chapter chapter) {
        chapterDao.insertChapter(chapter);
    }

    @Override
    public Chapter queryChapterById(String id) {
        Chapter chapter = chapterDao.queryChapterById(id);
        return chapter;
    }

    @Override
    public List<Chapter> queryChapterByGuruid(String guruid) {
        List<Chapter> chapters = chapterDao.queryChapterByParentid(guruid);
        return chapters;
    }
}
