package com.example.capstone.Controller;

import com.example.capstone.Model.Merchant;
import com.example.capstone.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchant")
@RequiredArgsConstructor

public class MerchantController {
    private final MerchantService merchantService;
    @GetMapping("/get")
    public ResponseEntity getMerchant() {

        return ResponseEntity.status(200).body(merchantService.getMerchants());
    }
    @PostMapping("/add")
    public ResponseEntity addMerchant(@Valid @RequestBody Merchant merchant, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);

        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body("merchant added");
    }
     @PutMapping("/update/{id}")
    public ResponseEntity  updateMerchant(@PathVariable Integer id,@Valid @RequestBody Merchant merchant, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = merchantService.updateMerchant(id,merchant);
        if (isUpdated) {
            return ResponseEntity.status(200).body("merchant updated");
        }
        return ResponseEntity.status(400).body("merchant not updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable Integer id) {
        boolean isDeleted = merchantService.deleteMerchant(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("merchant deleted");
        }
        return ResponseEntity.status(400).body("merchant not deleted");
    }




}
