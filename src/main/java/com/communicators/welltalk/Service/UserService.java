package com.communicators.welltalk.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communicators.welltalk.Entity.UserEntity;
import com.communicators.welltalk.Repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public List<UserEntity> getAllIsNotDeletedUsers() {
        return userRepository.findByIsDeletedFalse();
    }

    public UserEntity getUserById(int id) {
        return userRepository.findById(id).get();
    }

    public UserEntity getUserByIdAndIsNotDeleted(int id) {
        return userRepository.findByIdAndIsDeletedFalse(id).get();
    }

    public boolean isInstitutionalEmailPresent(String institutionalEmail){
        return userRepository.findByInstitutionalEmailAndIsDeletedFalse(institutionalEmail).isPresent();
    }

    public UserEntity registerUser(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity updateUser(UserEntity user) {
        return userRepository.save(user);
    }

    public String deleteUser(int id) {
        String message = "";

        if (userRepository.findById(id) != null) {
            userRepository.deleteById(id);
            message = "Student " + id + " is successfully deleted!";
        } else
            message = "Student " + id + " does not exist.";
        return message;
    }
}
