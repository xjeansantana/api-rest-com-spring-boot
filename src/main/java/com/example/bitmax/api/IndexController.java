package com.example.bitmax.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String get() {
        return "Get Spring Boot";
    }

    @GetMapping("/login/{login}/senha/{senha}")
    public String login(@PathVariable("login") String login, @PathVariable("senha") String senha) {
        return " Login " + login + ", senha " + senha;
    }

    @GetMapping ("/releases/{id}")
    public String getReleasesById(@PathVariable("id") Long id) {
        return "Releases By id " + id;
    }

    @GetMapping("/releases/tipo/{tipo}")
    public String getReleasesById(@PathVariable("tipo") String tipo) {
        return "Lista de Releases " + tipo;
    }


}
