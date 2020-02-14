package com.assignment.notes.notesapp.responses;

import com.assignment.notes.notesapp.model.SimpleNoteEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AllNotesResponseTests {

    private AllNotesResponse allNotesResponse;

    @BeforeEach
    void init(){
        allNotesResponse = new AllNotesResponse();
        allNotesResponse.setMessage("Successfully created notes");

        SimpleNoteEntity entity1 = new SimpleNoteEntity();
        SimpleNoteEntity entity2 = new SimpleNoteEntity();
        SimpleNoteEntity entity3 = new SimpleNoteEntity();

        List<SimpleNoteEntity> entities = new ArrayList<>();
        entities.add(entity1);
        entities.add(entity2);
        entities.add(entity3);

        allNotesResponse.setData(entities);
    }

    @Test
    void test_set_message(){
        String msg = "message for all notes response";
        allNotesResponse.setMessage(msg);
        assertThat(allNotesResponse.getMessage()).isEqualTo(msg);
    }

    @Test
    void test_get_message(){
        assertThat(allNotesResponse.getMessage()).isEqualTo("Successfully created notes");
    }

    @Test
    void test_get_data(){
        assertThat(allNotesResponse.getData().size()).isEqualTo(3);
    }


}
