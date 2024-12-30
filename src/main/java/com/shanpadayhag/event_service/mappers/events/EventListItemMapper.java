package com.shanpadayhag.event_service.mappers.events;

import org.springframework.stereotype.Component;

import com.shanpadayhag.event_service.dtos.events.EventListItemDTO;
import com.shanpadayhag.event_service.models.Event;

@Component
public class EventListItemMapper {
    public EventListItemDTO toEventListItemDTO(Event event) {
        return new EventListItemDTO(
                event.getId(),
                event.getTitle(),
                event.getStart(),
                event.getEnd(),
                event.getColor().orElse(null));
    }
}
