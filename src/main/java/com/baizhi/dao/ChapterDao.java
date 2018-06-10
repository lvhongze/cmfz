package com.baizhi.dao;

import com.baizhi.entity.Chapter;

import java.util.List;

public interface ChapterDao {
    public List<Chapter> queryChapterByParentid(String id);
    public void insertChapter(Chapter chapter);
    public void deleteChapter(String id);
    public Chapter queryChapterById(String id);
}
