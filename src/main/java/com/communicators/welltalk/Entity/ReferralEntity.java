package com.communicators.welltalk.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblreferral")
public class ReferralEntity {
    // referralId, referredBy, referFirstName, referLastName, referStudentId,
    // reason, additionalNotes, status, isDeleted
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int referralId;

    @ManyToOne
    @JoinColumn(name = "referredById", referencedColumnName = "id")
    private TeacherEntity teacher;

    private String referFirstName;

    private String referLastName;

    private String referStudentId;

    private String reason;

    private String additionalNotes;

    private String status;

    private boolean isDeleted;

    public ReferralEntity() {
    }

    public ReferralEntity(TeacherEntity teacher, String referFirstName, String referLastName, String referStudentId,
            String reason, String additionalNotes, String status) {
        this.teacher = teacher;
        this.referFirstName = referFirstName;
        this.referLastName = referLastName;
        this.referStudentId = referStudentId;
        this.reason = reason;
        this.additionalNotes = additionalNotes;
        this.status = status;
        isDeleted = false;
    }

    public int getReferralId() {
        return referralId;
    }

    public void setReferralId(int referralId) {
        this.referralId = referralId;
    }

    public TeacherEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherEntity teacher) {
        this.teacher = teacher;
    }

    public String getReferFirstName() {
        return referFirstName;
    }

    public void setReferFirstName(String referFirstName) {
        this.referFirstName = referFirstName;
    }

    public String getReferLastName() {
        return referLastName;
    }

    public void setReferLastName(String referLastName) {
        this.referLastName = referLastName;
    }

    public String getReferStudentId() {
        return referStudentId;
    }

    public void setReferStudentId(String referStudentId) {
        this.referStudentId = referStudentId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}
