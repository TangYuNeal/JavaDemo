package com.example.controller;

import com.example.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AccoutController {
    @GetMapping
    public String FindAccount() {
        return "Accouts";
    }

}
