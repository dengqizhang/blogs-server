package com.example.server.service.impl;

import com.example.server.domin.Article;
import com.example.server.mapper.ArticleMapper;
import com.example.server.service.ArticleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章业务逻辑处理
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    /**
     * 根据id获取对应文章
     * @param categoryId 文章id
     * @return
     */
    @Override
    public Article getArticleById(Long categoryId) {
        Article articleList = articleMapper.getArticleById(categoryId);
        return articleList;
    }
}
