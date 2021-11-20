package com.luxin.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luxin.entity.Channel;
import com.luxin.mapper.ChannelDao;
import com.luxin.utils.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {

    @Autowired
    private ChannelDao channelDao;

    // 插入数据
    public int create(Channel channel){
        return channelDao.create(channel);
    }

    // 删除数据
    public int delete(Integer id){
        return channelDao.delete( Maps.build(id).getMap());
    }

    // 更新数据
    public int update(Channel channel){
        return channelDao.update(Maps.build(channel.getId()).beanToMapForUpdate(channel));
    }

    // 查询
    public PageInfo<Channel> query(Channel channel){
        if (channel != null && channel.getPage() != null){
            PageHelper.startPage(channel.getPage(),channel.getLimit());
        }
        List<Channel> list = channelDao.query(Maps.build().beanToMap(channel));
        return new PageInfo<Channel>(list);
    }

    public List<Channel> getChannelByPos(String pos){
        List<Channel> list = channelDao.query( Maps.build().put( "pos", pos ).getMap() );
        return list;
    }

    // tree 树形
    public List<Channel> all(){
        return channelDao.query(Maps.build().getMap());
    }


    public Channel detail(Integer id){
        return channelDao.detail(Maps.build(id).getMap());
    }

    public int count(Channel channel){
        return channelDao.count(Maps.build().beanToMap(channel));
    }


}
