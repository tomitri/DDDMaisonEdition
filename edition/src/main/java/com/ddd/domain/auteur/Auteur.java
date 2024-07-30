package com.ddd.domain.auteur;

import com.ddd.domain.Skill;
import com.ddd.domain.article.Article;
import com.ddd.domain.editeur.Editor;
import com.ddd.domain.event.Event;
import com.ddd.domain.event.EventProvider;
import com.ddd.domain.event.SubmitedArticle;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Auteur {

    private String id;
    private List<Skill> skills;
    private String email;
    private EventProvider eventProvider;

    public void submit(Article article) {
        SubmitedArticle event = new SubmitedArticle();
        event.setArticleId(article.getId());
        eventProvider.publish(event);
    }

}
