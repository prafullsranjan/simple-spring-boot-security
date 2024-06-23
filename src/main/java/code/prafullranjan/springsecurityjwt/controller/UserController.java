package code.prafullranjan.springsecurityjwt.controller;

import code.prafullranjan.springsecurityjwt.entity.UserEntity;
import code.prafullranjan.springsecurityjwt.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity entity) {
        return new ResponseEntity<>(userService.addUser(entity), HttpStatus.OK);
    }

    @PostMapping("/find/{name}")
    public ResponseEntity<UserEntity> getUserByName(@PathVariable String name) {
        return new ResponseEntity<>(userService.getUserByName(name), HttpStatus.OK);
    }

}
