package com.works.restcontrollers;

import com.works.entities.Category;
import com.works.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryRestController {
    final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Category category){
        System.out.println(category);
        return categoryService.save(category);
    }
    @GetMapping("/list")
    public ResponseEntity save(){
        return categoryService.list();
    }
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Category category){
        return categoryService.update(category);
    }
    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam int id){
        return categoryService.delete(id);
    }
}
