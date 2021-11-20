package com.luxin.controller;

import com.github.pagehelper.PageInfo;
import com.luxin.entity.Channel;
import com.luxin.entity.User;
import com.luxin.service.ChannelService;
import com.luxin.utils.RequestUtils;
import com.luxin.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/channel")
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    // 新增
    @PostMapping("/create")
    public Result create(@RequestBody Channel channel,HttpServletRequest request){
        User user = (User) request.getAttribute( "user" );
        channel.setCreateUser(user.getId());
        if (channel.getParentId() == null){
            channel.setParentId(0);
        }
        channelService.create(channel);
        return Result.ok(channel);
    }

    // 删除
    @PostMapping("/delete")
    public Result delete(Integer id){
        channelService.delete(id);
        return Result.ok();
    }

    // 更新
    @PostMapping("/update")
    public Result update(@RequestBody Channel channel){
        channelService.update(channel);
        return Result.ok(channel);
    }

    // 查询
    @PostMapping("/query")
    public Map query(@RequestBody Channel channel){
        PageInfo<Channel> pageInfo = channelService.query(channel);
        return Result.ok(pageInfo);
    }

    // 树形
    @PostMapping("/tree")
    public Result tree(){
        List<Channel> list = channelService.all();
        List<Map<String,Object>> mapList = new ArrayList<>();

        for (Channel channel : list){
            // 获取顶级栏目
            if (channel.getParentId() == 0){
                Map<String,Object> map = new HashMap<>();
                map.put("id",channel.getId());
                map.put("label",channel.getName());
                List<Map<String,Object>> children = new ArrayList<>();
                for (Channel entity : list){
                    if (entity.getParentId() == channel.getId()){
                        Map<String,Object> subMap = new HashMap<>();
                        subMap.put("id",entity.getId());
                        subMap.put("label",entity.getName());
                        children.add(subMap);
                    }
                }
                map.put("children",children);
                mapList.add(map);
            }
        }
        return Result.ok(mapList);
    }


    // 详情
    @PostMapping("/detail")
    public Result detail(Integer id){
        Channel channel = channelService.detail( id );
        return Result.ok(channel);
    }

    // 重要
    @PostMapping("/count")
    public Result  count(@RequestBody Channel channel){
        Integer count = channelService.count( channel );
        return Result.ok(count);
    }

    // 文件上传
    @PostMapping("/uploadFile")
    public Result count(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        String originalFilename = multipartFile.getOriginalFilename();
        // 获取文件名后缀
        String ext = originalFilename.substring( originalFilename.lastIndexOf( "." ) + 1, originalFilename.length() );

        String newFileNamePrefix = UUID.randomUUID().toString();
        String newFileName = newFileNamePrefix + "." + ext;

        multipartFile.transferTo(new File("D:\\upload",newFileName) );

        // 返回可访问的全路径
        return Result.ok( RequestUtils.getBasePath(request)+"upload/"+newFileName);
    }

}
