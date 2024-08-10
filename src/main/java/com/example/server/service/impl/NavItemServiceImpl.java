package com.example.server.service.impl;

import com.example.server.domin.NavItem;
import com.example.server.domin.vo.NavItemVo;
import com.example.server.mapper.NavItemMapper;
import com.example.server.service.NavItemService;
import com.example.server.utils.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NavItemServiceImpl implements NavItemService {

    @Resource
    private NavItemMapper navItemMapper;
    @Override
    public R<List<NavItemVo>> getNavItem() {
        //获取所有导航项
        List<NavItemVo> navItems = navItemMapper.getNavItem();
        if (navItems.size() == 0){
            return R.warn("获取导航项失败，请稍后再试");
        }
        //创建Map 用于根据pid存储子项
        Map<Long,List<NavItemVo>> pidToChildrenMap = new HashMap<>();
        //循环全部导航项，将pid不同或是null的，设置为map的不同的键值，将数组区分开。
        for (NavItemVo item : navItems){
            Long pid = item.getPid();
            //如果当前对象的pid存在map中
            if (pidToChildrenMap.containsKey(pid)){
                //根据pid获取对应的List<NavItemVo> 并向数组添加item对象
                pidToChildrenMap.get(pid).add(item);
            }else {
                //如果pid不存在，就创建一个子项列表添加当前导航项
                List<NavItemVo> children = new ArrayList<>();
                children.add(item);
                pidToChildrenMap.put(pid,children);
            }
        }

        //构建树状结构
        List<NavItemVo> rootItems = new ArrayList<>();
        for (NavItemVo item : navItems){
            if (item.getPid() == null){
                //向返回数组设置对应map里有子项
                buildTree(item, pidToChildrenMap);
                rootItems.add(item);
            }
        }
        return R.ok(rootItems);
    }

    private void buildTree(NavItemVo parent, Map<Long, List<NavItemVo>> pidToChildrenMap) {
        //根据父导航项id获取子项列表id
        List<NavItemVo> children = pidToChildrenMap.get(parent.getId());
        //如果子项列表不为空
        if (children!= null) {
            //向父导航项设置
            parent.setChildren(children);
            for (NavItemVo child : children) {
                buildTree(child, pidToChildrenMap);
            }
        }
    }
}
