//package com.freetimers.spartacus.mongodb;
//
//import com.freetimers.spartacus.gamebox.Slave;
//import org.bson.Document;
//import org.springframework.core.convert.converter.Converter;
//
//public class SlaveConverter implements Converter<Document, Slave> {
//
//    private TranslationService translationService;
//
//    public SlaveConverter(TranslationService translationService) {
//        this.translationService = translationService;
//    }
//
//    @Override
//    public Slave convert(Document value) {
//        return new Slave(value.getObjectId("_id").toHexString(),
//                value.getString("titleKey"),
//                translationService.translate(value.getString("titleKey")),
//                value.getString("descriptionKey"),
//                translationService.translate(value.getString("descriptionKey")),
//                value.getInteger("price"),
//                value.getInteger("attack"),
//                value.getInteger("defence"),
//                value.getInteger("speed"));
//
//    }
//}
