package com.communicators.welltalk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.communicators.welltalk.Entity.CounselorEntity;
import com.communicators.welltalk.Service.CounselorService;

import java.util.List;

@RestController
@RequestMapping("/counselor")
public class CounselorController {

    @Autowired
    CounselorService counselorService;

    @PostMapping("/createCounselor")
    public CounselorEntity insertCounselor(CounselorEntity counselor) {
        return counselorService.saveCounselor(counselor);
    }

    @GetMapping("/getAllCounselors")
    public List<CounselorEntity> getAllCounselors() {
        return counselorService.getAllCounselors();
    }

    @GetMapping("/getCounselorById/{id}")
    public CounselorEntity getCounselorById(int id) {
        return counselorService.getCounselorById(id);
    }

    @PostMapping("/updateCounselor")
    public CounselorEntity updateCounselor(@RequestBody CounselorEntity counselor) {
        return counselorService.updateCounselor(counselor);
    }

    @GetMapping("/deleteCounselor/{id}")
    public String deleteCounselor(@PathVariable int id) {
        return counselorService.deleteCounselor(id);
    }
}
