package com.shanpadayhag.event_service.controllers.api.v1.events;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shanpadayhag.event_service.dtos.events.EventListItemDTO;
import com.shanpadayhag.event_service.services.EventService;

@RestController
@RequestMapping(path = "/api/v1/events")
public class EventsController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public ResponseEntity<List<EventListItemDTO>> index(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month) {
        List<EventListItemDTO> events = eventService.getEventsByYearAndMonth(year, month);
        return ResponseEntity.ok(events);
    }
}
