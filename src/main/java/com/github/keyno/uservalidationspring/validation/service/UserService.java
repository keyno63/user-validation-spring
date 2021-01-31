package com.github.keyno.uservalidationspring.validation.service;

import com.github.keyno.uservalidationspring.validation.entity.User;
import com.github.keyno.uservalidationspring.validation.entity.UserBuilder;
import com.github.keyno.uservalidationspring.validation.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
    public Optional<User> find(String userId) {
        return userRepository.findById(userId);
    }

    public User update(String userId, String password, String firstName, String lastName) {
        User user = new UserBuilder()
                .userId(userId)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .build();
        //return user;
        return userRepository.save(user);
    }

    public boolean checkDuplicate(String userId) {
        return userRepository.countByUserId(userId) == 0;
    }
}
