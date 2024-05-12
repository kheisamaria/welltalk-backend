package com.communicators.welltalk.Repository;

// import java.util.List;
// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.communicators.welltalk.Entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    // List<StudentEntity> findByIsDeletedFalse();

    // Optional<StudentEntity> findByIdandIsDeletedFalse(int id);

    // Optional<StudentEntity> findByInstitutionalEmailandIsDeletedFalse(String
    // institutionalEmail);
}