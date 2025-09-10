package com.system.Blog.controller;

import com.system.Blog.model.Posteo;
import com.system.Blog.service.PosteoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posteos")
public class PosteoController {

    private final PosteoService posteoService;

    public PosteoController(PosteoService posteoService) {
        this.posteoService = posteoService;
    }

    @GetMapping
    public List<Posteo> listaPosteos() {
        return posteoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Posteo obtenerPorId(@PathVariable Long id) {
        return posteoService.obtenerPorId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> guardarPosteo(@RequestBody Posteo posteo) {
        posteoService.guardarPosteo(posteo);
        return ResponseEntity.ok("Posteo agregado con éxito");
    }
}