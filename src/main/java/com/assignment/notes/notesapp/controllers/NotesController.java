package com.assignment.notes.notesapp.controllers;

import com.assignment.notes.notesapp.model.SimpleNoteEntity;
import com.assignment.notes.notesapp.responses.AllNotesResponse;
import com.assignment.notes.notesapp.responses.NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse;
import com.assignment.notes.notesapp.responses.NoteNotFoundExceptionResponse;
import com.assignment.notes.notesapp.service.SimpleNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/smart-note-app/notes")
public class NotesController {

    @Autowired
    private SimpleNoteService simpleNoteService;

    @PostMapping("/add-note")
    public NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse addNote(@RequestBody SimpleNoteEntity simpleNoteEntity){
        return simpleNoteService.createNote(simpleNoteEntity);
    }

    @GetMapping("/all-notes")
    public AllNotesResponse retrieveAllNotes(){
        return simpleNoteService.getAllNotes();
    }

    @GetMapping("/retrieve/note-id/{id}")
    public SimpleNoteEntity retrieveNoteById(@PathVariable Long id) throws NoteNotFoundExceptionResponse {
        return simpleNoteService.getNoteById(id);
    }

    @PutMapping("/updates/note")
    public NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse updateNote(@RequestBody SimpleNoteEntity simpleNoteEntity) throws NoteNotFoundExceptionResponse {
        return simpleNoteService.updateNote(simpleNoteEntity);
    }

    @DeleteMapping("/delete/note-id/{id}")
    public NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse deleteNoteById(@PathVariable Long id) throws NoteNotFoundExceptionResponse {
        return simpleNoteService.deleteNoteById(id);
    }
}
