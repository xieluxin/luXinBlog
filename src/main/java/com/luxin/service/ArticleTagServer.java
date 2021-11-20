package com.luxin.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luxin.entity.ArticleTag;
import com.luxin.mapper.ArticleTagDao;
import com.luxin.utils.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleTagServer{

    @Autowired
    private ArticleTagDao articleTagDao;

    // 插入数据
    public int create(ArticleTag articleTag){
        return articleTagDao.create(articleTag);
    }

    // 删除数据
    public int delete(Integer id){
        return articleTagDao.delete( Maps.build(id).getMap());
    }

    // 更新数据
    public int update(ArticleTag articleTag){
        return articleTagDao.update(Maps.build(articleTag.getId()).beanToMapForUpdate(articleTag));
    }

    // 查询
    public PageInfo<ArticleTag> query(ArticleTag articleTag){
        if (articleTag != null && articleTag.getPage() != null){
            PageHelper.startPage(articleTag.getPage(),articleTag.getLimit());
        }
        List<ArticleTag> list = articleTagDao.query(Maps.build().beanToMap(articleTag));
        return new PageInfo<ArticleTag>(list);
    }


    public ArticleTag detail(Integer id){
        return articleTagDao.detail(Maps.build(id).getMap());
    }

    public int count(ArticleTag articleTag){
        return articleTagDao.count(Maps.build().beanToMap(articleTag));
    }


}
