package com.freetimers.spartacus.gamebox;

public class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public void printInfo() {

        String causeMessage = getCause() == null ? "None" : getCause().getMessage();
        String causeClass = getCause() == null ? "None" : getCause().getClass().getSimpleName();

        System.out.println(String.format("Возникла ошибка: %s, причина: %s, тип причины: %s ", getMessage(), causeMessage, causeClass));
        printStackTrace();

    }
}
