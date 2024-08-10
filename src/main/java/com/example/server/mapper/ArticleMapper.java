package com.example.server.mapper;

import com.example.server.domin.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    /**
     * 根据id获取对应文章
     * @param categoryId 文章id
     * @return
     */
    Article getArticleById(Long categoryId);
}
