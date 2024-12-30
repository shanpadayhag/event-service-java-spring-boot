package com.shanpadayhag.event_service.mappers.events;

import org.springframework.stereotype.Component;

import com.shanpadayhag.event_service.dtos.events.NewEventDTO;
import com.shanpadayhag.event_service.models.Event;

@Component
public class NewEventMapper {
    public NewEventDTO toNewEventDTO(Event event) {
        return new NewEventDTO(
                event.getId(),
                event.getTitle(),
                event.getStart(),
                event.getEnd(),
                event.getColor().orElse(null));
    }
}
