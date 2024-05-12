package com.communicators.welltalk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.communicators.welltalk.Entity.InquiryEntity;
import com.communicators.welltalk.Service.InquiryService;

import java.util.List;

@RestController
@RequestMapping("/inquiry")
public class InquiryController {

    @Autowired
    InquiryService inquiryService;

    @PostMapping("/createInquiry")
    public InquiryEntity insertInquiry(InquiryEntity inquiry) {
        return inquiryService.registerInquiry(inquiry);
    }

    @GetMapping("/getAllInquiries")
    public List<InquiryEntity> getAllInquiries() {
        return inquiryService.getAllInquiries();
    }

    @GetMapping("/getInquiryById/{id}")
    public InquiryEntity getInquiryById(int id) {
        return inquiryService.getInquiryById(id);
    }

    @PostMapping("/updateInquiry")
    public InquiryEntity updateInquiry(InquiryEntity inquiry) {
        return inquiryService.updateInquiry(inquiry);
    }

    @GetMapping("/deleteInquiry/{id}")
    public String deleteInquiry(int id) {
        return inquiryService.deleteInquiry(id);
    }

    @GetMapping("/getAllIsNotDeletedInquiries")
    public List<InquiryEntity> getAllIsNotDeletedInquiries() {
        return inquiryService.getAllIsNotDeletedInquiries();
    }
}
