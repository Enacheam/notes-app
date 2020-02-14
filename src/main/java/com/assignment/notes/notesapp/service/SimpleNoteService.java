package com.assignment.notes.notesapp.service;

import com.assignment.notes.notesapp.responses.AllNotesResponse;
import com.assignment.notes.notesapp.responses.NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse;
import com.assignment.notes.notesapp.responses.NoteNotFoundExceptionResponse;
import com.assignment.notes.notesapp.model.SimpleNoteEntity;
import com.assignment.notes.notesapp.repository.SimpleNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SimpleNoteService {

    @Autowired
    private SimpleNoteRepository simpleNoteRepository;

    public AllNotesResponse getAllNotes(){
        List<SimpleNoteEntity> simpleNoteEntities = simpleNoteRepository.findAll();
        AllNotesResponse notes = new AllNotesResponse();
        notes.setMessage("Success");

        if(simpleNoteEntities.size() == 0){
            notes.setMessage("No notes available");
        }

        notes.setData(simpleNoteEntities);
        return notes;
    }


    public SimpleNoteEntity getNoteById(Long id) throws NoteNotFoundExceptionResponse {
        Optional<SimpleNoteEntity> simpleNoteEntity = simpleNoteRepository.findById(id);

        if(simpleNoteEntity.isPresent()){
            return simpleNoteEntity.get();
        }

        throw new NoteNotFoundExceptionResponse("No note with id: " + id + " was found. " +
                "Please check the id and try again");
    }


    public NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse createNote(SimpleNoteEntity simpleNoteEntity){
        simpleNoteRepository.save(simpleNoteEntity);
        return new NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse("Successfully created note");
    }


    public NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse updateNote(SimpleNoteEntity simpleNoteEntity) throws NoteNotFoundExceptionResponse {
        Optional<SimpleNoteEntity> noteEntity = simpleNoteRepository.findById(simpleNoteEntity.getNoteId());
        if(noteEntity.isPresent()){
            SimpleNoteEntity nSimpleNoteEntity = new SimpleNoteEntity();
            nSimpleNoteEntity.setNoteId(simpleNoteEntity.getNoteId());
            nSimpleNoteEntity.setTitle(simpleNoteEntity.getTitle());
            nSimpleNoteEntity.setSubTitle(simpleNoteEntity.getSubTitle());
            nSimpleNoteEntity.setInsertedDate(simpleNoteEntity.getInsertedDate());
            nSimpleNoteEntity.setDescription(simpleNoteEntity.getDescription());

            simpleNoteRepository.save(nSimpleNoteEntity);
            return new NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse("Updated note successfully");
        }

        throw new NoteNotFoundExceptionResponse("Failed to update note. Reason: No note found with id " + simpleNoteEntity.getNoteId());
    }


    public NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse deleteNoteById(Long id) throws NoteNotFoundExceptionResponse {
        simpleNoteRepository.deleteById(id);
        return new NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse("Successfully deleted note with id " + id);
    }
}
