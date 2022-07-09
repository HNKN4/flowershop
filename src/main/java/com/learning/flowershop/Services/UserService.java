package com.learning.flowershop.Services;

import com.learning.flowershop.Entity.User;
import com.learning.flowershop.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        List<User> user = (List<User>) userRepository.findAll();
        return user;
    }

    public void changeMoney(Long userId, Integer money) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setMoney(money);
            userRepository.save(user);
        } else {
            throw new RuntimeException("user not found");
        }
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}