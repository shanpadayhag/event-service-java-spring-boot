package com.shanpadayhag.event_service.controllers.api.v1.events;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shanpadayhag.event_service.actions.events.StoreEventAction;
import com.shanpadayhag.event_service.dtos.events.NewEventDTO;
import com.shanpadayhag.event_service.requests.events.StoreEventRequest;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/api/v1/events")
public class StoreEventController {
    @Autowired
    private StoreEventAction storeEventAction;

    @PostMapping
    public ResponseEntity<NewEventDTO> invokable(@Valid @RequestBody StoreEventRequest request) {
        NewEventDTO newEvent = storeEventAction.execute(
                request.title(),
                request.start(),
                request.end(),
                request.color());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(newEvent);
    }
}
