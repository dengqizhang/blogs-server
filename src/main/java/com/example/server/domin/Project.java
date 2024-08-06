package com.example.server.domin;

import lombok.Data;

/**
 * 项目对象
 *
 * @author Cary
 * @date 2024-08-05
 */
@Data
public class Project {

    private Long id;
    //标题
    private String title;
    //介绍
    private String text;
    //地址
    private String url;
    //项目类型
    private int projectType;
}
