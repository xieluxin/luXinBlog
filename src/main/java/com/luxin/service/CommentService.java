package com.luxin.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luxin.entity.Comment;
import com.luxin.entity.Tag;
import com.luxin.mapper.CommentDao;
import com.luxin.utils.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    // 插入数据
    public int create(Comment comment){
        return commentDao.create(comment);
    }

    // 删除数据
    public int delete(Integer id){
        return commentDao.delete( Maps.build(id).getMap());
    }

    // 更新数据
    public int update(Comment comment){
        return commentDao.update(Maps.build(comment.getId()).beanToMapForUpdate(comment));
    }

    // 查询
    public PageInfo<Comment> query(Comment comment){
        if (comment != null && comment.getPage() != null){
            PageHelper.startPage(comment.getPage(),comment.getLimit());
        }
        List<Comment> list = commentDao.query( Maps.build().beanToMap( comment ) );
        return new PageInfo<Comment>(list);
    }


    public Comment detail(Integer id){
        return commentDao.detail(Maps.build(id).getMap());
    }

    public int count(Comment comment){
        return commentDao.count(Maps.build().beanToMap(comment));
    }


}
