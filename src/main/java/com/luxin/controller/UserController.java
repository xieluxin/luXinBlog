package com.luxin.controller;

import com.github.pagehelper.PageInfo;
import com.luxin.entity.User;
import com.luxin.service.UserService;
import com.luxin.utils.RequestUtils;
import com.luxin.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 新增
    @PostMapping("/create")
    public Result create(@RequestBody User user){
        userService.create(user);
        return Result.ok(user);
    }

    // 删除
    @PostMapping("/delete")
    public Result delete(Integer id){
        userService.delete(id);
        return Result.ok();
    }

    // 更新
    @PostMapping("/update")
    public Result update(@RequestBody User user){
        userService.update(user);
        return Result.ok(user);
    }

    // 查询
    @PostMapping("/query")
    public Map query(@RequestBody User user){
        PageInfo<User> pageInfo = userService.query(user);
        return Result.ok(pageInfo);
    }

    // 详情
    @PostMapping("/detail")
    public Result detail(Integer id){
        User user = userService.detail( id );
        return Result.ok(user);
    }

    // 重要
    @PostMapping("/count")
    public Result  count(@RequestBody User user){
        Integer count = userService.count( user );
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
