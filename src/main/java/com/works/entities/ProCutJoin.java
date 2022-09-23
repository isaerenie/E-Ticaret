package com.works.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class ProCutJoin {
    @Id
    private Integer pid;
    private Integer cid;
    private Integer fid;
    private Integer price;
    private String productTitle;
    private String categoryTitle;
    private String description;
    private String photoUrl;
    private boolean onSale;
}

