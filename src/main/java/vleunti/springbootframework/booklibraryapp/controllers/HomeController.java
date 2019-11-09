package vleunti.springbootframework.booklibraryapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Home Controller that is responsible for Index/Home Page

@Controller
public class HomeController {

    @GetMapping({"", "/", "/index"})
    public String getIndexPage() {
        return "index";
    }
}
