package com.system.Blog.service;

import com.system.Blog.model.Comentario;
import java.util.List;

public interface IcomentarioService {
    List<Comentario> obtenerTodos();
    Comentario obtenerPorId(Long id);
    void guardarComentario(Comentario comentario);
    void editarComentario(Long id, Comentario comentario);
    void eliminarComentario(Long id);
}