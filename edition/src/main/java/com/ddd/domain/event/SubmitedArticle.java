package com.ddd.domain.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubmitedArticle extends Event {

    private String articleId;
}
