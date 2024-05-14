package com.communicators.welltalk.Repository;

import com.communicators.welltalk.Entity.AppointmentEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Integer> {
    List<AppointmentEntity> findByIsDeletedFalse();

    Optional<AppointmentEntity> findByAppointmentIdAndIsDeletedFalse(int id);

    Optional<AppointmentEntity> findByAppointmentDateAndIsDeletedFalse(LocalDate date);

    Boolean existsByAppointmentDateAndAppointmentStartTime(LocalDate date, LocalTime startTime);
}
