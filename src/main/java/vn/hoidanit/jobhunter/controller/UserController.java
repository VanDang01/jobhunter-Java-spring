package vn.hoidanit.jobhunter.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// import jakarta.validation.constraints.AssertFalse.List;
import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // @GetMapping("/user/create")
    @PostMapping("/user")
    public User createNewUser(
            @RequestBody User postManUser) {

        // User user = new User();
        // user.setEmail("vandang031001@gmail.com");
        // user.setName("Dang");
        // user.setPassword("123456");

        User dUser = this.userService.handleCreateUser(postManUser);

        return dUser;
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        this.userService.handleDeleteUser(id);
        return "dUser";
    }

    // bai tap
    // @GetMapping("/user/{id}")
    // public User getUser(@PathVariable("id") User id) {
    // User gUser = this.userService.handleGetUser(id);
    // return gUser;
    // }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") long id) {
        User gUser = this.userService.handleFetchUserById(id);
        return gUser;
    }

    // bai tap
    // @GetMapping("/user")
    // public List<User> getAllUser() {
    // return new String();
    // }

    @GetMapping("/user")
    public List<User> getAllUser() {
        return this.userService.fetchAllUser();
    }

    @PutMapping("user")
    public User updateUser(@RequestBody User user) {
        User pUser = this.userService.handleUpdateUser(user);
        return pUser;
    }

}
