package com.goat.h2.controller;

import com.goat.h2.domain.User;
import com.goat.h2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 64274 on 2019/4/21.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/21---11:51
 */
@Controller
@RequestMapping("/")
public class TestController {


    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String loginUI() {
        return "login";
    }

    @RequestMapping("login")
    public String login() {
        return "redirect:/list";
    }

    @RequestMapping("list")
    public String getUserList(Model model) {
        List<User> users = userService.findAllUser();
        model.addAttribute("users", users);
        return "list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "add";
    }

    @RequestMapping("/add")
    public String add(User user) {
        userService.save(user);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model, Integer id) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @RequestMapping("/edit")
    public String edit(User user) {
        userService.edit(user);
        return "redirect:/list";
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        userService.delete(id);
        return "redirect:/list";
    }
}
