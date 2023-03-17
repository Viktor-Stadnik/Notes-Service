package com.notesservice.dto.request;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class NoteRequestDto {
    private String row;
    private long likeCount;
    private LocalDateTime dateTime;
}
