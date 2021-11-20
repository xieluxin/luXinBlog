package com.luxin.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luxin.entity.FriendLink;
import com.luxin.mapper.FriendLinkDao;
import com.luxin.utils.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendLinkService {

    @Autowired
    private FriendLinkDao friendLinkDao;

    // 插入数据
    public int create(FriendLink friendLink){
        return friendLinkDao.create(friendLink);
    }

    // 删除数据
    public int delete(Integer id){
        return friendLinkDao.delete( Maps.build(id).getMap());
    }

    // 更新数据
    public int update(FriendLink friendLink){
        return friendLinkDao.update(Maps.build(friendLink.getId()).beanToMapForUpdate(friendLink));
    }

    // 查询
    public PageInfo<FriendLink> query(FriendLink friendLink){
        if (friendLink != null && friendLink.getPage() != null){
            PageHelper.startPage(friendLink.getPage(),friendLink.getLimit());
        }
        List<FriendLink> list = friendLinkDao.query(Maps.build().beanToMap(friendLink));
        return new PageInfo<FriendLink>(list);
    }

    // 友情链接
    public List<FriendLink> getFriendLink(FriendLink friendLink){
        List<FriendLink> list = friendLinkDao.query( Maps.build().beanToMap( friendLink ) );
        return list;
    }

    public FriendLink detail(Integer id){
        return friendLinkDao.detail(Maps.build(id).getMap());
    }

    public int count(FriendLink friendLink){
        return friendLinkDao.count(Maps.build().beanToMap(friendLink));
    }


}
