package com.ddd.domain.article;

import java.util.Optional;

public interface ArticleProvider {

    Optional<Article> ofId(String id);

    Article save(Article article);
}
