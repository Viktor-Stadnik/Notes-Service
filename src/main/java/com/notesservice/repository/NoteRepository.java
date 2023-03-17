package com.notesservice.repository;

import com.notesservice.model.Note;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends MongoRepository<Note,String> {
    List<Note> getAllByOrderByDateTimeDesc();
}
