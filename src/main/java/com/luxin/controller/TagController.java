package com.luxin.controller;

import com.github.pagehelper.PageInfo;
import com.luxin.entity.Tag;
import com.luxin.service.TagService;
import com.luxin.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    // 新增
    @PostMapping("/create")
    public Result create(@RequestBody Tag tag){
        tagService.create(tag);
        return Result.ok(tag);
    }

    // 删除
    @PostMapping("/delete")
    public Result delete(Integer id){
        tagService.delete(id);
        return Result.ok();
    }

    // 更新
    @PostMapping("/update")
    public Result update(@RequestBody Tag tag){
        tagService.update(tag);
        return Result.ok(tag);
    }

    // 查询
    @PostMapping("/query")
    public Map query(@RequestBody Tag tag){
        PageInfo<Tag> pageInfo = tagService.query(tag);
        return Result.ok(pageInfo);
    }

    // 查询全部
    @PostMapping("/all")
    public Result all(){
      return Result.ok(tagService.all());
    }

    // 详情
    @PostMapping("/detail")
    public Result detail(Integer id){
        Tag tag = tagService.detail( id );
        return Result.ok(tag);
    }

    // 重要
    @PostMapping("/count")
    public Result  count(@RequestBody Tag tag){
        Integer count = tagService.count( tag );
        return Result.ok(count);
    }

    // 标签云
    @PostMapping("/tagAll")
    public Result tagAll(Tag tag){
        return Result.ok(tagService.all());
    }
 

}
