package com.learning.flowershop.Controllers;

import com.learning.flowershop.Entity.User;
import com.learning.flowershop.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/getAllUsers")
    protected List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/changeMoney")
    protected void changeMoney(@RequestParam("userId") Long userId,
                               @RequestParam("money") Integer money) {
        userService.changeMoney(userId, money);
    }
}