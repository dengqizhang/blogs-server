package com.example.server.mapper;

import com.example.server.domin.NavItem;
import com.example.server.domin.vo.NavItemVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NavItemMapper {
    List<NavItemVo> getNavItem();
}
