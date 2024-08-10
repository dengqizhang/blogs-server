package com.example.server.domin;

import lombok.Data;

/**
 * 文章类别对象
 *
 * @author Cary
 * @date 2024-08-05
 */
@Data
public class ArticleCategory {

    private Long id;
    //类别名称
    private String name;
    //导航项ID
    private Long navitemId;
    //文章类别父级id
    private Long pid;
    //文章类别id
    private Long categoryId;
}
