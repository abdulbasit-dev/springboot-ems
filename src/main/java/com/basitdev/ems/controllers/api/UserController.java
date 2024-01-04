package com.basitdev.ems.controllers.api;

import com.basitdev.ems.entity.User;
import com.basitdev.ems.repository.UserRepository;
import com.basitdev.ems.services.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("apiUserController")
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private final UserServices userServices;
    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> index() {
//        return new ResponseEntity <>(userServices.getAllUsers(), HttpStatus.OK);
        return new ResponseEntity <>(userRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
//        return userServices.createUser(user);
        var newUser = userRepository.save(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> show(@PathVariable UUID id) {
//        return new ResponseEntity<>(userServices.getUserById(id).orElse(null), HttpStatus.OK);
        var user = userRepository.findById(id).orElse(null);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable UUID id, @RequestBody User user) {
//        User userToUpdate = userServices.getUserById(id).orElse(null);
        User userToUpdate = userRepository.findById(id).orElse(null);
        if (userToUpdate == null)
            return null;

        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());

//      return new ResponseEntity<>(userServices.updateUser(userToUpdate), HttpStatus.OK);
        return new ResponseEntity<>(userRepository.save(userToUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> delete(@PathVariable UUID id) {
//        userServices.deleteUserById(id);
        userRepository.deleteById(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }
}
