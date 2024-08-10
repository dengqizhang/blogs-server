package com.example.server.controller;

import com.example.server.domin.Home;
import com.example.server.domin.vo.HomeVo;
import com.example.server.service.HomeService;
import com.example.server.utils.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页
 * @author Cary
 * @date 2024-08-05
 */
@RestController
@CrossOrigin
public class HomeController {
    @Resource
    private HomeService homeService;


    /**
     * 获取首页信息对象
     * @return Home
     */
    @GetMapping("/home")
    public R<HomeVo> gethome(){
        try {
            HomeVo home = homeService.getHome();
            return R.ok(home);
        }catch (Exception e){
            return R.warn("请稍后再试");
        }
    }

}
