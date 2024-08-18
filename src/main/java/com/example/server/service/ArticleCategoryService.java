package com.example.server.service;

import com.example.server.domin.ArticleCategory;
import com.example.server.domin.vo.ArticleCategoryVo;

import java.util.List;

public interface ArticleCategoryService {

    /**
     * 根据id获取对应文章类别
     * @return
     */
    List<ArticleCategoryVo> getList(Long navItemId);
}
