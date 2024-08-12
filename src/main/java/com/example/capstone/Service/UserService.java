package com.example.capstone.Service;

import com.example.capstone.Model.Merchant;
import com.example.capstone.Model.Product;
import com.example.capstone.Model.User;
import com.example.capstone.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;
    ArrayList<User> users = new ArrayList<User>();
    private final ArrayList<Product>cartItems= new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    private final MerchantService merchantService;
    private final ProductService productService;
    private final MerchantStockService merchantStockService;


    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public void addUser(User user) {
        userRepository.save(user);
    }

    public boolean updateUser(Integer id, User user) {
        User u = userRepository.getById(id);
        if (u == null) {
            return false;
        }
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setEmail(user.getEmail());
        u.setBalance(user.getBalance());
        u.setRole(user.getRole());
        u.setDiscount(user.getDiscount());
        userRepository.save(u);
        return true;

    }
    public boolean deleteUser(Integer id) {
        User u = userRepository.getById(id);
        if (u == null) {
            return false;
        }
        userRepository.delete(u);
        return true;
    }


    public int buyProduct(int userId, int productId, int merchantId) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() != userId) {
                return 1;
            }

        }
        for (int j = 0; j < merchantService.getMerchants().size(); j++) {
            if (merchantService.getMerchants().get(j).getId() == merchantId) {
                return 2;
            }

        }
        for (int j = 0; j < productService.getProducts().size(); j++) {
            if (productService.getProducts().get(j).getId() == productId) {
                return 3;
            }
        }
        return 0;
    }

    public void addCartItem(Product product  ) {
        cartItems.add(product);

    }
    private final double buy = 1000.0;

    public ArrayList<Product> getCartItems() {
        return cartItems;
    }
    public double checkout(int userId) {
        double total = 0.0;
        for (Product product : cartItems) {
            total += product.getPrice();
        }

        if (total > buy) {

            total -= (total * 0.15);
        }

        return total;
}

}







