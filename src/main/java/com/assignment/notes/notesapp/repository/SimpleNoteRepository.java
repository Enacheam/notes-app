package com.assignment.notes.notesapp.repository;

import com.assignment.notes.notesapp.model.SimpleNoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleNoteRepository extends JpaRepository<SimpleNoteEntity, Long> {
}
