package com.luxin.controller;

import com.github.pagehelper.PageInfo;
import com.luxin.entity.Comment;
import com.luxin.service.CommentService;
import com.luxin.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 新增
    @PostMapping("/create")
    public Result create(@RequestBody Comment comment){
        commentService.create(comment);
        return Result.ok(comment);
    }

    // 删除
    @PostMapping("/delete")
    public Result delete(Integer id){
        commentService.delete(id);
        return Result.ok();
    }

    // 更新
    @PostMapping("/update")
    public Result update(@RequestBody Comment comment){
        commentService.update(comment);
        return Result.ok(comment);
    }

    // 查询
    @PostMapping("/query")
    public Map query(@RequestBody Comment comment){
        PageInfo<Comment> pageInfo = commentService.query(comment);
        return Result.ok(pageInfo);
    }

    // 详情
    @PostMapping("/detail")
    public Result detail(Integer id){
        Comment comment = commentService.detail( id );
        return Result.ok(comment);
    }

    // 重要
    @PostMapping("/count")
    public Result  count(@RequestBody Comment comment){
        Integer count = commentService.count( comment );
        return Result.ok(count);
    }


}
