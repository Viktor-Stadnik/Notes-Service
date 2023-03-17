package com.notesservice.controller;

import com.notesservice.model.Note;
import com.notesservice.model.Role;
import com.notesservice.service.AuthenticationService;
import com.notesservice.service.NoteService;
import com.notesservice.service.RoleService;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inject")
public class InjectController {
    private final NoteService noteService;
    private final RoleService roleService;
    private final AuthenticationService authenticationService;

    public InjectController(NoteService noteService,
                            RoleService roleService,
                            AuthenticationService authenticationService) {
        this.noteService = noteService;

        this.roleService = roleService;
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public String saveNote() {
        roleService.add(new Role(Role.RoleName.USER));
        authenticationService.registration("john", "123");

        Note note = new Note();
        note.setRow("Some information");
        note.setDateTime(LocalDateTime.now());
        noteService.add(note);

        Note note2 = new Note();
        note.setRow("Some information2");
        note.setDateTime(LocalDateTime.now());
        noteService.add(note2);

        Note note3 = new Note();
        note.setRow("Some information3");
        note.setDateTime(LocalDateTime.now());
        noteService.add(note3);

        return "Done!";
    }
}
