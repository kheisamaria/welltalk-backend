package com.communicators.welltalk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.communicators.welltalk.Entity.TeacherEntity;
import com.communicators.welltalk.Service.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping("/createTeacher")
    public TeacherEntity insertTeacher(@RequestBody TeacherEntity teacher) {
        return teacherService.saveTeacher(teacher);
    }

    @GetMapping("/getAllTeachers")
    public List<TeacherEntity> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/getTeacherById/{id}")
    public TeacherEntity getTeacherById(@PathVariable int id) {
        return teacherService.getTeacherById(id);
    }

    @PostMapping("/updateTeacher")
    public TeacherEntity updateTeacher(@RequestBody TeacherEntity teacher) {
        return teacherService.updateTeacher(teacher);
    }

    @GetMapping("/deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable int id) {
        return teacherService.deleteTeacher(id);
    }
}
