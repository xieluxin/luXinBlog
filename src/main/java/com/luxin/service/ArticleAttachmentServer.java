package com.luxin.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luxin.entity.ArticleAttachment;
import com.luxin.mapper.ArticleAttachmentDao;
import com.luxin.utils.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleAttachmentServer {

    @Autowired
    private ArticleAttachmentDao articleAttachmentDao;

    // 插入数据
    public int create(ArticleAttachment articleAttachment){
        return articleAttachmentDao.create(articleAttachment);
    }

    // 删除数据
    public int delete(Integer id){
        return articleAttachmentDao.delete( Maps.build(id).getMap());
    }

    // 更新数据
    public int update(ArticleAttachment articleAttachment){
        return articleAttachmentDao.update(Maps.build(articleAttachment.getId()).beanToMapForUpdate(articleAttachment));
    }

    // 查询
    public PageInfo<ArticleAttachment> query(ArticleAttachment articleAttachment){
        if (articleAttachment != null && articleAttachment.getPage() != null){
            PageHelper.startPage(articleAttachment.getPage(),articleAttachment.getLimit());
        }
        List<ArticleAttachment> list = articleAttachmentDao.query(Maps.build().beanToMap(articleAttachment));
        return new PageInfo<ArticleAttachment>(list);
    }


    public ArticleAttachment detail(Integer id){
        return articleAttachmentDao.detail(Maps.build(id).getMap());
    }

    public int count(ArticleAttachment articleAttachment){
        return articleAttachmentDao.count(Maps.build().beanToMap(articleAttachment));
    }


}
