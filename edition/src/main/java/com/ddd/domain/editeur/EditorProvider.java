package com.ddd.domain.editeur;

import java.util.Optional;

public interface EditorProvider {

    Optional<Editor> getFirstAvailable();
}
