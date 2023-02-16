package com.works.services;

import com.works.entities.Category;
import com.works.entities.Product;
import com.works.repositories.CategoryRepository;
import com.works.repositories.ProductRepository;
import com.works.utils.ERest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CategoryService {
    final CategoryRepository categoryRepository;
    final ProductRepository productRepository;


    public ResponseEntity save(Category category) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {
            Category category1 = categoryRepository.save(category);
            hm.put(ERest.status, true);
            hm.put(ERest.result, category1);
        } catch (Exception e) {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Error:" + e);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list() {
        System.out.println("list");
        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {
            List<Category> ls = categoryRepository.findAll();
            hm.put(ERest.status, true);
            hm.put(ERest.result, ls);
        } catch (Exception e) {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Error:" + e);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity update(Category category) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        Optional<Category> optionalCategory = categoryRepository.findById(category.getCid());
        System.out.println(optionalCategory);
        try {
            if (optionalCategory.isPresent()) {
                categoryRepository.saveAndFlush(category);
                hm.put(ERest.status, true);
                hm.put(ERest.result, category);
            } else {
                hm.put(ERest.status, false);
                hm.put(ERest.message, "Böyle bir kategori yok");
            }

        } catch (Exception e) {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Error:" + e);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity delete(int cid) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        productRepository.deleteByCidEquals(cid);
        try {
            categoryRepository.deleteById(cid);
            hm.put(ERest.status, true);
        } catch (Exception ex) {
            hm.put(ERest.message, "id request : " + cid);
            hm.put(ERest.status, false);
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

}
