package atividade2.tigas2909.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/error")

public class ErrorsController {
    @GetMapping("/404")
    public String error404() {
        return "error/404";
    }
}
