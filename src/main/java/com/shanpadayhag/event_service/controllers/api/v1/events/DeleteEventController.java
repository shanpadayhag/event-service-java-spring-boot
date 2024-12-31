package com.shanpadayhag.event_service.controllers.api.v1.events;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shanpadayhag.event_service.dtos.events.NewEventDTO;

@RestController
@RequestMapping("/api/v1/events")
public class DeleteEventController {

    @DeleteMapping("/{eventID}")
    public void updateEvent() {
    }
}
