package com.assignment.notes.notesapp.responses;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoteNotFoundExceptionResponse extends Exception{

    private static final long serialVersionUID = 1L;

    public NoteNotFoundExceptionResponse(String message) {
        super(message);
    }

    public NoteNotFoundExceptionResponse(String message, Throwable t) {
        super(message, t);
    }
}
