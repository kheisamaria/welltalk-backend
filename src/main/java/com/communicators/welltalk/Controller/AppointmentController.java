package com.communicators.welltalk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.communicators.welltalk.Service.AppointmentService;
import com.communicators.welltalk.Entity.AppointmentEntity;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("student-counselor/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/checkAppointmentIsTaken/{date}/{startTime}")
    public ResponseEntity<Boolean> checkAppointmentIsTaken(
            @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @PathVariable("startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime) {
        boolean isTaken = appointmentService.checkAppointmentIsTaken(date, startTime);
        return new ResponseEntity<>(isTaken, HttpStatus.OK);
    }

    @PostMapping("/createAppointment")
    public ResponseEntity<AppointmentEntity> createAppointment(@RequestBody AppointmentEntity appointment) {
        AppointmentEntity newAppointment = appointmentService.saveAppointment(appointment);
        return new ResponseEntity<>(newAppointment, HttpStatus.CREATED);
    }

    @GetMapping("/getAllAppointments")
    public ResponseEntity<?> getAllAppointments() {
        return new ResponseEntity<>(appointmentService.getAllAppointments(), HttpStatus.OK);
    }

    @GetMapping("/getAppointmentById/{id}")
    public ResponseEntity<AppointmentEntity> getAppointmentById(@PathVariable int id) {
        return new ResponseEntity<>(appointmentService.getAppointmentByAppointmentId(id), HttpStatus.OK);
    }

    @PutMapping("/updateAppointment/{id}")
    public ResponseEntity<AppointmentEntity> updateAppointment(@PathVariable int id,
            @RequestBody AppointmentEntity appointment) {
        AppointmentEntity updatedAppointment = appointmentService.updateAppointment(id, appointment);
        if (updatedAppointment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAppointment/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable int id) {
        boolean deleted = appointmentService.deleteAppointment(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
