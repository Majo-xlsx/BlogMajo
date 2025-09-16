package com.system.Blog.service;

import com.system.Blog.model.Posteo;
import java.util.List;

public interface IposteoService {
    List<Posteo> obtenerTodos();
    Posteo obtenerPorId(Long id);
    void guardarPosteo(Posteo posteo);
    void editarPosteo(Long id, Posteo posteo);
    void eliminarPosteo(Long id);
}