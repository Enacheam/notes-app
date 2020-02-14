package com.assignment.notes.notesapp.controllers;

import com.assignment.notes.notesapp.model.SimpleNoteEntity;
import com.assignment.notes.notesapp.responses.AllNotesResponse;
import com.assignment.notes.notesapp.responses.NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse;
import com.assignment.notes.notesapp.responses.NoteNotFoundExceptionResponse;
import com.assignment.notes.notesapp.service.SimpleNoteService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class NotesControllerTests {

    @InjectMocks
    private NotesController notesController;

    @Mock
    private SimpleNoteService simpleNoteService;

    @Test
    public void test_add_note_api(){
        String message = "Successfully created note";
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse response
                = new NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse(message);

        when(simpleNoteService.createNote(any(SimpleNoteEntity.class)))
                .thenReturn(response);

        SimpleNoteEntity simpleNoteEntity = new SimpleNoteEntity();
        simpleNoteEntity.setNoteId(1L);
        simpleNoteEntity.setTitle("Test Note");
        simpleNoteEntity.setSubTitle("Special test note");
        simpleNoteEntity.setDescription("All notes are for personal purposes only");
        simpleNoteEntity.setInsertedDate(LocalDate.of(2020, 2, 12));

        NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse callResponse
                = notesController.addNote(simpleNoteEntity);

        assertThat(callResponse.getMessage()).isEqualTo(message);
    }


    @Test
    public void test_retrieve_all_notes_api(){
        String message = "successfully retrieved all notes";
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        AllNotesResponse allNotesResponse = new AllNotesResponse();
        allNotesResponse.setMessage(message);
        SimpleNoteEntity entity1 = new SimpleNoteEntity();
        SimpleNoteEntity entity2 = new SimpleNoteEntity();
        SimpleNoteEntity entity3 = new SimpleNoteEntity();

        List<SimpleNoteEntity> entities = new ArrayList<>();
        entities.add(entity1);
        entities.add(entity2);
        entities.add(entity3);

        allNotesResponse.setData(entities);

        when(simpleNoteService.getAllNotes()).thenReturn(allNotesResponse);

        AllNotesResponse response = notesController.retrieveAllNotes();

        assertThat(response.getData().size()).isEqualTo(3);
        assertThat(response.getMessage()).isEqualTo(message);
    }

    @Test
    public void test_retrieve_note_by_id_api() throws NoteNotFoundExceptionResponse {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        SimpleNoteEntity simpleNoteEntity = new SimpleNoteEntity();
        simpleNoteEntity.setNoteId(3L);

        when(simpleNoteService.getNoteById(3L)).thenReturn(simpleNoteEntity);

        SimpleNoteEntity response = notesController.retrieveNoteById(3L);

        assertThat(response.getNoteId()).isEqualTo(3L);

    }

    @Test
    public void test_update_note_api() throws NoteNotFoundExceptionResponse{
        String message = "Successfully updated note";
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse response
                = new NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse(message);

        when(simpleNoteService.updateNote(any(SimpleNoteEntity.class))).thenReturn(response);
        SimpleNoteEntity simpleNoteEntity = new SimpleNoteEntity();
        NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse res
                = notesController.updateNote(simpleNoteEntity);

        assertThat(res.getMessage()).isEqualTo(message);
    }


    @Test
    public void test_delete_note_by_id_api() throws NoteNotFoundExceptionResponse{
        String message = "Successfully deleted note";
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse response
                = new NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse(message);

        when(simpleNoteService.deleteNoteById(3L)).thenReturn(response);

        NoteCreatedOrUpdatedOrDeletedSuccessfullyResponse res
                = notesController.deleteNoteById(3L);

        assertThat(res.getMessage()).isEqualTo(message);
    }

}
