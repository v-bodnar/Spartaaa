package com.freetimers.spartacus.dto;

import java.util.Objects;

public class DominusBoardDto {
    private final String id;
    private final String title;
    private final String description;
    private final Integer startingGold;
    private final Integer startingGladiators;
    private final Integer startingSlaves;
    private final Integer startingGuards;

    public DominusBoardDto(String id, String title, String description, Integer startingGold,
                           Integer startingGladiators, Integer startingSlaves, Integer startingGuards) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startingGold = startingGold;
        this.startingGladiators = startingGladiators;
        this.startingSlaves = startingSlaves;
        this.startingGuards = startingGuards;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getStartingGold() {
        return startingGold;
    }

    public Integer getStartingGladiators() {
        return startingGladiators;
    }

    public Integer getStartingSlaves() {
        return startingSlaves;
    }

    public Integer getStartingGuards() {
        return startingGuards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DominusBoardDto that = (DominusBoardDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(startingGold, that.startingGold) &&
                Objects.equals(startingGladiators, that.startingGladiators) &&
                Objects.equals(startingSlaves, that.startingSlaves) &&
                Objects.equals(startingGuards, that.startingGuards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, startingGold, startingGladiators, startingSlaves, startingGuards);
    }

    @Override
    public String toString() {
        return "DominusBoardDto{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startingGold=" + startingGold +
                ", startingGladiators=" + startingGladiators +
                ", startingSlaves=" + startingSlaves +
                ", startingGuards=" + startingGuards +
                '}';
    }
}
