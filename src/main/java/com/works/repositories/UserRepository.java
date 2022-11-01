package com.works.repositories;

import com.works.dto.UserDto;
import com.works.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select count(*) from user", nativeQuery = true)
    long count();

    @Query(value = "select u.id,u.email,u.enabled,u.first_name,u.last_name,u.password,u.token_expired from user as u", nativeQuery = true)
    List<User> allUser();

    Optional<User> findByEmailEqualsIgnoreCase(String email);


}