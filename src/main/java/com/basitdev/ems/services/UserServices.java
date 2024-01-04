package com.basitdev.ems.services;

import com.basitdev.ems.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface UserServices {
    void seedData();
    List<User> getAllUsers();
    Optional<User> getUserById(UUID id);
    User createUser(User user);
    User updateUser(User user);
    void deleteUserById(UUID id);
}
