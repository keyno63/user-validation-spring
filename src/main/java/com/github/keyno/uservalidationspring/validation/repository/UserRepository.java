package com.github.keyno.uservalidationspring.validation.repository;

import com.github.keyno.uservalidationspring.validation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    long countByUserId(String userId);

    @Query(value = "select b.user_id as userId, b.password as password, b.first_name as firstName, b.last_name as lastName "
            + "from user b ",
            nativeQuery = true)
    List<User> findAll();
}
