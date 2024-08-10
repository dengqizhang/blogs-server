package com.example.server.service;

import com.example.server.domin.NavItem;
import com.example.server.domin.vo.NavItemVo;
import com.example.server.utils.R;

import java.util.List;

public interface NavItemService {
    List<NavItemVo> getNavItem();
}
