package com.shanpadayhag.event_service.requests.events;

import java.time.LocalDateTime;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.shanpadayhag.event_service.configs.serialization.LocalDateTimeDeserializer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateEventRequest(
        @NotBlank(message = "Title can't be blank. Please add one!") @Size(max = 255, message = "Keep your title short, under 255 characters!") String title,

        @NotNull(message = "Event's start date and time can't be empty. Please pick one!") @JsonDeserialize(using = LocalDateTimeDeserializer.class) @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime start,

        @NotNull(message = "Event's end date and time can't be empty. Please pick one!") @JsonDeserialize(using = LocalDateTimeDeserializer.class) @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime end,

        Optional<String> color) {

    public UpdateEventRequest {
        if (start != null && end != null && start.isAfter(end)) {
            throw new IllegalArgumentException("Event's start date and time must be before event's end date and time.");
        }

        color.ifPresent(value -> {
            if (value.length() > 50)
                throw new IllegalArgumentException("Keep your color short, under 50 characters!");
        });
    }
}
