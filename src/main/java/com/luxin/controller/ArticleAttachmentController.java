package com.luxin.controller;

import com.github.pagehelper.PageInfo;
import com.luxin.entity.ArticleAttachment;
import com.luxin.service.ArticleAttachmentServer;
import com.luxin.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/articleAttachmentServer")
public class ArticleAttachmentController {

    @Autowired
    private ArticleAttachmentServer articleAttachmentServer;

    // 新增
    @PostMapping("/create")
    public Result create(@RequestBody ArticleAttachment articleAttachment){
        articleAttachmentServer.create(articleAttachment);
        return Result.ok(articleAttachment);
    }

    // 删除
    @PostMapping("/delete")
    public Result delete(Integer id){
        articleAttachmentServer.delete(id);
        return Result.ok();
    }

    // 更新
    @PostMapping("/update")
    public Result update(@RequestBody ArticleAttachment articleAttachment){
        articleAttachmentServer.update(articleAttachment);
        return Result.ok(articleAttachment);
    }

    // 查询
    @PostMapping("/query")
    public Map query(@RequestBody ArticleAttachment articleAttachment){
        PageInfo<ArticleAttachment> pageInfo = articleAttachmentServer.query(articleAttachment);
        return Result.ok(pageInfo);
    }

    // 详情
    @PostMapping("/detail")
    public Result detail(Integer id){
        ArticleAttachment tag = articleAttachmentServer.detail( id );
        return Result.ok(tag);
    }

    // 重要
    @PostMapping("/count")
    public Result  count(@RequestBody ArticleAttachment articleAttachment){
        Integer count = articleAttachmentServer.count( articleAttachment );
        return Result.ok(count);
    }


}
