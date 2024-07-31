package com.ddd.infra.listeners;

import com.ddd.domain.article.ArticleProvider;
import com.ddd.domain.editeur.EditorProvider;
import com.ddd.domain.event.Event;
import com.ddd.domain.event.SubmitedArticle;
import com.ddd.infra.providers.InMemoryEventProvider;
import org.springframework.stereotype.Component;

@Component
public class InMemoryEventListener {

    private final InMemoryEventProvider inMemoryEventProvider;
    private final ArticleProvider articleProvider;
    private final EditorProvider editorProvider;

    public InMemoryEventListener(InMemoryEventProvider inMemoryEventProvider,
                                 ArticleProvider articleProvider,
                                 EditorProvider editorProvider) throws InterruptedException {
        this.inMemoryEventProvider = inMemoryEventProvider;
        this.articleProvider = articleProvider;
        this.editorProvider = editorProvider;
        this.listen();
    }

    void listen() throws InterruptedException {
        for (; ; ) {
            Event event = inMemoryEventProvider.get();
            if (event instanceof SubmitedArticle) {
                editorProvider.getFirstAvailable().ifPresent(editor -> {
                    articleProvider.ofId(((SubmitedArticle) event).getArticleId())
                            .ifPresent(article -> {
                                editor.analyze(article);
                                inMemoryEventProvider.remove(event);
                            });
                });

            }

            Thread.sleep(500);
        }

    }
}
