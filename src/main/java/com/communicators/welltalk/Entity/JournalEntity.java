package com.communicators.welltalk.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbljournal")
public class JournalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int journalId;

    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName = "id")
    private StudentEntity student;

    // title, entry, date of entry, time of entry, isDeleted, time of edit, date of
    // edit
    private String title;

    private String entry;

    private LocalDate dateOfEntry;

    private LocalTime timeOfEntry;

    private boolean isDeleted;

    private LocalDate dateOfUpdate;

    private LocalTime timeOfUpdate;

    public JournalEntity() {
    }

    public JournalEntity(StudentEntity student, String title, String entry, LocalDate dateOfEntry,
            LocalTime timeOfEntry) {
        this.student = student;
        this.title = title;
        this.entry = entry;
        this.dateOfEntry = dateOfEntry;
        this.timeOfEntry = timeOfEntry;
        isDeleted = false;
    }

    public int getJournalId() {
        return journalId;
    }

    public void setJournalId(int journalId) {
        this.journalId = journalId;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public LocalDate getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(LocalDate dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public LocalTime getTimeOfEntry() {
        return timeOfEntry;
    }

    public void setTimeOfEntry(LocalTime timeOfEntry) {
        this.timeOfEntry = timeOfEntry;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public LocalDate getDateOfUpdate() {
        return dateOfUpdate;
    }

    public void setDateOfUpdate(LocalDate dateOfUpdate) {
        this.dateOfUpdate = dateOfUpdate;
    }

    public LocalTime getTimeOfUpdate() {
        return timeOfUpdate;
    }

    public void setTimeOfUpdate(LocalTime timeOfUpdate) {
        this.timeOfUpdate = timeOfUpdate;
    }

}
