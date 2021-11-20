package com.luxin.controller;

import com.github.pagehelper.PageInfo;
import com.luxin.entity.FriendLink;
import com.luxin.service.FriendLinkService;
import com.luxin.utils.RequestUtils;
import com.luxin.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/friendLink")
public class FriendLinkController {

    @Autowired
    private FriendLinkService friendLinkService;

    // 新增
    @PostMapping("/create")
    public Result create(@RequestBody FriendLink friendLink){
        friendLinkService.create(friendLink);
        return Result.ok(friendLink);
    }

    // 删除
    @PostMapping("/delete")
    public Result delete(Integer id){
        friendLinkService.delete(id);
        return Result.ok();
    }

    // 更新
    @PostMapping("/update")
    public Result update(@RequestBody FriendLink friendLink){
        friendLinkService.update(friendLink);
        return Result.ok(friendLink);
    }

    // 查询
    @PostMapping("/query")
    public Map query(@RequestBody FriendLink friendLink){
        PageInfo<FriendLink> pageInfo = friendLinkService.query(friendLink);
        return Result.ok(pageInfo);
    }

    // 详情
    @PostMapping("/detail")
    public Result detail(Integer id){
        FriendLink friendLink = friendLinkService.detail( id );
        return Result.ok(friendLink);
    }

    // 重要
    @PostMapping("/count")
    public Result  count(@RequestBody FriendLink friendLink){
        Integer count = friendLinkService.count( friendLink );
        return Result.ok(count);
    }

    // 友情链接
    @GetMapping("/getListLink")
    public Result getListLink(){
        FriendLink friendLink = new FriendLink();
        List<FriendLink> friendLink1 = friendLinkService.getFriendLink( friendLink );
        return Result.ok(friendLink1);
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
