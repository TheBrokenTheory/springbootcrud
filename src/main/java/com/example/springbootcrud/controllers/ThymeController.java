package com.example.springbootcrud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeController {
    @RequestMapping(value="/people")
    public String people(){
        return "people";
    }
}
