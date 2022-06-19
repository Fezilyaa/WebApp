package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@Transactional
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.listOfUsers());
        return "users";
    }

    @GetMapping("users/{id}")
    public String getUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("users", userService.getUserById(id));
        return "users";
    }

    @GetMapping("users/add")
    public String userFormPage(User user) {
        return "add";
    }

    @PostMapping("users/add")
    public String createUser(User user) {
        userService.addUser(user);
        return "redirect:/users";
    }
    @GetMapping("users/{id}/edit")
    public String userUpdatePage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PostMapping("users/{id}/edit")
    public String update (User user) {
        userService.changeUser(user);
        return "redirect:/users";
    }

    @GetMapping("users/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}




