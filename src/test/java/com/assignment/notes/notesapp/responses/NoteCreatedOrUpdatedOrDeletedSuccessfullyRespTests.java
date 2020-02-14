package com.assignment.notes.notesapp.responses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NoteCreatedOrUpdatedOrDeletedSuccessfullyRespTests {

    private NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse noteCreatedOrUpdatedOrDeletedSuccessfullyResponse;

    @BeforeEach
    void init(){
        noteCreatedOrUpdatedOrDeletedSuccessfullyResponse
                = new NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse("Successfully created notes");
    }

    @Test
    void test_get_message(){
        assertThat(noteCreatedOrUpdatedOrDeletedSuccessfullyResponse.getMessage())
                .isEqualTo("Successfully created notes");
    }
}
