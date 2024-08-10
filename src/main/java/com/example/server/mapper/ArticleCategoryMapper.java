package com.example.server.mapper;

import com.example.server.domin.ArticleCategory;
import com.example.server.domin.vo.ArticleCategoryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleCategoryMapper {
    /**
     * 根据id获取对应文章类别
     * @return
     */
    List<ArticleCategoryVo> getList();
}
