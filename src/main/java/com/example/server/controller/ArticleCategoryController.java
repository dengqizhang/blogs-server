package com.example.server.controller;

import com.example.server.domin.ArticleCategory;
import com.example.server.domin.vo.ArticleCategoryVo;
import com.example.server.service.ArticleCategoryService;
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
 * 首页
 * @author Cary
 * @date 2024-08-05
 */
@RestController
@CrossOrigin
public class ArticleCategoryController {
    private static final Logger log = LoggerFactory.getLogger(ArticleCategoryController.class);
    @Resource
    private ArticleCategoryService articleCategoryService;

    /**
     * 根据id获取对应文章类别
     * @return
     */
    @GetMapping("/getArticleCategory")
    public R<List<ArticleCategoryVo>> getArticleCategory(@RequestParam("navItemId") Long navItemId){

        System.out.println(navItemId);
        try {
            List<ArticleCategoryVo> list = articleCategoryService.getList(navItemId);
            return R.ok(list);
        }catch (Exception e){
            log.info(e.getMessage());
            return R.warn("查询文章类别失败");
        }
    }
}
