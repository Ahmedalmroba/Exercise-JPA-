package com.example.capstone.Service;

import com.example.capstone.Model.MerchantStock;
import com.example.capstone.Repository.MerchantStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantStockService {
    private final MerchantStockRepository merchantStockRepository;
    List<MerchantStock> merchantStocks = new ArrayList<>();
    public List<MerchantStock> getMerchantStocks() {
        return merchantStockRepository.findAll();
    }
    public void addMerchantStock(MerchantStock merchantStock) {
        merchantStockRepository.save(merchantStock);

    }
    public boolean updateMerchantStock(Integer id,MerchantStock merchantStock) {
       MerchantStock m = merchantStockRepository.getById(id);
       if (m == null) {
           return false;
       }
           m.setProductid(merchantStock.getProductid());
           m.setMerchantid(merchantStock.getMerchantid());
           m.setStock(merchantStock.getStock());
           merchantStockRepository.save(m);
           return true;

       }
    public boolean deleteMerchantStock(Integer id) {
        MerchantStock m = merchantStockRepository.getById(id);
        if (m == null) {
            return false;
        }
        merchantStockRepository.delete(m);
        return true;
    }


    public boolean addStockToMerchant(int productid, int merchantid, int amount) {
        for (MerchantStock merchantStock : merchantStocks) {
            if (merchantStock.getProductid().equals(productid)&& merchantStock.getMerchantid().equals(merchantid)) {

                int currentStock = merchantStock.getStock();
                int newStock = currentStock + amount;
                merchantStock.setStock(newStock);
                return true;
            }
        }

        return false;

    }



            }





