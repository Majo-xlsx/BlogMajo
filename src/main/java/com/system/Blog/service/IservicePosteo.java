package com.system.Blog.service;

import com.system.Blog.model.Posteo;
import java.util.List;

public interface IservicePosteo {
    List<Posteo> obtenerTodos();
    Posteo obtenerPorId(Long id);
    void guardarPosteo(Posteo posteo);
}