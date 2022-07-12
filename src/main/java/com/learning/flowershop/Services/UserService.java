package com.learning.flowershop.Services;

import com.learning.flowershop.Entity.User;
import com.learning.flowershop.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

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

    @Transactional
    public void changeMoney(Long userId, Integer money) {
        userRepository.findById(userId).ifPresentOrElse(v -> {
            v.setMoney(money);
        }, () -> {throw new RuntimeException("user not found");});
    }

    public User saveUser(User user) {
        user.setMoney(1000);
        return userRepository.save(user);
    }
}