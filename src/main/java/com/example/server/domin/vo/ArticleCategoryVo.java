package com.example.server.domin.vo;

import lombok.Data;

import java.util.List;

/**
 * 文章类别视图对象
 *
 * @author Cary
 * @date 2024-08-05
 */
@Data
public class ArticleCategoryVo {

    private Long id;
    //文章类别名称
    private String name;
    //导航项id
    private Long navitemId;
    //文章类别父级id
    private Long pid;
    //二级菜单数组
    private List<ArticleCategoryVo> children;
    //文章类别id
    private Long categoryId;
}
