package com.luxin.controller;

import com.luxin.entity.User;
import com.luxin.framework.jwt.JWTUtil;
import com.luxin.service.UserService;
import com.luxin.utils.Maps;
import com.luxin.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody Map<String,String> map){
        String userName = map.get("userName");
        String password = map.get("password");
        User user = userService.login( userName, password );
        if (user!=null){
            String token = JWTUtil.sign( user );
            return Result.ok(Maps.build().put( "token", token ).put( "user", user ).getMap());
        }else {
            return Result.fail("用户名或密码错误");
        }
    }
}
