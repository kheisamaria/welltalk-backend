package com.communicators.welltalk.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communicators.welltalk.Entity.InquiryEntity;
import com.communicators.welltalk.Repository.InquiryRepository;

import java.util.List;

@Service
public class InquiryService {

    @Autowired
    InquiryRepository inquiryRepository;

    public List<InquiryEntity> getAllInquiries() {
        return inquiryRepository.findAll();
    }

    public List<InquiryEntity> getAllIsNotDeletedInquiries() {
        return inquiryRepository.findByIsDeletedFalse();
    }

    public InquiryEntity getInquiryById(int id) {
        return inquiryRepository.findById(id).get();
    }

    public InquiryEntity registerInquiry(InquiryEntity inquiry) {
        return inquiryRepository.save(inquiry);
    }

    public InquiryEntity updateInquiry(InquiryEntity inquiry) {
        return inquiryRepository.save(inquiry);
    }

    public String deleteInquiry(int id) {
        String message = "";

        if (inquiryRepository.findById(id) != null) {
            inquiryRepository.deleteById(id);
            message = "Inquiry " + id + " is successfully deleted!";
        } else
            message = "Inquiry " + id + " does not exist.";
        return message;
    }
}
