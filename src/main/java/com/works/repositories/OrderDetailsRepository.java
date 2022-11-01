package com.works.repositories;

import com.works.entities.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
    @Query(value = "SELECT * from product p inner join category c on p.cid=c.cid inner join orders o on o.pid=p.pid inner join user u on u.email=o.email inner join product_image pi on pi.pid=p.pid", nativeQuery = true)
    List<OrderDetails> listAll();

    @Query(value = " select o.oid,p.pid,u.first_name,u.last_name,u.email,p.product_title,p.description,p.price,pi.file from product p inner JOIN orders o on o.pid=p.pid inner join user u on u.email=o.email inner join product_image pi on pi.pid=p.pid where u.email=?1", nativeQuery = true)
    List<OrderDetails> getOrdersByEmail(String email);
}
//todo  add ord

