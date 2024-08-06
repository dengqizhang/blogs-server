package com.example.server.mapper;

import com.example.server.domin.Home;
import com.example.server.domin.Project;
import com.example.server.domin.vo.HomeVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeMapper {

    /**
     * 获取首页信息对象
     * @return Home
     */
    HomeVo getHome();

    /**
     * 获取项目数组
     */
    List<Project> getProjects();
}
