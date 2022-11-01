package com.works.services;

import com.works.entities.Category;
import com.works.entities.OrderDetails;
import com.works.entities.Orders;
import com.works.repositories.OrderDetailsRepository;
import com.works.repositories.OrdersRepository;
import com.works.utils.ERest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrdersService {
    final OrderDetailsRepository orderDetailsRepository;
    final OrdersRepository ordersRepository;

    public ResponseEntity listAll() {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {
            List<OrderDetails> ls = orderDetailsRepository.listAll();
            hm.put(ERest.status, true);
            hm.put(ERest.result, ls);
        } catch (Exception e) {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Error:" + e);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }
    public ResponseEntity getOrdersByEmail(String email) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        List<OrderDetails> ls = orderDetailsRepository.getOrdersByEmail(email);
        try {
            hm.put(ERest.status, true);
            hm.put(ERest.result, ls);
        } catch (Exception e) {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Error:" + e);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }
    public ResponseEntity save(Orders orders) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        System.out.println("heyooooooooooo"+orders);
        try {
            Orders orders1 = ordersRepository.save(orders);
            hm.put(ERest.status, true);
            hm.put(ERest.result, orders1);
        } catch (Exception e) {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Error:" + e);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }
    public ResponseEntity delete( int oid ) {
        Map<String, Object> hm = new HashMap<>();
        try {
            ordersRepository.deleteById(oid);
            hm.put("status", true);
        }catch (Exception ex) {
            hm.put("message", "id request : " + oid);
            hm.put("status", false);
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
