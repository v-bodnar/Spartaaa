package com.freetimers.spartacus.gamebox;

import java.util.Objects;

public class DominusBoard {
    private final String id;
    private final String titleKey;
    private final String title;
    private final String descriptionKey;
    private final String description;
    private final Integer startingGold;
    private final Integer startingGladiators;
    private final Integer startingSlaves;
    private final Integer startingGuards;

    public DominusBoard(String id, String titleKey, String title, String descriptionKey,
                        String description, Integer startingGold, Integer startingGladiators,
                        Integer startingSlaves, Integer startingGuards) {
        this.id = id;
        this.titleKey = Objects.requireNonNull(titleKey);
        this.title = title;
        this.descriptionKey = Objects.requireNonNull(descriptionKey);
        this.description = description;
        this.startingGold = Objects.requireNonNull(startingGold);
        this.startingGladiators = Objects.requireNonNull(startingGladiators);
        this.startingSlaves = Objects.requireNonNull(startingSlaves);
        this.startingGuards = Objects.requireNonNull(startingGuards);
    }

    public static DominusBoard of(String titleKey, String descriptionKey, Integer startingGold, Integer startingGladiators,
                                  Integer startingSlaves, Integer startingGuards) {
        return new DominusBoard(null,titleKey,null, descriptionKey, null, startingGold, startingGladiators,
                startingSlaves, startingGuards);
    }

    public String getId() {
        return id;
    }

    public String getTitleKey() {
        return titleKey;
    }

    public String getTitle() {
        return title;
    }

    public String getDescriptionKey() {
        return descriptionKey;
    }

    public String getDescription() {
        return description;
    }

    public int getStartingGold() {
        return startingGold;
    }

    public int getStartingGladiators() {
        return startingGladiators;
    }

    public int getStartingSlaves() {
        return startingSlaves;
    }

    public int getStartingGuards() {
        return startingGuards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DominusBoard that = (DominusBoard) o;
        return startingGold == that.startingGold &&
                startingGladiators == that.startingGladiators &&
                startingSlaves == that.startingSlaves &&
                startingGuards == that.startingGuards &&
                Objects.equals(id, that.id) &&
                Objects.equals(titleKey, that.titleKey) &&
                Objects.equals(title, that.title) &&
                Objects.equals(descriptionKey, that.descriptionKey) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titleKey, title, descriptionKey, description, startingGold, startingGladiators, startingSlaves, startingGuards);
    }

    @Override
    public String toString() {
        return "DominusBoard{" +
                "id='" + id + '\'' +
                ", titleKey='" + titleKey + '\'' +
                ", title='" + title + '\'' +
                ", descriptionKey='" + descriptionKey + '\'' +
                ", description='" + description + '\'' +
                ", startingGold=" + startingGold +
                ", startingGladiators=" + startingGladiators +
                ", startingSlaves=" + startingSlaves +
                ", startingGuards=" + startingGuards +
                '}';
    }
}
