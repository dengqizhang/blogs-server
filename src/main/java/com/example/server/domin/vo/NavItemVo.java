package com.example.server.domin.vo;

import com.example.server.domin.NavItem;
import lombok.Data;

import java.util.List;

/**
 * 导航项视图对象
 *
 * @author Cary
 * @date 2024-08-05
 */
@Data
public class NavItemVo {
    private Long id;
    //导航项名称
    private String name;
    //路径
    private String url;
    //二级菜单id
    private Long pid;
    //二级菜单数组
    private List<NavItemVo> children;
}
