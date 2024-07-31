package com.ddd.infra.providers.db;

import com.ddd.infra.providers.db.model.ArticleJPA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<ArticleJPA, Long> {

    Optional<ArticleJPA> findByRef(String ref);
}
