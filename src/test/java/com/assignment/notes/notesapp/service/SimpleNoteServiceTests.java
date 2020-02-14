package com.assignment.notes.notesapp.service;

import com.assignment.notes.notesapp.model.SimpleNoteEntity;
import com.assignment.notes.notesapp.repository.SimpleNoteRepository;
import com.assignment.notes.notesapp.responses.AllNotesResponse;
import com.assignment.notes.notesapp.responses.NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse;
import com.assignment.notes.notesapp.responses.NoteNotFoundExceptionResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SimpleNoteServiceTests {

    @InjectMocks
    private SimpleNoteService simpleNoteService;

    @Mock
    private SimpleNoteRepository simpleNoteRepository;

    @Test
    void test_get_all_notes_returns_all_notes(){
        SimpleNoteEntity entity1 = new SimpleNoteEntity();
        SimpleNoteEntity entity2 = new SimpleNoteEntity();
        SimpleNoteEntity entity3 = new SimpleNoteEntity();

        List<SimpleNoteEntity> entities = new ArrayList<>();
        entities.add(entity1);
        entities.add(entity2);
        entities.add(entity3);

        when(simpleNoteRepository.findAll()).thenReturn(entities);

        AllNotesResponse res = simpleNoteService.getAllNotes();

        assertThat(res.getMessage()).isEqualTo("Success");
        assertThat(res.getData().size()).isEqualTo(3);
    }


    @Test
    void test_get_all_notes_returns_no_notes(){
        List<SimpleNoteEntity> entities = new ArrayList<>();
        when(simpleNoteRepository.findAll()).thenReturn(entities);
        AllNotesResponse res = simpleNoteService.getAllNotes();

        assertThat(res.getMessage()).isEqualTo("No notes available");
        assertThat(res.getData().size()).isEqualTo(0);
    }

    @Test
    void test_get_note_by_id_returns_single_note() throws NoteNotFoundExceptionResponse {
        SimpleNoteEntity entity1 = new SimpleNoteEntity();
        entity1.setTitle("Entity One");
        Optional<SimpleNoteEntity> optEntity = Optional.of(entity1);
        when(simpleNoteRepository.findById(anyLong())).thenReturn(optEntity);
        SimpleNoteEntity res = simpleNoteService.getNoteById(7L);

        assertThat(res.getTitle()).isEqualTo("Entity One");
    }


    @Test
    void test_note_was_created() {
        SimpleNoteEntity simpleNoteEntity = new SimpleNoteEntity();
        when(simpleNoteRepository.save(any(SimpleNoteEntity.class)))
                .thenReturn(null);

        NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse res
                = simpleNoteService.createNote(simpleNoteEntity);

        assertThat(res.getMessage()).isEqualTo("Successfully created note");
    }

    @Test
    void test_note_was_updated() throws NoteNotFoundExceptionResponse {
        SimpleNoteEntity entityTwo = new SimpleNoteEntity();
        entityTwo.setNoteId(5L);
        entityTwo.setTitle("Entity Two");
        Optional<SimpleNoteEntity> optEntity = Optional.of(entityTwo);

        when(simpleNoteRepository.findById(anyLong())).thenReturn(optEntity);
        when(simpleNoteRepository.save(any(SimpleNoteEntity.class)))
                .thenReturn(null);

        NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse res
                = simpleNoteService.updateNote(entityTwo);

        assertThat(res.getMessage()).isEqualTo("Updated note successfully");
    }

    @Test
    void test_note_by_id() throws NoteNotFoundExceptionResponse {
        SimpleNoteEntity entityTwo = new SimpleNoteEntity();
        entityTwo.setNoteId(5L);

        doNothing().when(simpleNoteRepository).deleteById(anyLong());

        NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse res
                = simpleNoteService.deleteNoteById(entityTwo.getNoteId());

        assertThat(res.getMessage())
                .isEqualTo("Successfully deleted note with id " + entityTwo.getNoteId());
    }

}
