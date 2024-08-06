package com.example.server.domin.vo;

import com.example.server.domin.Project;
import lombok.Data;

import java.util.List;

/**
 * 首页视图对象
 *
 * @author Cary
 * @date 2024-08-05
 */
@Data
public class HomeVo {
    private Long id;
    //github
    private String github;
    //邮箱
    private String email;
    //联系方式
    private String wechat;
    //主页介绍
    private String mainText;
    //项目对象数组
    private List<Project> projectList;
}
