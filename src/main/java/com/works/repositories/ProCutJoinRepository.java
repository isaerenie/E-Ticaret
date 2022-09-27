package com.works.repositories;


import com.works.entities.ProCutImageJoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProCutJoinRepository extends JpaRepository<ProCutImageJoin, Integer> {
    @Query(value = "select p.pid,p.product_title,p.description,c.category_title,p.price,p.on_sale,pr.file from product p inner join category c on p.cid=c.cid inner join product_image pr on p.pid=pr.pid",nativeQuery = true)
    List<ProCutImageJoin> allProduct();
    @Query(value = "select p.pid,p.product_title,p.description,c.category_title,p.price,p.on_sale,pr.file from product p inner join category c on p.cid=c.cid inner join product_image pr on p.pid=pr.pid where p.product_title like ?1",nativeQuery = true)
    List<ProCutImageJoin> searchProduct(String q);
    @Query(value = "select p.pid,p.product_title,p.description,c.category_title,p.price,p.on_sale,pr.file from product p inner join category c on p.cid=c.cid inner join product_image pr on p.pid=pr.pid limit ?1,?2",nativeQuery = true)
    List<ProCutImageJoin> pageProduct(int start,int count);

}