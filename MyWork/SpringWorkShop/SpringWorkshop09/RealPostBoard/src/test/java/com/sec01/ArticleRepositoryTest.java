package com.sec01;

import com.sec01.entity.Article;
import com.sec01.repository.ArticleRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Transactional
class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    @DisplayName("글 저장 및 조회 테스트")
    void saveAndFindArticle() {
        // given
        Article article = new Article();
        article.setTitle("Test Title");
        article.setContent("Test Content");

        // when
        Article saved = articleRepository.save(article);
        List<Article> articles = articleRepository.findAll();

        // then
        assertThat(saved.getId()).isNotNull();
        assertThat(articles).hasSize(1);
        assertThat(articles.get(0).getTitle()).isEqualTo("Test Title");
        assertThat(articles.get(0).getContent()).isEqualTo("Test Content");
    }
}
