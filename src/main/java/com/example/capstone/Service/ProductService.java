package com.example.capstone.Service;

import com.example.capstone.Model.Product;
import com.example.capstone.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    ArrayList<Product> products = new ArrayList<Product>();
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
    public void addProduct(Product product) {
        productRepository.findAll();
    }
    public boolean updateProduct(Integer id, Product product) {
        Product p = productRepository.getById(id);
        if (p == null) {
            return false;
        }
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setCategoryID(product.getCategoryID());
        productRepository.save(p);
        return true;


    }
    public boolean deleteProduct(Integer id) {
        Product p = productRepository.getById(id);
        if (p == null) {
            return false;
        }
        productRepository.delete(p);
        return true;
    }
    }




