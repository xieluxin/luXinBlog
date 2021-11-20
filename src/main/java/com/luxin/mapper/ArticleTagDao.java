package com.luxin.mapper;

import com.luxin.entity.ArticleTag;

import java.util.List;
import java.util.Map;

public interface ArticleTagDao {
    public int create(ArticleTag articleTag);

    public int delete(Map<String,Object> paramMap);

    public int update(Map<String,Object> paramMap);

    public List<ArticleTag> query(Map<String,Object> paramMap);

    public ArticleTag detail(Map<String,Object> paramMap);

    public int count(Map<String,Object> paramMap);
}
