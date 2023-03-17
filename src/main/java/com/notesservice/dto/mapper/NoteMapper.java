package com.notesservice.dto.mapper;

import com.notesservice.dto.request.NoteRequestDto;
import com.notesservice.dto.response.NoteResponseDto;
import com.notesservice.model.Note;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class NoteMapper {
    public NoteResponseDto toResponseDto(Note note) {
        NoteResponseDto responseDto = new NoteResponseDto();
        responseDto.setId(note.getId());
        responseDto.setRow(note.getRow());
        responseDto.setLikeCount(note.getLikeCount());
        responseDto.setDateTime(LocalDateTime.now());
        return responseDto;
    }

    public Note toModel(NoteRequestDto requestDto) {
        Note note = new Note();
        note.setRow(requestDto.getRow());
        note.setLikeCount(requestDto.getLikeCount());
        note.setDateTime(requestDto.getDateTime());
        return note;
    }
}
