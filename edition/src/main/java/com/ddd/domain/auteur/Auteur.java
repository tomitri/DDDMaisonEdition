package com.ddd.domain.auteur;

import com.ddd.domain.Skill;
import com.ddd.domain.article.Article;
import com.ddd.domain.article.ArticleProvider;
import com.ddd.domain.editeur.Editor;
import com.ddd.domain.event.Event;
import com.ddd.domain.event.EventProvider;
import com.ddd.domain.event.SubmitedArticle;
import lombok.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Auteur {

    private String id;
    private List<Skill> skills;
    private String email;
    private EventProvider eventProvider;
    private ArticleProvider articleProvider;

    public void submit(Article article) {

        Optional<Article> existingArticle = articleProvider.ofId(article.getId());

        existingArticle.ifPresentOrElse(
                a -> {

                    a.setStatus("SUBMITED");
                    articleProvider.save(a);

                    SubmitedArticle event = new SubmitedArticle();
                    event.setArticleId(a.getId());
                    eventProvider.publish(event);
                },
                () -> {
                    article.setId(null);
                    article.setStatus("SUBMITED");
                    Article newArticle = articleProvider.save(article);

                    SubmitedArticle event = new SubmitedArticle();
                    event.setArticleId(newArticle.getId());
                    eventProvider.publish(event);

                }
        );


    }

}
