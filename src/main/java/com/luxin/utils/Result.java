package com.luxin.utils;

import com.github.pagehelper.PageInfo;

import java.util.Map;

public class Result {

    public static Integer SUCCESS_CODE = 200;
    public static Integer ERROR_CODE = 200;

    public Integer status = SUCCESS_CODE;
    public static String msg = "操作成功";
    public Object date = null;

    // 失败 响应
    public static Result fail(Integer status,String msg){
        return new Result(status,msg,null);
    }

//    public static Result fail(String msg,Object date){
//        return new Result(ERROR_CODE,msg,date);
//    }

    public static Result fail(String msg){
        return new Result(ERROR_CODE,msg,null);
    }

    public static Result fail(){
        return new Result(ERROR_CODE,"操作失败");
    }

    // 成功 响应
    public static Result ok(Integer integer,String msg,Object date){
        return new Result(integer,msg,date);
    }

    public static Result ok(String msg,Object date){
        return new Result(msg,date);
    }

    public static Result ok(Object date){
        return new Result(date);
    }
    public static Map ok(PageInfo pageInfo){
       return Maps.build().put("status",SUCCESS_CODE)
                .put("msg",msg)
                .put("list",pageInfo.getList())
                .put("total",pageInfo.getTotal())
                .getMap();
    }


    public static Result ok(){
        return new Result();
    }

    // 构造重载
    public Result( ){
    }
    public Result(Object date){
        this.date = date;
    }


    public Result(String msg,Object date){
         this.msg = msg;
        this.date = date;
    }

    public Result(Integer status,String msg){
        this.status = status;
        this.msg = msg;
    }

    public Result(Integer status,String msg,Object date){
        this.status = status;
        this.msg = msg;
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }
}
