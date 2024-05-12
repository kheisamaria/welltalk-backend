package com.communicators.welltalk.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tblstudent")
// @PrimaryKeyJoinColumn(name = "id")
public class StudentEntity extends UserEntity {

    @Column(name = "college")
    private String college;

    @Column(name = "program")
    private String program;

    @Column(name = "year")
    private int year;

    @Column(name = "birthDate")
    private LocalDate birthDate;

    @Column(name = "contactNumber")
    private String contactNumber;

    @Column(name = "address")
    private String address;

    public StudentEntity() {

    }

    public StudentEntity(String institutionalEmail, String idNumber, String firstName, String lastName, String gender,
            String password, String image, String role, String college, String program, int year, LocalDate birthDate,
            String contactNumber, String address) {
        super(institutionalEmail, idNumber, firstName, lastName, gender, password, image, role);
        this.college = college;
        this.program = program;
        this.year = year;
        this.birthDate = birthDate;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    public StudentEntity(int teacherId, String institutionalEmail, String idNumber, String firstName, String lastName,
            String gender, String password, String role, String college, String program, int year, LocalDate birthDate,
            String contactNumber, String address) {
        super(institutionalEmail, idNumber, firstName, lastName, gender, password, role);
        this.college = college;
        this.program = program;
        this.year = year;
        this.birthDate = birthDate;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
