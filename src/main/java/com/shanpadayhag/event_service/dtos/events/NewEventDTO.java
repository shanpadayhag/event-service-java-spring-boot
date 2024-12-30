package com.shanpadayhag.event_service.dtos.events;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NewEventDTO {
    private Long id;

    private String title;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime start;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime end;

    private String color;

    public NewEventDTO(
            Long id,
            String title,
            LocalDateTime start,
            LocalDateTime end,
            String color) {
        this.id = id;
        this.title = title;
        this.start = start;
        this.end = end;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
