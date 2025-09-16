package com.system.Blog.service;

import com.system.Blog.model.Autor;
import java.util.List;

public interface IautorService {
    List<Autor> obtenerTodos();
    Autor obtenerPorId(Long id);
    void guardarAutor(Autor autor);
    void editarAutor(Long id, Autor autor);
    void eliminarAutor(Long id);
}