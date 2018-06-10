package com.baizhi.service;

import com.baizhi.entity.Chapter;

import java.util.List;

public interface ChapterService {
    void insertChapter(Chapter chapter);
    Chapter queryChapterById(String id);
    List<Chapter> queryChapterByGuruid(String guruid);
}
