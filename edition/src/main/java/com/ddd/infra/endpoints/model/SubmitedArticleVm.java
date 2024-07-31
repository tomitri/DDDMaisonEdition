package com.ddd.infra.endpoints.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubmitedArticleVm {

    @NotNull
    private String title;
    @NotNull
    private String content;
    @NotNull
    private String domain;

}
