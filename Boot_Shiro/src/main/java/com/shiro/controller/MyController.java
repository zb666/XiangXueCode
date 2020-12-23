package com.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping({"/","index","index.html"})
    public String toIndex(Model model){
        model.addAttribute("msg","Hello Shiro");
        return "index";
    }

    @RequestMapping("/user/add")
    public String toIndex(){
        return "/user/add";
    }

    @RequestMapping("/user/update")
    public String toUpdate(){
        return "/usr/update";
    }

}
