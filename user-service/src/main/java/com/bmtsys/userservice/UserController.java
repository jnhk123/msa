package com.bmtsys.userservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private Map<Long, String> users = new HashMap<>() {{
        put(1L, "John Doe");
        put(2L, "Jane Doe");
    }};

    @GetMapping("/{userId}")
    public String getUserById(@PathVariable Long userId) {
        return users.getOrDefault(userId, "User not found");
    }

}
