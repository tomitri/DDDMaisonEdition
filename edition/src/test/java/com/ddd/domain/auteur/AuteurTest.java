package com.ddd.domain.auteur;

import com.ddd.domain.event.EventProvider;
import com.ddd.domain.event.SubmitedArticle;
import com.ddd.domain.article.Article;
import com.ddd.domain.editeur.Editor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuteurTest {

    @Mock
    private Editor editor;

    private Auteur auteur;
    private Article article;
    @Mock
    private EventProvider eventProvider;

    @BeforeEach
    void setUp() {
        auteur = new Auteur();
        auteur.setEventProvider(eventProvider);

        article = new Article();
        article.setId("articleId");
    }

    @Test
    void submitAnArticleShouldPublishEvent() {
        //Given
        doNothing().when(eventProvider).publish(any());
        //When
        auteur.submit(article);
        //Then
        ArgumentCaptor<SubmitedArticle> argumentCaptor = ArgumentCaptor.forClass(SubmitedArticle.class);

        verify(eventProvider, times(1)).publish(argumentCaptor.capture());
        SubmitedArticle submitedArticleCaptured = argumentCaptor.getValue();

        assertThat(submitedArticleCaptured.getArticleId()).isEqualTo(article.getId());
    }
}