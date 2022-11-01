package com.works.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer oid;
    private Integer pid;
    private String email;
}
