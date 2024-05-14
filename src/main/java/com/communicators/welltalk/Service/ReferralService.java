package com.communicators.welltalk.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communicators.welltalk.Entity.ReferralEntity;
import com.communicators.welltalk.Repository.ReferralRepository;

@Service
public class ReferralService {

    @Autowired
    ReferralRepository referralRepository;

    public List<ReferralEntity> getAllReferrals() {
        return referralRepository.findByIsDeletedFalse();
    }

    public ReferralEntity getReferralById(int id) {
        return referralRepository.findByReferralIdAndIsDeletedFalse(id);
    }

    public List<ReferralEntity> getReferralsByReferredById(int id) {
        return referralRepository.findByTeacher_IdAndIsDeletedFalse(id);
    }

    public ReferralEntity saveReferral(ReferralEntity referral) {
        return referralRepository.save(referral);
    }

    @SuppressWarnings("finally")
    public ReferralEntity updateReferral(int id, ReferralEntity referral) {
        ReferralEntity referralToUpdate = new ReferralEntity();
        try {
            referralToUpdate = referralRepository.findByReferralIdAndIsDeletedFalse(id);

            referralToUpdate.setReferFirstName(referral.getReferFirstName());
            referralToUpdate.setReferLastName(referral.getReferLastName());
            referralToUpdate.setReferStudentId(referral.getReferStudentId());
            referralToUpdate.setReason(referral.getReason());
            referralToUpdate.setAdditionalNotes(referral.getAdditionalNotes());
            referralToUpdate.setStatus(referral.getStatus());

        } catch (Exception e) {
            throw new IllegalArgumentException("Referral " + referral.getReferralId() + " does not exist.");
        } finally {
            return referralRepository.save(referralToUpdate);
        }
    }

    public boolean deleteReferral(int id) {
        ReferralEntity referral = referralRepository.findByReferralIdAndIsDeletedFalse(id);
        if (referral != null) {
            referral.setIsDeleted(true);
            referralRepository.save(referral);
            return true;
        } else {
            System.out.println("Referral " + id + " does not exist.");
            return false;
        }
    }

}
