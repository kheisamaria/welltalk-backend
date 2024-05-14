package com.communicators.welltalk.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communicators.welltalk.Repository.JournalRepository;
import com.communicators.welltalk.Entity.JournalEntity;

import java.util.List;

@Service
public class JournalService {

    @Autowired
    JournalRepository journalRepository;

    public List<JournalEntity> getAllJournals() {
        return journalRepository.findByIsDeletedFalse();
    }

    public JournalEntity getJournalById(int id) {
        return journalRepository.findByJournalIdAndIsDeletedFalse(id);
    }

    public List<JournalEntity> getJournalsByStudentId(int id) {
        return journalRepository.findByStudentIdAndIsDeletedFalse(id);
    }

    public JournalEntity saveJournal(JournalEntity journal) {
        return journalRepository.save(journal);
    }

    @SuppressWarnings("finally")
    public JournalEntity updateJournal(int id, JournalEntity journal) {
        JournalEntity journalToUpdate = new JournalEntity();
        try {
            journalToUpdate = journalRepository.findByJournalIdAndIsDeletedFalse(id);

            journalToUpdate.setEntry(journal.getEntry());

        } catch (Exception e) {
            throw new IllegalArgumentException("Journal " + journal.getJournalId() + " does not exist.");
        } finally {
            return journalRepository.save(journalToUpdate);
        }
    }

    public boolean deleteJournal(int id) {
        JournalEntity journal = journalRepository.findByJournalIdAndIsDeletedFalse(id);
        if (journal != null) {
            journal.setIsDeleted(true);
            journalRepository.save(journal);
            return true;
        } else {
            System.out.println("Journal " + id + " does not exist.");
            return false;
        }
    }

}
