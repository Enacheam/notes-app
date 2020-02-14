package com.assignment.notes.notesapp.responses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NoteNotFoundExceptionResponseTests {

    private NoteNotFoundExceptionResponse noteNotFoundExceptionResponse;

    @BeforeEach
    void init(){
        noteNotFoundExceptionResponse
                = new NoteNotFoundExceptionResponse("Failed to retrieve note");
    }

    @Test
    void test_note_note_found_exception(){
        assertThat(noteNotFoundExceptionResponse.getMessage()).isEqualTo("Failed to retrieve note");
    }
}
