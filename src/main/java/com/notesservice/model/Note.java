package com.notesservice.model;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "notes")
public class Note {
    @Id
    private String id;
    private String row;
    private long likeCount;
    private LocalDateTime dateTime;
}
