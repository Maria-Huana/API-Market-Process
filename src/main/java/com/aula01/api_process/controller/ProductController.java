package com.aula01.api_process.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/") // mapeia da internet para a aplicação
public class ProductController {

@GetMapping()
    public String hello_Word(){
        return "Olá mundo";
    }
}
