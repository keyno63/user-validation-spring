package com.github.keyno.uservalidationspring.config;

import com.github.keyno.uservalidationspring.validation.domain.UserIdDuplicateCheckValidator;
import com.github.keyno.uservalidationspring.validation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class WebMvcConfig {

    @Autowired
    private UserService userService;


    @Bean
    Validator validator() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public UserIdDuplicateCheckValidator createUserIdDuplicateCheckValidator() {
        UserIdDuplicateCheckValidator validator = new UserIdDuplicateCheckValidator(userService);
        return new UserIdDuplicateCheckValidator(userService);
    }

    @Bean
    public Validator getValidator() {
        return validator();
    }
}
