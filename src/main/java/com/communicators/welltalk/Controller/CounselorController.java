package com.communicators.welltalk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.communicators.welltalk.Entity.CounselorEntity;
import com.communicators.welltalk.Service.CounselorService;

import java.util.List;

@RestController
@RequestMapping("/user/counselor")
public class CounselorController {

    @Autowired
    CounselorService counselorService;

    @PostMapping("/createCounselor")
    public ResponseEntity<CounselorEntity> insertCounselor(@RequestBody CounselorEntity counselor) {
        CounselorEntity newCounselor = counselorService.saveCounselor(counselor);
        return new ResponseEntity<>(newCounselor, HttpStatus.CREATED);
    }

    @GetMapping("/getAllCounselors")
    public ResponseEntity<List<CounselorEntity>> getAllCounselors() {
        List<CounselorEntity> counselors = counselorService.getAllCounselors();
        return new ResponseEntity<>(counselors, HttpStatus.OK);
    }

    @GetMapping("/getCounselorById/{id}")
    public ResponseEntity<CounselorEntity> getCounselorById(@PathVariable int id) {
        CounselorEntity counselor = counselorService.getCounselorById(id);
        if (counselor != null) {
            return new ResponseEntity<>(counselor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateCounselor/{id}")
    public ResponseEntity<CounselorEntity> updatCounselorEntity(@PathVariable int id,
            @RequestBody CounselorEntity counselor) {
        CounselorEntity updatedCounselor = counselorService.updateCounselor(id, counselor);
        if (updatedCounselor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedCounselor, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCounselor/{id}")
    public ResponseEntity<Void> deleteCounselor(@PathVariable int id) {
        boolean deleted = counselorService.deleteCounselor(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
