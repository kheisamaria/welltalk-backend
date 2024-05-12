package com.communicators.welltalk.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.communicators.welltalk.Entity.InquiryEntity;

@Repository
public interface InquiryRepository extends JpaRepository<InquiryEntity, Integer> {
    List<InquiryEntity> findByIsDeletedFalse();
}
