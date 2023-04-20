package ru.springboot.PP_3_1_2_spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.springboot.PP_3_1_2_spring_boot.model.User;
import ru.springboot.PP_3_1_2_spring_boot.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String printWelcome(Model model) {
        List<User>  allUser = userService.getAllUser();
        model.addAttribute("AllUser", allUser);
        return "user";
    }
    @GetMapping("/new")
    public String addNewUser(@ModelAttribute("newuser") User user) {
        return "user-info";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("newuser") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }
    @GetMapping("/updateInfo")
    public String updateUser(@RequestParam(value= "id") Long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("newuser",user);
    return "user-info";
    }
    @GetMapping("/deleteInfo")
    public String deleteUser(@RequestParam(value= "id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
