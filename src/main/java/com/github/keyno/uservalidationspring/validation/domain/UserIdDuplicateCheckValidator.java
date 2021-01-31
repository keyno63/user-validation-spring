package com.github.keyno.uservalidationspring.validation.domain;

import com.github.keyno.uservalidationspring.validation.service.UserService;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UserIdDuplicateCheckValidator
        implements ConstraintValidator<UserIdDuplicateCheck, Object> {

    private String message;

    private final UserService userService;

    public UserIdDuplicateCheckValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(value);
        String userId = (String) beanWrapper.getPropertyValue("userId");

        System.out.println("userService is null is " + (userService == null));
        boolean blResult = userService.checkDuplicate(userId);

        if(!blResult) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message).addPropertyNode("userId").addConstraintViolation();
        }

        return true;
    }
}
