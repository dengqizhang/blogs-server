package com.example.server.controller;

import com.example.server.domin.NavItem;
import com.example.server.domin.vo.HomeVo;
import com.example.server.domin.vo.NavItemVo;
import com.example.server.service.NavItemService;
import com.example.server.utils.R;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(NavItemController.class);
    @Resource
    private NavItemService navItemService;


    /**
     * 获取导航项数组
     * @return
     */
    @GetMapping("/getNavItem")
    public R<List<NavItemVo>> getNavItem(){
        try {
            List<NavItemVo> navItem = navItemService.getNavItem();
            return R.ok(navItem);
        }catch (Exception e){
            log.info("获取导航项异常");
            return R.warn("获取导航项异常，请稍后再试");
        }
    }
}
