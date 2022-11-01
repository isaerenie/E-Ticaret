package com.works.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
public class OrderDetails {
    @Id
    private Integer oid;
    private Integer pid;
    private String firstName;
    private String lastName;
    private String email;
    private String productTitle;
    private String description;
    private Integer price;
    private String file;

}