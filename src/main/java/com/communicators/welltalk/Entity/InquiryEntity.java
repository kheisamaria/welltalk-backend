package com.communicators.welltalk.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "tblinquiry")
public class InquiryEntity {
    // inquiryId, sender, subjecty stastus, date, isDewleted, counselorId,
    // cpunselortReply, message, replyDate
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inquiryId;

    @ManyToOne
    @JoinColumn(name = "senderId", referencedColumnName = "id")
    private StudentEntity student;

    private String subject;

    private String messageInquiry;

    private boolean status;

    private LocalDate date;

    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "counselorId", referencedColumnName = "id")
    private CounselorEntity counselor;

    private String counselorReply;

    private String messageReply;

    private LocalDate replyDate;

    public InquiryEntity() {
    }

    public InquiryEntity(StudentEntity student, String subject, String messageInquiry, boolean status, LocalDate date,
            CounselorEntity counselor, String counselorReply, String messageReply,
            LocalDate replyDate) {
        this.student = student;
        this.subject = subject;
        this.messageInquiry = messageInquiry;
        this.status = status;
        this.date = date;
        isDeleted = false;
        this.counselor = counselor;
        this.counselorReply = counselorReply;
        this.messageReply = messageReply;
        this.replyDate = replyDate;
    }

    public InquiryEntity(StudentEntity student, String subject, String messageInquiry, boolean status,
            LocalDate date) {
        this.student = student;
        this.subject = subject;
        this.messageInquiry = messageInquiry;
        this.status = status;
        this.date = date;
        isDeleted = false;
    }

    public void ReplyInquiry(CounselorEntity counselor, String counselorReply, String messageReply,
            LocalDate replyDate) {
        this.counselor = counselor;
        this.counselorReply = counselorReply;
        this.messageReply = messageReply;
        this.replyDate = replyDate;
    }

    public int getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(int inquiry) {
        this.inquiryId = inquiry;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessageInquiry() {
        return messageInquiry;
    }

    public void setMessageInquiry(String messageInquiry) {
        this.messageInquiry = messageInquiry;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public CounselorEntity getCounselor() {
        return counselor;
    }

    public void setCounselor(CounselorEntity counselor) {
        this.counselor = counselor;
    }

    public String getCounselorReply() {
        return counselorReply;
    }

    public void setCounselorReply(String counselorReply) {
        this.counselorReply = counselorReply;
    }

    public String getMessageReply() {
        return messageReply;
    }

    public void setMessageReply(String messageReply) {
        this.messageReply = messageReply;
    }

    public LocalDate getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(LocalDate replyDate) {
        this.replyDate = replyDate;
    }

}
