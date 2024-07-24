package com.ddd.domain.commentaire;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comment {

    private int id;
    private LocalDateTime date;
    private String content;
    private String articleId;
    private String editorId;

}
