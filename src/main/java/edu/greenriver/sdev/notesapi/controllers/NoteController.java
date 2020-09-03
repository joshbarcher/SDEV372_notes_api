package edu.greenriver.sdev.notesapi.controllers;

import edu.greenriver.sdev.notesapi.entities.Note;
import edu.greenriver.sdev.notesapi.services.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("notes")
public class NoteController {
    private NoteService service;

    public NoteController(NoteService service) {
        this.service = service;
    }

    //GET
    @GetMapping("")
    public List<Note> notes() {
        return service.getNotes();
    }

    @GetMapping("{id}")
    public Note noteById(@PathVariable int id) {
        return service.getNote(id);
    }

    //POST
    @PostMapping("")
    public Note addNote(@RequestBody Note note) {
        return service.addNote(note);
    }

    //PUT
    @PutMapping("{id}")
    public Note editNote(@PathVariable int id,
                        @RequestBody Note note) {
        return service.editNote(id, note);
    }

    //DELETE
    @DeleteMapping("{id}")
    public void deleteNote(@PathVariable int id) {
        service.deleteNote(id);
    }
}

