package com.ddd.infra.endpoints;

import com.ddd.domain.article.Article;
import com.ddd.domain.auteur.Auteur;
import com.ddd.domain.event.EventProvider;
import com.ddd.infra.endpoints.model.SubmitedArticleVm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author")
@RequiredArgsConstructor
public class AuthorController {

    private final EventProvider eventProvider;

    @PostMapping
    public void submit(@RequestBody @Valid SubmitedArticleVm submitedArticleVm,
                       @RequestParam(name = "authorId") String authorId) {

        Article article = new Article();

        Auteur auteur = new Auteur();
        auteur.setId(authorId);
        auteur.setEventProvider(eventProvider);

        article.setTitle(submitedArticleVm.getTitle());
        article.setDomain(submitedArticleVm.getDomain());
        article.setContent(submitedArticleVm.getContent());

        auteur.submit(article);

    }
}
