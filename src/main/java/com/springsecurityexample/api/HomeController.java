package com.springsecurityexample.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/home")
    public String index() {
        return "123";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admins")
    public String admin() {
        return "123";
    }
}
