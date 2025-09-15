package com.system.Blog.service;

import com.system.Blog.model.Posteo;
import com.system.Blog.repository.IposteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PosteoService implements IservicePosteo {

    private final IposteoRepository posteoRepository;

    @Autowired
    public PosteoService(IposteoRepository posteoRepository) {
        this.posteoRepository = posteoRepository;
    }

    @Override
    public List<Posteo> obtenerTodos() {
        return posteoRepository.findAll();
    }

    @Override
    public Posteo obtenerPorId(Long id) {
        return posteoRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarPosteo(Posteo posteo) {
        posteoRepository.save(posteo);
    }
    @Override
    public void editarPosteo(Long id, Posteo posteo) {
        Optional<Posteo> existe = posteoRepository.findById(id);
        if(existe.isPresent()){
            existe.get().setTitulo(posteo.getTitulo());
            existe.get().setAutor(posteo.getAutor());
        }
    }
    @Override
    public void eliminarPosteo(Long id) {
        posteoRepository.deleteById(id);
    }
}