package com.example.securitydemo;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
//@RequestMapping("/non-secured")
public class UserController {

    @GetMapping("non-secured")
    public String nonSecured() {
        return "non secured";
    }

    @GetMapping("/secured")
    public String username(Principal principal) {

        return principal.getName();
    }

    @PreAuthorize("hasAnyAuthority('admin')")
    @GetMapping("/secured-for-admin")
    public String securedForAdminOnly(Principal principal) {
        return "ADMIN USER - " + principal.getName();
    }
}
