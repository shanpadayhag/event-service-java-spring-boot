package com.shanpadayhag.event_service.actions.events;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shanpadayhag.event_service.dtos.events.NewEventDTO;
import com.shanpadayhag.event_service.mappers.events.NewEventMapper;
import com.shanpadayhag.event_service.models.Event;
import com.shanpadayhag.event_service.repositories.EventRepository;

@Component
public class StoreEventAction {
    @Autowired
    EventRepository eventRepository;

    @Autowired
    NewEventMapper newEventMapper;

    public NewEventDTO execute(
            String title,
            LocalDateTime start,
            LocalDateTime end,
            Optional<String> color) {

        Event event = new Event(title, start, end, color.orElse(null));
        Event savedEvent = eventRepository.save(event);

        return newEventMapper.toNewEventDTO(savedEvent);
    }
}
