package com.luxin.mapper;

import com.luxin.entity.Tag;

import java.util.List;
import java.util.Map;

public interface TagDao {
    public int create(Tag tag);

    public int delete(Map<String,Object> paramMap);

    public int update(Map<String,Object> paramMap);

    public List<Tag> query(Map<String,Object> paramMap);

    public Tag detail(Map<String,Object> paramMap);

    public int count(Map<String,Object> paramMap);
}
