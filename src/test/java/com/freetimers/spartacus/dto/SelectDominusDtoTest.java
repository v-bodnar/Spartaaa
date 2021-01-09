package com.freetimers.spartacus.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SelectDominusDtoTest {
    private ObjectMapper mapper = objectMapper();
    private String json = "{\"gameId\":\"5ff97811f5a3916ca06939d4\",\"dominusBoardId\":\"5ff977f8f5a3916ca06939c0\",\"playersName\":\"sardine\"}";

    @Test
    public void deserializationTest() throws JsonProcessingException {
        //when
        SelectDominusDto deserializedValue = mapper.readValue(json, SelectDominusDto.class);

        //then
        assertNotNull(deserializedValue);
        assertEquals("5ff97811f5a3916ca06939d4", deserializedValue.getGameId());
        assertEquals("5ff977f8f5a3916ca06939c0", deserializedValue.getDominusBoardId());
        assertEquals("sardine", deserializedValue.getPlayersName());
    }

    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);

        return mapper;
    }
}
