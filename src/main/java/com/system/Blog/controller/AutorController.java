package com.system.Blog.controller;

import com.system.Blog.model.Autor;
import com.system.Blog.service.IautorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final IautorService autorService;

    public AutorController(IautorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> listaAutores() {
        return autorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Autor obtenerPorId(@PathVariable Long id) {
        return autorService.obtenerPorId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> guardarAutor(@RequestBody Autor autor) {
        autorService.guardarAutor(autor);
        return ResponseEntity.ok("Autor agregado con éxito");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarAutor(@PathVariable Long id, @RequestBody Autor autor) {
        autorService.editarAutor(id, autor);
        return ResponseEntity.ok("Autor editado");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarAutor(@PathVariable Long id) {
        autorService.eliminarAutor(id);
        return ResponseEntity.ok("Autor eliminado");
    }
}