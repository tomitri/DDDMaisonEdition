package com.ddd.domain.article;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Article {

    private String id;
    private String title;
    private String status;
    private String content;
    private String domain;



}
