package com.assignment.notes.notesapp.model;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name="DAILY_NOTES")
public class SimpleNoteEntity {

    @Id
    @GeneratedValue
    private Long noteId;

    @Column(name = "title")
    private String title;

    @Column(name = "sub_title")
    private String subTitle;

    @Column(name = "inserted_date")
    private LocalDate insertedDate;

    @Column(name = "description")
    private String description;

    public SimpleNoteEntity(){

    }

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public LocalDate getInsertedDate() {
        return insertedDate;
    }

    public void setInsertedDate(LocalDate insertedDate) {
        this.insertedDate = insertedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return "SimpleNoteEntity [id: " + noteId + " title: " + title + " subTitle: " + subTitle + " insertedDate: " + insertedDate
                + " description: " + description + "]";
    }
}
