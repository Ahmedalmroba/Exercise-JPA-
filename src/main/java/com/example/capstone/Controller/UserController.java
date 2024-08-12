package com.example.capstone.Controller;

import com.example.capstone.Model.Product;
import com.example.capstone.Model.User;
import com.example.capstone.Service.MerchantService;
import com.example.capstone.Service.MerchantStockService;
import com.example.capstone.Service.ProductService;
import com.example.capstone.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final MerchantStockService merchantStockService;
    private final MerchantService merchantService;


    @GetMapping("get")
    public ResponseEntity getUser() {
        return ResponseEntity.status(200).body(userService.getUsers());
    }


    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User added ");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = userService.updateUser(id, user);
        if (isUpdated) {
            return ResponseEntity.status(200).body("User updated");
        }
        return ResponseEntity.status(400).body("User not updated");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("User deleted");
        }
        return ResponseEntity.status(400).body("User not deleted");
    }

    @PostMapping("/buyProduct/{userId}/{productId}/{merchantId}")
    public ResponseEntity buyProduct(@PathVariable int userId, @PathVariable int productId, @PathVariable int merchantId) {

        int x = userService.buyProduct(userId, productId, merchantId);
        if (x == 1) {
            return ResponseEntity.status(400).body("user not found");

        }
        if (x == 2) {
            return ResponseEntity.status(400).body("user not found");
        }
        if (x == 3) {
            return ResponseEntity.status(400).body("user not found");

        }
        if ((x == 4)) return ResponseEntity.status(200).body("user found");

return ResponseEntity.status(200).body("user found");
    }



    @PostMapping("/addToCart")
    public ResponseEntity addToCart(@Valid@RequestBody Product product,Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addCartItem(product);
        return ResponseEntity.status(200).body("Product added to cart");
    }

    @GetMapping("/viewCart")
    public ResponseEntity viewCart() {
       List<Product> cartItems = userService.getCartItems();
        return ResponseEntity.status(200).body(cartItems);
    }
    @GetMapping("/getdiscount")
    public ResponseEntity<String> getdiscount () {
        String message = " discount applied";
        return ResponseEntity.status(200).body(message);

    }







}




