package com.system.Blog.controller;

import com.system.Blog.model.Comentario;
import com.system.Blog.service.IcomentarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final IcomentarioService comentarioService;

    public ComentarioController(IcomentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @GetMapping
    public List<Comentario> listaComentarios() {
        return comentarioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Comentario obtenerPorId(@PathVariable Long id) {
        return comentarioService.obtenerPorId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> guardarComentario(@RequestBody Comentario comentario) {
        comentarioService.guardarComentario(comentario);
        return ResponseEntity.ok("Comentario agregado con éxito");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarComentario(@PathVariable Long id, @RequestBody Comentario comentario) {
        comentarioService.editarComentario(id, comentario);
        return ResponseEntity.ok("Comentario editado");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarComentario(@PathVariable Long id) {
        comentarioService.eliminarComentario(id);
        return ResponseEntity.ok("Comentario eliminado");
    }
}