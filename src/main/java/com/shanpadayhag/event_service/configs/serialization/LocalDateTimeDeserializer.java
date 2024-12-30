package com.shanpadayhag.event_service.configs.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String value = parser.getText();
        try {
            return LocalDateTime.parse(value, FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(
                    String.format("Invalid date format '%s'. Please use 'yyyy-MM-dd HH:mm:ss'.", value));
        }
    }
}
