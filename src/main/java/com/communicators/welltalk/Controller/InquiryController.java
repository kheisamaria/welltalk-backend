package com.communicators.welltalk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.communicators.welltalk.Entity.InquiryEntity;
import com.communicators.welltalk.Service.InquiryService;

import java.util.List;

@RestController
@RequestMapping("/user/inquiry")
public class InquiryController {

    @Autowired
    InquiryService inquiryService;

    @PostMapping("/createInquiry")
    public ResponseEntity<InquiryEntity> insertInquiry(@RequestBody InquiryEntity inquiry) {
        InquiryEntity newInquiry = inquiryService.registerInquiry(inquiry);
        return new ResponseEntity<>(newInquiry, HttpStatus.CREATED);
    }

    @GetMapping("/getAllInquiries")
    public ResponseEntity<List<InquiryEntity>> getAllInquiries() {
        List<InquiryEntity> inquiries = inquiryService.getAllInquiries();
        return new ResponseEntity<>(inquiries, HttpStatus.OK);
    }

    @GetMapping("/getInquiryById/{id}")
    public ResponseEntity<InquiryEntity> getInquiryById(@PathVariable int id) {
        InquiryEntity inquiry = inquiryService.getInquiryByInquiryId(id);
        if (inquiry != null) {
            return new ResponseEntity<>(inquiry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateInquiry/{id}")
    public ResponseEntity<InquiryEntity> updateInquiry(@PathVariable int id, @RequestBody InquiryEntity inquiry) {
        InquiryEntity updatedInquiry = inquiryService.updateInquiry(id, inquiry);
        if (updatedInquiry == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedInquiry, HttpStatus.OK);
    }

    @DeleteMapping("/deleteInquiry/{id}")
    public ResponseEntity<Void> deleteInquiry(@PathVariable int id) {
        boolean deleted = inquiryService.deleteInquiry(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
