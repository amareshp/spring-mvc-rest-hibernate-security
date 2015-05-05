package com.visitamaresh.ws.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @RequestMapping("/details")
    public String hello(@RequestParam(value="username", required=false) String username,
            Model model) {
        if(username == null) {
            model.addAttribute("msg", "Hello user...");
        } else {
            model.addAttribute("msg", "Hello " + userDetailsService.loadUserByUsername(username) );
        }
            return "result";
    }
}