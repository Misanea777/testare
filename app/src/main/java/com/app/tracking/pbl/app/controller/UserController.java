package com.app.tracking.pbl.app.controller;

import com.app.tracking.pbl.app.model.User;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    private static final List<User> users = new ArrayList<User>(
            new User(1, "notAnEmail@gmail.com", "joshua")
    );

    @GetMapping("/home")
    public ResponseEntity<?> message() {
        return new ResponseEntity<>("Hello, OAuth2!", HttpStatus.OK);
    }

    @GetMapping(path = "{userId}")
    public User getUser(@PathVariable("userId") Integer userId) {
        return users.stream()
                .filter(user -> userId.equals(user.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("User"+userId+"does not exist"));
    }


}
