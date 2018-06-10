package com.baizhi.dao;

import com.baizhi.entity.Article;

import java.util.List;

public interface ArticleDao {
    List<Article> queryAllArticle();
    List<Article> queryArticleByGuruId(String guruid);
}
