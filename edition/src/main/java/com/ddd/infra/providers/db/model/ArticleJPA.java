package com.ddd.infra.providers.db.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleJPA {

    @Id
    private Long id;
    private String ref;
    private String title;
    private String status;
    private String content;
    private String domain;
}
