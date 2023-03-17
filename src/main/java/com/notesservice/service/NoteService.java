package com.notesservice.service;

import com.notesservice.model.Note;
import java.util.List;

public interface NoteService {
    Note add(Note note);

    Note get(String id);

    List<Note> getAllDesc();

    Note update(Note note);

    void delete(String id);

    Note createLike(String id);

    Note deleteLike(String id);
}
