package com.example.server.service.impl;

import com.example.server.domin.ArticleCategory;
import com.example.server.domin.vo.ArticleCategoryVo;
import com.example.server.domin.vo.NavItemVo;
import com.example.server.mapper.ArticleCategoryMapper;
import com.example.server.service.ArticleCategoryService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleCategoryServiceImpl implements ArticleCategoryService {


    private static final Logger log = LoggerFactory.getLogger(ArticleCategoryServiceImpl.class);
    @Resource
    private ArticleCategoryMapper articleCategoryMapper;
    /**
     * 根据id获取对应文章类别
     * @return
     */
    @Override
    public List<ArticleCategoryVo> getList() {
        List<ArticleCategoryVo> list = articleCategoryMapper.getList();
        if (list.size() == 0){
            log.info("暂无导航项");
        }
        //创建Map 用于根据pid存储子项
        Map<Long,List<ArticleCategoryVo>> pidToChildrenMap = new HashMap<>();
        //循环全部导航项，将pid不同或是null的，设置为map的不同的键值，将数组区分开。
        for (ArticleCategoryVo item : list){
            Long pid = item.getPid();
            //如果当前对象的pid存在map中
            if (pidToChildrenMap.containsKey(pid)){
                //根据pid获取对应的List<NavItemVo> 并向数组添加item对象
                pidToChildrenMap.get(pid).add(item);
            }else {
                //如果pid不存在，就创建一个子项列表添加当前导航项
                List<ArticleCategoryVo> children = new ArrayList<>();
                children.add(item);
                pidToChildrenMap.put(pid,children);
            }
        }

        //构建树状结构
        List<ArticleCategoryVo> rootItems = new ArrayList<>();
        for (ArticleCategoryVo item : list){
            if (item.getPid() == null){
                //向返回数组设置对应map里有子项
                buildTree(item, pidToChildrenMap);
                rootItems.add(item);
            }
        }
        return rootItems;
    }

    private void buildTree(ArticleCategoryVo parent, Map<Long, List<ArticleCategoryVo>> pidToChildrenMap) {
        //根据父导航项id获取子项列表id
        List<ArticleCategoryVo> children = pidToChildrenMap.get(parent.getId());
        //如果子项列表不为空
        if (children!= null) {
            //向父导航项设置
            parent.setChildren(children);
            for (ArticleCategoryVo child : children) {
                buildTree(child, pidToChildrenMap);
            }
        }
    }
}
