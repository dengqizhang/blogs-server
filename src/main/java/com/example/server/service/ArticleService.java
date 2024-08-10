package com.example.server.service;

import com.example.server.domin.Article;

import java.util.List;

public interface ArticleService {

    /**
     * 根据id获取对应文章
     * @param categoryId 文章id
     * @return
     */
    Article getArticleById(Long categoryId);
}
