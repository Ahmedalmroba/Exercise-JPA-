package com.example.capstone.Controller;

import com.example.capstone.Model.MerchantStock;
import com.example.capstone.Service.CategoryService;
import com.example.capstone.Service.MerchantService;
import com.example.capstone.Service.MerchantStockService;
import com.example.capstone.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchantstock")
@RequiredArgsConstructor
public class MerchantStockController {
    private final MerchantStockService merchantStockService;
    private final UserService userService;
    private final MerchantService merchantService;


    @GetMapping("/get")
    public ResponseEntity getMerchantStock() {
        return ResponseEntity.status(200).body(merchantStockService.getMerchantStocks());
    }

    @PostMapping("/add")

    public ResponseEntity addMerchantStock(@Valid @RequestBody MerchantStock merchantStock, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantStockService.addMerchantStock(merchantStock);
        return ResponseEntity.status(200).body("merchant stock added" );
    }
    @PutMapping("/update/{id}")
    public ResponseEntity udpateMerchantStock(@PathVariable Integer id,@Valid @RequestBody MerchantStock merchantStock, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = merchantStockService.updateMerchantStock(id,merchantStock);
        if (isUpdated) {
        return ResponseEntity.status(200).body("merchantstock updated" );
    }
        return ResponseEntity.status(400).body("merchantstock not updated");
}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchantStock(@PathVariable Integer id) {
        boolean isDeleted = merchantStockService.deleteMerchantStock(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("merchantstock deleted" );

        }
        return ResponseEntity.status(400).body("merchantstock not deleted");
    }
    @PostMapping("/addStock/{productId}/{merchantId}/{amount}")
    public ResponseEntity addStockToMerchant(@PathVariable int productId, @PathVariable int merchantId, @PathVariable int amount) {
        boolean success = merchantStockService.addStockToMerchant(productId, merchantId, amount);

        if (success) {
            return ResponseEntity.status(200).body("Stock added to the merchant successfully.");
        } else {
            return ResponseEntity.status(400).body("Failed to add stock to the merchant.");
        }
    }}




