package com.communicators.welltalk.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communicators.welltalk.Entity.CounselorEntity;
import com.communicators.welltalk.Repository.CounselorRepository;

import java.util.List;

@Service
public class CounselorService {

    @Autowired
    CounselorRepository counselorRepository;

    public CounselorEntity saveCounselor(CounselorEntity counselor) {
        return counselorRepository.save(counselor);
    }

    public List<CounselorEntity> getAllCounselors() {
        return counselorRepository.findAll();
    }

    public CounselorEntity getCounselorById(int id) {
        return counselorRepository.findById(id).get();
    }

    public CounselorEntity updateCounselor(CounselorEntity counselor) {
        return counselorRepository.save(counselor);
    }

    public String deleteCounselor(int id) {
        String message = "";

        if (counselorRepository.findById(id) != null) {
            counselorRepository.deleteById(id);
            message = "Counselor " + id + " is successfully deleted!";
        } else
            message = "Counselor " + id + " does not exist.";
        return message;
    }

}
