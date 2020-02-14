package com.assignment.notes.notesapp.responses;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK)
public class NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse {

    private String message;

    public NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
