package com.freetimers.spartacus.websocket;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.freetimers.spartacus.dto.CoreGameDto;
import com.freetimers.spartacus.dto.DominusBoardDto;

import java.util.List;
import java.util.Objects;

class SerializablePair {
    @JsonProperty
    private final CoreGameDto key;
    @JsonProperty
    private final List<DominusBoardDto> value;

    public SerializablePair(@JsonProperty CoreGameDto key, @JsonProperty List<DominusBoardDto> value) {
        this.key = key;
        this.value = value;
    }

    public CoreGameDto getKey() {
        return key;
    }

    public List<DominusBoardDto> getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SerializablePair that = (SerializablePair) o;
        return Objects.equals(key, that.key) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
