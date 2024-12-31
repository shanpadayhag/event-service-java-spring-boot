package com.shanpadayhag.event_service.controllers.api.v1.events;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shanpadayhag.event_service.actions.events.UpdateEventAction;
import com.shanpadayhag.event_service.dtos.events.NewEventDTO;
import com.shanpadayhag.event_service.exceptions.core.NotFoundException;
import com.shanpadayhag.event_service.models.Event;
import com.shanpadayhag.event_service.repositories.EventRepository;
import com.shanpadayhag.event_service.requests.events.UpdateEventRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/events")
public class UpdateEventController {

    private final EventRepository eventRepository;
    private final UpdateEventAction updateEventAction;

    public UpdateEventController(EventRepository eventRepository, UpdateEventAction updateEventAction) {
        this.eventRepository = eventRepository;
        this.updateEventAction = updateEventAction;
    }

    @PutMapping("/{eventID}")
    public ResponseEntity<NewEventDTO> invokable(
            @PathVariable Long eventID,
            @Valid @RequestBody UpdateEventRequest request) {

        Event event = eventRepository.findById(eventID)
                .orElseThrow(() -> new NotFoundException("We're having trouble finding the event with ID: " + eventID
                        + ". Can you help us out by checking the ID or trying again? We're rooting for you to find what you need!"));

        NewEventDTO updatedEvent = updateEventAction.execute(
                event,
                request.title(),
                request.start(),
                request.end(),
                request.color().orElse(null));

        return ResponseEntity.ok(updatedEvent);
    }
}
