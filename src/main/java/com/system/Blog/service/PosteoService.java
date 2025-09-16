package com.system.Blog.service;

import com.system.Blog.model.Autor;
import com.system.Blog.model.Posteo;
import com.system.Blog.repository.IautorRepository;
import com.system.Blog.repository.IposteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosteoService implements IposteoService {

    private final IposteoRepository posteoRepository;
    private final IautorRepository iautorRepository;

    @Autowired
    public PosteoService(IposteoRepository posteoRepository, IautorRepository iautorRepository) {
        this.posteoRepository = posteoRepository;
        this.iautorRepository = iautorRepository;
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
        if (posteo.getAutor() != null && posteo.getAutor().getId() != null) {
            Autor autor = iautorRepository.findById(posteo.getAutor().getId()).orElse(null);
            posteo.setAutor(autor);
        }
        posteoRepository.save(posteo);
    }

    @Override
    public void editarPosteo(Long id, Posteo posteo) {
        Optional<Posteo> existe = posteoRepository.findById(id);
        if (existe.isPresent()) {
            Posteo actual = existe.get();
            actual.setTitulo(posteo.getTitulo());
            if (posteo.getAutor() != null && posteo.getAutor().getId() != null) {
                Autor autor = iautorRepository.findById(posteo.getAutor().getId()).orElse(null);
                actual.setAutor(autor);
            }
            posteoRepository.save(actual);
        }
    }

    @Override
    public void eliminarPosteo(Long id) {
        posteoRepository.deleteById(id);
    }
}