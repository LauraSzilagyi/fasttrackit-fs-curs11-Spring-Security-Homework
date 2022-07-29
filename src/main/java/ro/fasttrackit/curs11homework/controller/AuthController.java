package ro.fasttrackit.curs11homework.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("me")
    SecurityContext me(){
        return SecurityContextHolder.getContext();
    }
}
