package com.assignment.notes.notesapp.responses;

import com.assignment.notes.notesapp.model.SimpleNoteEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(value = HttpStatus.OK)
public class AllNotesResponse {
    private String message;
    private List<SimpleNoteEntity> data;

    public AllNotesResponse(){

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<SimpleNoteEntity> getData() {
        return data;
    }

    public void setData(List<SimpleNoteEntity> data) {
        this.data = data;
    }
}
