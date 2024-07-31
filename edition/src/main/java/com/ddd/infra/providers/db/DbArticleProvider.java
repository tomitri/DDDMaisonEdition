package com.ddd.infra.providers.db;

import com.ddd.domain.article.Article;
import com.ddd.domain.article.ArticleProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DbArticleProvider implements ArticleProvider {

    private final ArticleRepository articleRepository;

    @Override
    public Optional<Article> ofId(String id) {

        var existingArticle = articleRepository.findByRef(id).orElseThrow();

        Article article = new Article();

        article.setTitle(existingArticle.getTitle());
        article.setDomain(existingArticle.getDomain());
        article.setContent(existingArticle.getContent());

        return Optional.of(article);
    }

    @Override
    public Article save(Article article) {
        return null;
    }
}
