package com.example.server.service.impl;

import com.example.server.domin.Home;
import com.example.server.domin.Project;
import com.example.server.domin.vo.HomeVo;
import com.example.server.mapper.HomeMapper;
import com.example.server.service.HomeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    @Resource
    private HomeMapper homeMapper;

    /**
     * 获取首页信息对象
     * @return Home
     */
    @Override
    public HomeVo getHome() {
        HomeVo home = homeMapper.getHome();
        List<Project> projects = homeMapper.getProjects();
        home.setProjectList(projects);
        return home;
    }
}
