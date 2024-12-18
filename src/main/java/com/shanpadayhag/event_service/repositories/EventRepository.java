package com.shanpadayhag.event_service.repositories;

import com.shanpadayhag.event_service.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("SELECT event FROM Event event WHERE " +
            "event.start >= :startOfMonth AND event.start < :startOfNextMonth")
    List<Event> findEventsByMonthAndYear(
            @Param("startOfMonth") LocalDateTime startOfMonth,
            @Param("startOfNextMonth") LocalDateTime startOfNextMonth);
}
