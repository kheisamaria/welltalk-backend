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
@Table(name = "tblappointment")
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;

    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName = "id")
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "counselorId", referencedColumnName = "id")
    private CounselorEntity counselor;

    private LocalDate appointmentDate;

    private LocalTime appointmentStartTime;

    private LocalTime appointmentEndTime;

    private String appointmentStatus;

    private String appointmentNotes;

    private String appointmentType;

    private String appointmentAdditionalNotes;

    private String appointmentPurpose;

    private boolean isDeleted;

    public AppointmentEntity() {

    }

    public AppointmentEntity(StudentEntity student, CounselorEntity counselor, LocalDate appointmentDate,
            LocalTime appointmentStartTime, LocalTime appointmentEndTime, String appointmentStatus,
            String appointmentNotes,
            String appointmentType, String appointmentPurpose) {
        this.student = student;
        this.counselor = counselor;
        this.appointmentDate = appointmentDate;
        this.appointmentStartTime = appointmentStartTime;
        this.appointmentEndTime = appointmentEndTime;
        this.appointmentStatus = appointmentStatus;
        this.appointmentNotes = appointmentNotes;
        this.appointmentType = appointmentType;
        this.appointmentPurpose = appointmentPurpose;
        isDeleted = false;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public CounselorEntity getCounselor() {
        return counselor;
    }

    public void setCounselor(CounselorEntity counselor) {
        this.counselor = counselor;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentStartTime() {
        return appointmentStartTime;
    }

    public void setAppointmentStartTime(LocalTime appointmentStartTime) {
        this.appointmentStartTime = appointmentStartTime;
    }

    public LocalTime getAppointmentEndTime() {
        return appointmentEndTime;
    }

    public void setAppointmentEndTime(LocalTime appointmentEndTime) {
        this.appointmentEndTime = appointmentEndTime;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public String getAppointmentNotes() {
        return appointmentNotes;
    }

    public void setAppointmentNotes(String appointmentNotes) {
        this.appointmentNotes = appointmentNotes;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public String getAppointmentAdditionalNotes() {
        return appointmentAdditionalNotes;
    }

    public void setAppointmentAdditionalNotes(String appointmentAdditionalNotes) {
        this.appointmentAdditionalNotes = appointmentAdditionalNotes;
    }

    public String getAppointmentPurpose() {
        return appointmentPurpose;
    }

    public void setAppointmentPurpose(String appointmentPurpose) {
        this.appointmentPurpose = appointmentPurpose;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
