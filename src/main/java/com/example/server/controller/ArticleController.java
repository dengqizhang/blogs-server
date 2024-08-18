package com.example.server.controller;

import com.example.server.domin.Article;
import com.example.server.domin.vo.ArticleCategoryVo;
import com.example.server.service.ArticleService;
import com.example.server.utils.R;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 文章
 * @author Cary
 * @date 2024-08-05
 */
@RestController
@CrossOrigin
public class ArticleController {

    private static final Logger log = LoggerFactory.getLogger(ArticleCategoryController.class);
    @Resource
    private ArticleService articleService;

    /**
     * 根据id获取对应文章
     * @param categoryId 文章id
     * @return
     */
    @GetMapping("/getArticleById")
    public R<Article> getArticleById (@RequestParam("categoryId") Long categoryId){
        try {
            Article article = articleService.getArticleById(categoryId);
            return R.ok(article);
        }catch (Exception e){
            log.info(e.getMessage());
            return R.warn("查询文章失败");
        }
    }

}
