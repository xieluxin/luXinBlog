package com.luxin.mapper;

import com.luxin.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {

    public int create(User user);

    public int delete(Map<String,Object> paramMap);

    public int update(Map<String,Object> paramMap);

    public List<User> query(Map<String,Object> paramMap);

    public User detail(Map<String,Object> paramMap);

//     User getUser(@Param( "username" )String username, @Param( "password" ) String password);

    public int count(Map<String,Object> paramMap);
}
