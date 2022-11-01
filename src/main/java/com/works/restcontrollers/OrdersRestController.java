package com.works.restcontrollers;

import com.works.entities.Orders;
import com.works.services.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class OrdersRestController {
    final OrdersService ordersService;

    @GetMapping("/listAll")
    public ResponseEntity listAll() {
        return ordersService.listAll();
    }

    @GetMapping("/getOrdersByEmail")
    public ResponseEntity list(@RequestParam String email) {
        return ordersService.getOrdersByEmail(email);
    }
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Orders orders) {
        return ordersService.save(orders);
    }
   // @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/delete/{oid}")
    public ResponseEntity delete(@PathVariable int oid){
        return ordersService.delete(oid);
    }
}