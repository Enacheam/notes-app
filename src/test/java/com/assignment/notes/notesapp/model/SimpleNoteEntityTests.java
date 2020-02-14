package com.assignment.notes.notesapp.model;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleNoteEntityTests {

    private static SimpleNoteEntity simpleNoteEntity;

    @BeforeAll
    static void initEntityObject(){
        simpleNoteEntity = new SimpleNoteEntity();
        simpleNoteEntity.setNoteId(1L);
        simpleNoteEntity.setTitle("Test Note");
        simpleNoteEntity.setSubTitle("Special test note");
        simpleNoteEntity.setDescription("All notes are for personal purposes only");
        simpleNoteEntity.setInsertedDate(LocalDate.of(2020, 2, 12));
    }

    @Test
    void test_note_id_is_1(){
        assertThat(simpleNoteEntity.getNoteId()).isEqualTo(1L);
    }

    @Test
    void test_note_title(){
        assertThat(simpleNoteEntity.getTitle()).isEqualTo("Test Note");
    }

    @Test
    void test_note_sub_title(){
        assertThat(simpleNoteEntity.getSubTitle()).isEqualTo("Special test note");
    }

    @Test
    void test_note_description(){
        assertThat(simpleNoteEntity.getDescription()).isEqualTo("All notes are for personal purposes only");
    }

    @Test
    void test_note_inserted_date(){
        assertThat(simpleNoteEntity.getInsertedDate())
                .isEqualTo(LocalDate.of(2020, 2, 12));
    }
}
