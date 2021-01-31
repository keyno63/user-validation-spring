package com.github.keyno.uservalidationspring.validation.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.keyno.uservalidationspring.validation.entity.User;
import com.github.keyno.uservalidationspring.validation.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/validate")
public class ValidationController {

    private final UserService userService;

    public ValidationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/duplication")
    public ResponseEntity<ValidateResponse> duplication(@RequestParam String userId) {
        return ResponseEntity.ok(new ValidateResponse(userService.checkDuplicate(userId)));
    }

    @GetMapping("/find")
    public ResponseEntity<ValidateResponse> find(@RequestParam String userId) {
        return ResponseEntity.ok(new ValidateResponse(userService.find(userId).orElse(null)));
    }

    @GetMapping("/findAll")
    public ResponseEntity<ValidateResponse> findAll() {
        return ResponseEntity.ok(new ValidateResponse(userService.findAll()));
    }

    @GetMapping("/update")
    public ResponseEntity<ValidateResponse> update(
            @RequestParam String userId,
            @RequestParam String password,
            @RequestParam String firstName,
            @RequestParam String lastName
    ) {
        return ResponseEntity.ok(new ValidateResponse(userService.update(userId, password, firstName, lastName)));
    }

    public static class ValidateResponse {
        @JsonProperty private final Boolean isValidated;
        @JsonProperty private final List<User> users;

        public ValidateResponse(Boolean isValidated) {
            this.isValidated = isValidated;
            this.users = List.of();
        }

        public ValidateResponse(User user) {
            this.isValidated = true;
            this.users = List.of(user);
        }

        public ValidateResponse(List<User> users) {
            this.isValidated = true;
            this.users = users;
        }
    }
}
