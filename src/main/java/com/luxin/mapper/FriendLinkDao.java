package com.luxin.mapper;

import com.luxin.entity.ArticleAttachment;
import com.luxin.entity.FriendLink;

import java.util.List;
import java.util.Map;

public interface FriendLinkDao {
    public int create(FriendLink friendLink);

    public int delete(Map<String,Object> paramMap);

    public int update(Map<String,Object> paramMap);

    public List<FriendLink> query(Map<String,Object> paramMap);

    public FriendLink detail(Map<String,Object> paramMap);

    public int count(Map<String,Object> paramMap);
}
