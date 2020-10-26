package com.freetimers.spartacus.gamebox;

import java.util.Optional;

public interface Card {

    int getPrice();

    String getDescriptionKey();

    Optional<String> getId();

    String getTitleKey();

    Optional<String> getTitle();

    Optional<String> getDescription();
}

