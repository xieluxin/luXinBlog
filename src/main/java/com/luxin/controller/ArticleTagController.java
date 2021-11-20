package com.luxin.controller;

import com.github.pagehelper.PageInfo;
import com.luxin.entity.ArticleTag;
import com.luxin.service.ArticleTagServer;
import com.luxin.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/articleArticleTag")
public class ArticleTagController {

    @Autowired
    private ArticleTagServer articleTagServer;

    // 新增
    @PostMapping("/create")
    public Result create(@RequestBody ArticleTag articleArticleTag){
        articleTagServer.create(articleArticleTag);
        return Result.ok(articleArticleTag);
    }

    // 删除
    @PostMapping("/delete")
    public Result delete(Integer id){
        articleTagServer.delete(id);
        return Result.ok();
    }

    // 更新
    @PostMapping("/update")
    public Result update(@RequestBody ArticleTag articleArticleTag){
        articleTagServer.update(articleArticleTag);
        return Result.ok(articleArticleTag);
    }

    // 查询
    @PostMapping("/query")
    public Map query(@RequestBody ArticleTag articleArticleTag){
        PageInfo<ArticleTag> pageInfo = articleTagServer.query(articleArticleTag);
        return Result.ok(pageInfo);
    }

    // 详情
    @PostMapping("/detail")
    public Result detail(Integer id){
        ArticleTag articleArticleTag = articleTagServer.detail( id );
        return Result.ok(articleArticleTag);
    }

    // 重要
    @PostMapping("/count")
    public Result  count(@RequestBody ArticleTag articleArticleTag){
        Integer count = articleTagServer.count( articleArticleTag );
        return Result.ok(count);
    }


}
