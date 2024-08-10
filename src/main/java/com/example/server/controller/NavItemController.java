package com.example.server.controller;

import com.example.server.domin.NavItem;
import com.example.server.domin.vo.HomeVo;
import com.example.server.domin.vo.NavItemVo;
import com.example.server.service.NavItemService;
import com.example.server.utils.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 导航项
 * @author Cary
 * @date 2024-08-05
 */
@RestController
@CrossOrigin
public class NavItemController {
    @Resource
    private NavItemService navItemService;


    /**
     * 获取导航项数组
     * @return
     */
    @GetMapping("/getNavItem")
    public R<List<NavItemVo>> getNavItem(){
        return navItemService.getNavItem();
    }
}
