package com.example.capstone.Controller;

import com.example.capstone.Model.Category;
import com.example.capstone.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("/get")
    public ResponseEntity getCategory() {
        return ResponseEntity.status(200).body(categoryService.getCategories());
    }
    @PostMapping("/add")
    public ResponseEntity addCategory(@Valid @RequestBody Category category , Errors errors) {
        if (errors.hasErrors()) {
            String msssage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(  msssage);
        }
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body("category added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@PathVariable  Integer id, @Valid @RequestBody Category category, Errors errors) {
        if (errors.hasErrors()) {
            String msssage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body( msssage);
        }
        boolean isUpdated = categoryService.updateCategory(id, category);
        if (isUpdated) {
            return ResponseEntity.status(200).body("category updated");
        }
        return ResponseEntity.status(400).body("category updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable Integer id) {
        boolean isDeleted = categoryService.deleteCategory(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("category deleted");
        }
        return ResponseEntity.status(400).body("category deleted");
    }


}
