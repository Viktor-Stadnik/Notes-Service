package com.notesservice.controller;

import com.notesservice.dto.mapper.NoteMapper;
import com.notesservice.dto.request.NoteRequestDto;
import com.notesservice.dto.response.NoteResponseDto;
import com.notesservice.model.Note;
import com.notesservice.service.NoteService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;
    private final NoteMapper mapper;

    public NoteController(NoteService noteService, NoteMapper mapper) {
        this.noteService = noteService;
        this.mapper = mapper;
    }

    @PostMapping
    public NoteResponseDto createNote(@RequestBody NoteRequestDto requestDto) {
        Note note = noteService.add(mapper.toModel(requestDto));
        return mapper.toResponseDto(note);
    }

    @GetMapping("/{id}")
    public NoteResponseDto get(@PathVariable String id) {
        return mapper.toResponseDto(noteService.get(id));
    }

    @GetMapping()
    public List<NoteResponseDto> getAllDesc() {
        return noteService.getAllDesc().stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public NoteResponseDto update(@PathVariable String id,
                                  @RequestBody NoteRequestDto requestDto) {
        Note note = mapper.toModel(requestDto);
        note.setId(id);
        return mapper.toResponseDto(noteService.update(note));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        noteService.delete(id);
    }

    @GetMapping("/like/{id}")
    public NoteResponseDto createLike(@PathVariable String id) {
        return mapper.toResponseDto(noteService.createLike(id));
    }

    @GetMapping("/unlike/{id}")
    public NoteResponseDto deleteLike(@PathVariable String id) {
        return mapper.toResponseDto(noteService.deleteLike(id));
    }
}
