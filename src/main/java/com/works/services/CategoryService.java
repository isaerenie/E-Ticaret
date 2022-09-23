package com.works.services;

import com.works.entities.Category;
import com.works.repositories.CategoryRepository;
import com.works.utils.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryService {
    final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

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
    public ResponseEntity delete( int id ) {
        Map<String, Object> hm = new HashMap<>();
        try {
            categoryRepository.deleteById(id);
            hm.put("status", true);
        }catch (Exception ex) {
            hm.put("message", "id request : " + id);
            hm.put("status", false);
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

}
