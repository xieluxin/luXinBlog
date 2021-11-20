package com.luxin.framework.mvc;

import com.luxin.entity.User;
import com.luxin.framework.exception.MyException;
import com.luxin.framework.jwt.JWTUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
* token 拦截器
* */

public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(JWTUtil.token);
        User user = JWTUtil.getUser(token);
        if (user == null){
            throw new MyException("超时或者不合法");
        }
        //token续期
        String newToken = JWTUtil.sign(user);
        response.setHeader(JWTUtil.token,newToken);
        request.setAttribute("user",user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
