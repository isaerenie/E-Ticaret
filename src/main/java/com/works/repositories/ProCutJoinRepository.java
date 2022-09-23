package com.works.repositories;

import com.works.entities.ProCutJoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProCutJoinRepository extends JpaRepository<ProCutJoin, Integer> {
    @Query(value = "select p.pid,p.cid,p.product_title,p.price,p.description,p.on_sale,c.category_title from product p inner join category c on p.cid=c.cid inner join photo ph on ph.pid=p.pid",nativeQuery = true)
    List<ProCutJoin> allProduct();
    @Query(value = "select p.pid,p.cid,p.product_title,p.price,p.description,p.on_sale,c.category_title from product p inner join category c on p.cid=c.cid inner join photo ph on ph.pid=p.pid where p.product_title like ?1",nativeQuery = true)
    List<ProCutJoin> searchProduct(String q);
    @Query(value = "select p.pid,p.cid,p.product_title,p.price,p.description,p.on_sale,c.category_title from product p inner join category c on p.cid=c.cid inner join photo ph on ph.pid=p.pid limit ?1,?2",nativeQuery = true)
    List<ProCutJoin> pageProduct(int start,int count);

}