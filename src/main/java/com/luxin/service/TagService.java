package com.luxin.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luxin.entity.Tag;
import com.luxin.mapper.TagDao;
 import com.luxin.utils.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagDao tagDao;

    // 插入数据
    public int create(Tag tag){
        return tagDao.create(tag);
    }

    // 删除数据
    public int delete(Integer id){
        return tagDao.delete( Maps.build(id).getMap());
    }

    // 更新数据
    public int update(Tag tag){
        return tagDao.update(Maps.build(tag.getId()).beanToMapForUpdate(tag));
    }

    // 查询 全部
    public List<Tag> all(){
        List<Tag> list = tagDao.query(null);
       return list;
    }

    // 查询
    public PageInfo<Tag> query(Tag tag){
        if (tag != null && tag.getPage() != null){
            PageHelper.startPage(tag.getPage(),tag.getLimit());
        }
        List<Tag> list = tagDao.query(Maps.build().beanToMap(tag));
        return new PageInfo<Tag>(list);
    }


    public Tag detail(Integer id){
        return tagDao.detail(Maps.build(id).getMap());
    }

    public int count(Tag tag){
        return tagDao.count(Maps.build().beanToMap(tag));
    }


}
