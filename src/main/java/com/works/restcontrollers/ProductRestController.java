package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/product")
public class ProductRestController {
    final ProductService productService;


    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Product product) {
        System.out.println(product);
        return productService.save(product);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return productService.list();
    }

    @GetMapping("/list1")
    public ResponseEntity list1() {
        return productService.list1();
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping("/delete/{pid}")
    public ResponseEntity delete(@PathVariable int pid) {
        return productService.delete(pid);
    }

    @GetMapping("/search")
    public ResponseEntity search(@RequestParam(defaultValue = "") String q) {
        return productService.search(q);
    }

    @GetMapping("/page")
    public ResponseEntity page(@RequestParam(defaultValue = "0") int start) {
        return productService.page(start);
    }
    @GetMapping("/getcatprolist/{cid}")
    public ResponseEntity getcatprolist(@PathVariable int cid) {
        return productService.getcatprolist(cid);
    }

    @GetMapping("/getProductById/{pid}")
    public ResponseEntity getProductById(@PathVariable int pid) {
        return productService.getProductById(pid);
    }

}
