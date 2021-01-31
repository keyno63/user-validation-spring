package com.github.keyno.uservalidationspring.validation.entity;

public class UserBuilder {

    private String userId;
    private String password;
    private String firstName;
    private String lastName;

    public UserBuilder() {
        userId = "";
        password = "";
        firstName = "";
        lastName = "";
    }

    public UserBuilder userId(String value) {
        this.userId = value;
        return this;
    }

    public UserBuilder password(String value) {
        this.password = value;
        return this;
    }
    public UserBuilder firstName(String value) {
        this.firstName = value;
        return this;
    }
    public UserBuilder lastName(String value) {
        this.lastName = value;
        return this;
    }

    public User build() {
        User ret = new User();
        ret.setUserId(userId);
        ret.setPassword(password);
        ret.setFirstName(firstName);
        ret.setLastName(lastName);
        return ret;
    }
}
