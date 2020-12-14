package com.freetimers.spartacus.mongodb;

import org.bson.Document;
import org.springframework.core.convert.converter.Converter;

public class DocumentClassConverter implements Converter<Document, Class> {

    @Override
    public Class convert(Document source) {
        try {
            return Class.forName(source.getString("name"));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }
}
