package com.sec01.service;


import com.sec01.entity.Article;
import com.sec01.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;


    public String createArticle(String title, String content) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);

        articleRepository.save(article);
        return "/redirect:/";
    }
}
