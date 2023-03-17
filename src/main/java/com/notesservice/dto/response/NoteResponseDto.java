package com.notesservice.dto.response;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class NoteResponseDto {
    private String id;
    private String row;
    private long likeCount;
    private LocalDateTime dateTime;
}
