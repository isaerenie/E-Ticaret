package com.works.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link com.works.entities.User} entity
 */
@Data
public class UserDto implements Serializable {
    private final Long id;
    @NotEmpty
    @NotNull
    private final String firstName;
    private final String lastName;
    private final String email;
}