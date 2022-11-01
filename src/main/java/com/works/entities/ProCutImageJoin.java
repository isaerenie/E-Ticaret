package com.works.entities;

import lombok.Data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Data
public class ProCutImageJoin {

    @Id

    private Integer pid;

    private Integer price;

    private String productTitle;

    private String categoryTitle;

    private String description;

    private boolean onSale;
    private String  file;
}

