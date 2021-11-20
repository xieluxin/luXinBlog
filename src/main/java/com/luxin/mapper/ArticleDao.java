package com.luxin.mapper;

import com.luxin.entity.Article;

import java.util.List;
import java.util.Map;

public interface ArticleDao {

    public int create(Article article);

    public int delete(Map<String,Object> paramMap);

    public int update(Map<String,Object> paramMap);

    public List<Article> query(Map<String,Object> paramMap);

    public Article detail(Map<String,Object> paramMap);

    public int count(Map<String,Object> paramMap);
}
