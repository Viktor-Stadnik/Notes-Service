package com.notesservice.service.impl;

import com.notesservice.exception.DataProcessingException;
import com.notesservice.model.Note;
import com.notesservice.repository.NoteRepository;
import com.notesservice.service.NoteService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {
    private static final long LIKE_INCREMENT = 1;
    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note add(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note get(String id) {
        return noteRepository.findById(id).orElseThrow(() ->
                new DataProcessingException("Can't get a note by id: " + id));
    }

    @Override
    public List<Note> getAllDesc() {
        return noteRepository.getAllByOrderByDateTimeDesc();
    }

    @Override
    public Note update(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void delete(String id) {
        noteRepository.deleteById(id);
    }

    @Override
    public Note createLike(String id) {
        Note currentNote = noteRepository.findById(id).orElseThrow(() ->
                new DataProcessingException("Can't get a note by id: " + id));

        currentNote.setLikeCount(currentNote.getLikeCount() + LIKE_INCREMENT);
        noteRepository.deleteById(id);
        return noteRepository.save(currentNote);

    }

    @Override
    public Note deleteLike(String id) {
        Note currentNote = noteRepository.findById(id).orElseThrow(() ->
                new DataProcessingException("Can't get a note by id: " + id));

        if (currentNote.getLikeCount() > 0) {
            currentNote.setLikeCount(currentNote.getLikeCount() - LIKE_INCREMENT);
            noteRepository.deleteById(id);
            return noteRepository.save(currentNote);
        }
        return currentNote;
    }
}
