package com.works.repositories;

import com.works.dto.UserDto;
import com.works.entities.UserRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRolRepository extends JpaRepository<UserRol, Integer> {

}