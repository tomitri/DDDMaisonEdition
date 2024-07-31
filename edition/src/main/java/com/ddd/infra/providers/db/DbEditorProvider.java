package com.ddd.infra.providers.db;

import com.ddd.domain.editeur.Editor;
import com.ddd.domain.editeur.EditorProvider;

import java.util.Optional;

public class DbEditorProvider implements EditorProvider {
    @Override
    public Optional<Editor> getFirstAvailable() {
        return Optional.empty();
    }
}
