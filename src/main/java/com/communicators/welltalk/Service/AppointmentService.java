package com.communicators.welltalk.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communicators.welltalk.Repository.AppointmentRepository;
import com.communicators.welltalk.Entity.AppointmentEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    public AppointmentEntity saveAppointment(AppointmentEntity appointment) {
        if (checkAppointmentIsTaken(appointment.getAppointmentDate(), appointment.getAppointmentStartTime())) {
            throw new IllegalArgumentException("Date is already taken");
        }
        return appointmentRepository.save(appointment);
    }

    public boolean checkAppointmentIsTaken(LocalDate date, LocalTime startTime) {
        return appointmentRepository.existsByAppointmentDateAndAppointmentStartTime(date, startTime);
    }

    public List<AppointmentEntity> getAllAppointments() {
        return appointmentRepository.findByIsDeletedFalse();
    }

    public AppointmentEntity getAppointmentByAppointmentId(int id) {
        return appointmentRepository.findByAppointmentIdAndIsDeletedFalse(id).get();
    }

    @SuppressWarnings("finally")
    public AppointmentEntity updateAppointment(int id, AppointmentEntity appointment) {
        AppointmentEntity appointmentToUpdate = new AppointmentEntity();
        try {
            appointmentToUpdate = appointmentRepository.findByAppointmentIdAndIsDeletedFalse(id).get();

            appointmentToUpdate.setAppointmentDate(appointment.getAppointmentDate());
            appointmentToUpdate.setAppointmentStartTime(appointment.getAppointmentStartTime());
            appointmentToUpdate.setAppointmentEndTime(appointment.getAppointmentEndTime());
            appointmentToUpdate.setAppointmentStatus(appointment.getAppointmentStatus());
            appointmentToUpdate.setStudent(appointment.getStudent());
            appointmentToUpdate.setCounselor(appointment.getCounselor());
            appointmentToUpdate.setAppointmentNotes(appointment.getAppointmentNotes());
            appointmentToUpdate.setAppointmentType(appointment.getAppointmentType());
            appointmentToUpdate.setAppointmentPurpose(appointment.getAppointmentPurpose());
        } catch (Exception e) {
            throw new IllegalArgumentException("Appointment " + id + " does not exist.");
        } finally {
            return appointmentRepository.save(appointmentToUpdate);
        }
    }

    public boolean deleteAppointment(int id) {
        AppointmentEntity appointment = appointmentRepository.findByAppointmentIdAndIsDeletedFalse(id).get();
        if (appointment != null) {
            appointment.setIsDeleted(true);
            appointmentRepository.save(appointment);
            return true;
        } else {
            System.out.println("Appointment " + id + " does not exist.");
            return false;
        }
    }
}
