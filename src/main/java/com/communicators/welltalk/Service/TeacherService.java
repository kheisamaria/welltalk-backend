package com.communicators.welltalk.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communicators.welltalk.Entity.TeacherEntity;
import com.communicators.welltalk.Repository.TeacherRepository;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public TeacherEntity saveTeacher(TeacherEntity teacher) {
        return teacherRepository.save(teacher);
    }

    public List<TeacherEntity> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public TeacherEntity getTeacherById(int id) {
        return teacherRepository.findById(id).get();
    }

    public TeacherEntity updateTeacher(TeacherEntity teacher) {
        return teacherRepository.save(teacher);
    }

    public String deleteTeacher(int id) {
        String message = "";

        if (teacherRepository.findById(id) != null) {
            teacherRepository.deleteById(id);
            message = "Teacher " + id + " is successfully deleted!";
        } else
            message = "Teacher " + id + " does not exist.";
        return message;
    }

}
