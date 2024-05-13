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
        return inquiryRepository.findByIsDeletedFalse();
    }

    public InquiryEntity getInquiryByInquiryId(int id) {
        return inquiryRepository.findByInquiryIdAndIsDeletedFalse(id).get();
    }

    public InquiryEntity registerInquiry(InquiryEntity inquiry) {
        return inquiryRepository.save(inquiry);
    }

    @SuppressWarnings("finally")
    public InquiryEntity updateInquiry(int id, InquiryEntity inquiry) {
        InquiryEntity inquiryToUpdate = new InquiryEntity();
        try {
            inquiryToUpdate = inquiryRepository.findByInquiryIdAndIsDeletedFalse(id).get();

            inquiryToUpdate.setStudent(inquiry.getStudent());
            inquiryToUpdate.setCounselor(inquiry.getCounselor());
            inquiryToUpdate.setSubject(inquiry.getSubject());
            inquiryToUpdate.setMessageInquiry(inquiry.getMessageInquiry());
            inquiryToUpdate.setStatus(inquiry.getStatus());
            inquiryToUpdate.setDate(inquiry.getDate());
            inquiryToUpdate.setCounselorReply(inquiry.getCounselorReply());
            inquiryToUpdate.setMessageReply(inquiry.getMessageReply());
            inquiryToUpdate.setReplyDate(inquiry.getReplyDate());
        } catch (Exception e) {
            throw new IllegalArgumentException("Inquiry " + id + " does not exist.");
        } finally {
            return inquiryRepository.save(inquiryToUpdate);
        }
    }

    public boolean deleteInquiry(int id) {
        InquiryEntity inquiry = inquiryRepository.findByInquiryIdAndIsDeletedFalse(id).get();
        if (inquiry != null) {
            inquiry.setIsDeleted(true);
            inquiryRepository.save(inquiry);
            return true;
        } else {
            System.out.println("Inquiry " + id + " does not exist.");
            return false;
        }
    }
}
