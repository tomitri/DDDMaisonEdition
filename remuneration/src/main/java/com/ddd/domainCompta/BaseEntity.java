package com.ddd.domainCompta;

import lombok.Data;

@Data
public class BaseEntity {

    private String idArticle;
    private String isbn;
    private Long nombreVues;

}
