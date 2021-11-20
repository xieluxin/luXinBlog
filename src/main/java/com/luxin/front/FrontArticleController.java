package com.luxin.front;

import com.github.pagehelper.PageInfo;
import com.luxin.entity.Article;
import com.luxin.entity.FriendLink;
import com.luxin.service.ArticleService;
import com.luxin.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/f/article")
public class FrontArticleController {

    @Autowired
    private ArticleService articleService;
    
    @GetMapping("/get")
    public Result getById(Integer id){
        Article detail = articleService.detail( id );
        return Result.ok(detail);
    }


    @GetMapping("/getList")
    public Map getByChannelId(Article article){
        PageInfo<Article> page = articleService.query( article );
        return Result.ok(page);
    }

    @GetMapping("/getTop")
    public Result getBuId(Article article,Integer top){
        List<Article> list = articleService.top( article, top );
        return Result.ok(list);
    }


}
