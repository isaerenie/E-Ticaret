package com.works.services;

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

    public ResponseEntity delete(int id) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        Optional<Product> optionalProduct = productRepository.findById(id);
        try {
            if (optionalProduct.isPresent()) {
                productRepository.deleteById(id);
                hm.put(ERest.status, true);
                hm.put(ERest.message, "Ürün başarı ile slindi");
            } else {
                hm.put(ERest.status, false);
                hm.put(ERest.message, "Ürün bulunamadı");
            }

        } catch (Exception e) {
            hm.put(ERest.status, false);
            hm.put(ERest.error, e);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity search(String q) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.status, true);
        hm.put(ERest.result, proCutJoinRepository.searchProduct("%" + q + "%" ));
        return new ResponseEntity(hm, HttpStatus.OK);
    }
    public ResponseEntity page(int start ) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.status, true);
        hm.put(ERest.result, proCutJoinRepository.pageProduct(start*5,5));
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
