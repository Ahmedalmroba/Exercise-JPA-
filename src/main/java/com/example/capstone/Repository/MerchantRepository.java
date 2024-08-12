package com.example.capstone.Repository;

import com.example.capstone.Model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository  extends JpaRepository<Merchant, Integer> {
}
