package com.works.entities;

import lombok.Data;

import javax.persistence.*;
import java.nio.file.Files;

@Entity
@Data
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iid;
    // product id
    private Long pid;
    @Lob
    private String file;

}
