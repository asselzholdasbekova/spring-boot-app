package kz.assel.springcourse.SpringBootApp.controllers;

import jakarta.annotation.Resource;
import kz.assel.springcourse.SpringBootApp.security.CustomerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login(){
        return "auth/login";
    }

    @GetMapping()
    public String index(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomerDetails customerDetails = (CustomerDetails) authentication.getPrincipal();
        System.out.println(customerDetails.getCustomer());

        return "customers/index";
    }
}
