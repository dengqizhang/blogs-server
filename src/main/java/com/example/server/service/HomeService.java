package com.example.server.service;

import com.example.server.domin.Home;
import com.example.server.domin.vo.HomeVo;

public interface HomeService {
    /**
     * 获取首页信息对象
     * @return Home
     */
    HomeVo getHome();
}
