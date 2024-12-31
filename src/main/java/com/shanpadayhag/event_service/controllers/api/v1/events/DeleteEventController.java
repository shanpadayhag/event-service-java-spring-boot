package com.shanpadayhag.event_service.controllers.api.v1.events;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shanpadayhag.event_service.dtos.events.EventListItemDTO;
import com.shanpadayhag.event_service.exceptions.core.NotFoundException;
import com.shanpadayhag.event_service.mappers.events.EventListItemMapper;
import com.shanpadayhag.event_service.models.Event;
import com.shanpadayhag.event_service.repositories.EventRepository;

@RestController
@RequestMapping("/api/v1/events")
public class DeleteEventController {

    private final EventRepository eventRepository;
    private final EventListItemMapper eventListItemMapper;

    public DeleteEventController(EventRepository eventRepository, EventListItemMapper eventListItemMapper) {
        this.eventRepository = eventRepository;
        this.eventListItemMapper = eventListItemMapper;
    }

    @DeleteMapping("/{eventID}")
    public ResponseEntity<EventListItemDTO> invokable(@PathVariable Long eventID) {
        Event event = eventRepository.findById(eventID)
                .orElseThrow(() -> new NotFoundException("We're having trouble finding the event with ID: " + eventID
                        + ". Can you help us out by checking the ID or trying again? We're rooting for you to find what you need!"));

        eventRepository.delete(event);
        return ResponseEntity.ok(eventListItemMapper.toEventListItemDTO(event));
    }
}
