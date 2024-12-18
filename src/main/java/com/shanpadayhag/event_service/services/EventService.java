package com.shanpadayhag.event_service.services;

import com.shanpadayhag.event_service.dtos.events.EventListItemDTO;
import com.shanpadayhag.event_service.mappers.EventMapper;
import com.shanpadayhag.event_service.models.Event;
import com.shanpadayhag.event_service.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventMapper eventMapper;

    public List<EventListItemDTO> getEventsByYearAndMonth(Integer year, Integer month) {
        YearMonth yearMonth;
        LocalDate currentDate = LocalDate.now();

        if (year == null && month == null)
            yearMonth = YearMonth.now();
        else if (year == null)
            yearMonth = YearMonth.of(currentDate.getYear(), month);
        else if (month == null)
            yearMonth = YearMonth.of(year, currentDate.getMonth());
        else
            yearMonth = YearMonth.of(year, month);

        LocalDateTime startOfMonth = yearMonth.atDay(1).atStartOfDay();
        LocalDateTime startOfNextMonth = yearMonth.plusMonths(1).atDay(1).atStartOfDay();

        List<Event> events = eventRepository.findEventsByMonthAndYear(startOfMonth, startOfNextMonth);

        return events.stream()
                .map(eventMapper::toEventListItemDTO)
                .collect(Collectors.toList());
    }
}
