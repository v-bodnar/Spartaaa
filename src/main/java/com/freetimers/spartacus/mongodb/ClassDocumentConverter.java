package com.freetimers.spartacus.mongodb;

import org.bson.Document;
import org.springframework.core.convert.converter.Converter;

public class ClassDocumentConverter implements Converter<Class, Document> {

    @Override
    public Document convert(Class source) {
        return new Document("name", source.getName());
    }
}
