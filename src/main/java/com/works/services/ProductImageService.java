package com.works.services;

import com.works.entities.ProductImage;
import com.works.repositories.ProductImageRepository;
import com.works.utils.ERest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductImageService {
    final ProductImageRepository pRepo;
    public ResponseEntity add(ProductImage productImage) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {
            pRepo.save(productImage);
            hm.put(ERest.status, true);
            hm.put(ERest.result,productImage);
        } catch (Exception e) {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Error:"+e);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list(Integer pid) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {

            hm.put(ERest.status, true);
            hm.put(ERest.images,  pRepo.findByPidEquals(pid));
        } catch (Exception e) {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Error:"+e);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity delete(Integer iid) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {
            pRepo.deleteById(iid);
            hm.put(ERest.status, true);
        } catch (Exception e) {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Error:"+e);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}