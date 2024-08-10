package com.example.server.domin;

import lombok.Data;

/**
 * 导航项对象
 *
 * @author Cary
 * @date 2024-08-05
 */
@Data
public class NavItem {
    private Long id;
    //导航项名称
    private String name;
    //路径
    private String url;
    //二级菜单id
    private Long pid;



}
