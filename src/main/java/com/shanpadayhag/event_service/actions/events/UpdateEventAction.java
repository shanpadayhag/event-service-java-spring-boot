package com.shanpadayhag.event_service.actions.events;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shanpadayhag.event_service.dtos.events.NewEventDTO;
import com.shanpadayhag.event_service.mappers.events.NewEventMapper;
import com.shanpadayhag.event_service.models.Event;
import com.shanpadayhag.event_service.repositories.EventRepository;

@Component
public class UpdateEventAction {
    @Autowired
    EventRepository eventRepository;

    @Autowired
    NewEventMapper newEventMapper;

    public NewEventDTO execute(
            Event event,
            String newTitle,
            LocalDateTime newStart,
            LocalDateTime newEnd,
            String newColor) {
        event.setTitle(newTitle);
        event.setStart(newStart);
        event.setEnd(newEnd);
        event.setColor(newColor);
        Event updatedEvent = eventRepository.save(event);

        return newEventMapper.toNewEventDTO(updatedEvent);
    }
}
