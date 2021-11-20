package com.luxin.mapper;

import com.luxin.entity.Channel;

import java.util.List;
import java.util.Map;

public interface ChannelDao {
    public int create(Channel channel);

    public int delete(Map<String,Object> paramMap);

    public int update(Map<String,Object> paramMap);

    public List<Channel> query(Map<String,Object> paramMap);

    public Channel detail(Map<String,Object> paramMap);

    public int count(Map<String,Object> paramMap);
}
