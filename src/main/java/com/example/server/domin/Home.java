package com.example.server.domin;

import lombok.Data;
/**
 * 首页对象
 *
 * @author Cary
 * @date 2024-08-05
 */
@Data
public class Home {

    private Long id;
    //github
    private String github;
    //邮箱
    private String email;
    //联系方式
    private String wechat;
    //主页介绍
    private String mainText;

}
