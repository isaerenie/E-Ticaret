package com.works.restcontrollers;

import com.works.entities.Category;
import com.works.entities.Product;
import com.works.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductRestController {
    final ProductService productService;


    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Product product){
        System.out.println(product);
        return productService.save(product);
    }
    @GetMapping("/list")
    public ResponseEntity save(){
        return productService.list();
    }
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Product product){
        return productService.update(product);
    }
    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam int id){
        return productService.delete(id);
    }
    @GetMapping("/search")
    public ResponseEntity search(@RequestParam(defaultValue = "") String q){
        return productService.search(q);
    }
    @GetMapping("/page")
    public ResponseEntity page(@RequestParam(defaultValue = "0") int start){
        return productService.page(start);
    }

}
