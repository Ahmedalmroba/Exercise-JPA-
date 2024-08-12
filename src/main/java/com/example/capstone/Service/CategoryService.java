package com.example.capstone.Service;

import com.example.capstone.Model.Category;
import com.example.capstone.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();

    }
    public void addCategory(Category category) {
       categoryRepository.save(category);

    }
    public boolean updateCategory(Integer id,Category category) {
        Category c = categoryRepository.getById(id);
        if(c == null) {
            return false;
        }
        c.setName(category.getName());
        categoryRepository.save(c);
        return true;

           }

     public boolean deleteCategory(Integer id) {
      Category c = categoryRepository.getById(id);
       if(c == null) {
       return false;
     }
     categoryRepository.delete(c);
     return true;
        }
    }
