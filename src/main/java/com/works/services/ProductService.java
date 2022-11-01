package com.works.services;

import com.works.entities.Category;
import com.works.entities.ProCutImageJoin;
import com.works.entities.Product;
import com.works.repositories.ProCutJoinRepository;
import com.works.repositories.ProductRepository;
import com.works.utils.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {
    final ProductRepository productRepository;
    final ProCutJoinRepository proCutJoinRepository;

    public ProductService(ProductRepository productRepository, ProCutJoinRepository proCutJoinRepository) {
        this.productRepository = productRepository;
        this.proCutJoinRepository = proCutJoinRepository;
    }

    public ResponseEntity save(Product product) {
        Map<ERest, Object> hm = new LinkedHashMap();
        try {
            Product product1 = productRepository.save(product);
            hm.put(ERest.status, true);
            hm.put(ERest.result, product1);
        } catch (Exception e) {
            hm.put(ERest.status, false);
            hm.put(ERest.error, e);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list() {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {
            List<ProCutImageJoin> ls = proCutJoinRepository.allProduct();
            hm.put(ERest.status, true);
            hm.put(ERest.result, ls);
        } catch (Exception e) {
            hm.put(ERest.status, false);
            hm.put(ERest.error, e);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list1() {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {
            List<Product> ls = productRepository.findAll();
            hm.put(ERest.status, true);
            hm.put(ERest.result, ls);
        } catch (Exception e) {
            hm.put(ERest.status, false);
            hm.put(ERest.error, e);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity update(Product product) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        Optional<Product> optionalProduct = productRepository.findById(product.getPid());
        try {
            if (optionalProduct.isPresent()) {
                Product product1 = productRepository.saveAndFlush(product);
                hm.put(ERest.status, true);
                hm.put(ERest.result, product1);
            } else {
                hm.put(ERest.status, false);
                hm.put(ERest.message, "Bu isimde bir ürün yok");
            }
        } catch (Exception e) {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Error:" + e);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity delete(int pid) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {
            productRepository.deleteById(pid);
            hm.put(ERest.status, true);
            hm.put(ERest.message, "Ürün başarı ile slindi");

        } catch (Exception e) {
            hm.put(ERest.status, false);
            hm.put(ERest.error, e);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }
    public ResponseEntity getProductById(int pid) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {
       Product product=proCutJoinRepository.getProductById(pid);
            hm.put(ERest.status, true);
            hm.put(ERest.result, product);

        } catch (Exception e) {
            hm.put(ERest.status, false);
            hm.put(ERest.error, e);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }
    public ResponseEntity search(String q) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.status, true);
        hm.put(ERest.result, proCutJoinRepository.searchProduct("%" + q + "%"));
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity page(int start) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.status, true);
        hm.put(ERest.result, proCutJoinRepository.pageProduct(start * 5, 5));
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity getcatprolist(int cid) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        List<ProCutImageJoin> ls = proCutJoinRepository.findCatPro(cid);
        hm.put(ERest.status, true);
        hm.put(ERest.result, ls);
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
