package com.works.repositories;


import com.works.entities.ProCutImageJoin;
import com.works.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProCutJoinRepository extends JpaRepository<ProCutImageJoin, Integer> {
    @Query(value = "select p.pid,p.product_title,p.description,c.category_title,p.price,p.on_sale,pr.file from product p left join category c on p.cid=c.cid left join product_image pr on p.pid=pr.pid group by p.pid", nativeQuery = true)
    List<ProCutImageJoin> allProduct();

    @Query(value = "select p.pid,p.product_title,p.description,c.category_title,p.price,p.on_sale,pr.file from product p inner join category c on p.cid=c.cid inner join product_image pr on p.pid=pr.pid where p.product_title like ?1", nativeQuery = true)
    List<ProCutImageJoin> searchProduct(String q);

    @Query(value = "select p.pid,p.product_title,p.description,c.category_title,p.price,p.on_sale,pr.file from product p inner join category c on p.cid=c.cid inner join product_image pr on p.pid=pr.pid limit ?1,?2", nativeQuery = true)
    List<ProCutImageJoin> pageProduct(int start, int count);

    @Query(value = "select p.pid,p.product_title,p.description,c.category_title,p.price,p.on_sale,pr.file from product p inner join category c on p.cid=c.cid inner join product_image pr on p.pid=pr.pid WHERE c.cid=?1 group by p.pid", nativeQuery = true)
    List<ProCutImageJoin> findCatPro(int cid);

    @Query(value = "select p.pid,p.product_title,p.description,c.category_title,p.price,p.on_sale from product p inner join category c on p.cid=c.cid where p.pid=?1",nativeQuery = true)
    Product getProductById(int pid);
}