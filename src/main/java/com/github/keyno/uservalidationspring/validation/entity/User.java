package com.github.keyno.uservalidationspring.validation.entity;

import com.github.keyno.uservalidationspring.validation.domain.UserIdDuplicateCheck;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
//@UserIdDuplicateCheck(message = "ID重複")
public class User {
    @Id
    private String userId;

    private String password;

    private String firstName;

    private String lastName;
}
