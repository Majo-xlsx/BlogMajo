package com.system.Blog.service;

import com.system.Blog.model.Autor;
import com.system.Blog.repository.IautorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService implements IautorService {

    private final IautorRepository iautorRepository;

    @Autowired
    public AutorService(IautorRepository iautorRepository) {
        this.iautorRepository = iautorRepository;
    }

    @Override
    public List<Autor> obtenerTodos() {
        return iautorRepository.findAll();
    }

    @Override
    public Autor obtenerPorId(Long id) {
        return iautorRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarAutor(Autor autor) {
        iautorRepository.save(autor);
    }

    @Override
    public void editarAutor(Long id, Autor autor) {
        Optional<Autor> existe = iautorRepository.findById(id);
        if (existe.isPresent()) {
            Autor actual = existe.get();
            actual.setNombre(autor.getNombre());
            actual.setEmail(autor.getEmail());
            iautorRepository.save(actual);
        }
    }

    @Override
    public void eliminarAutor(Long id) {
        iautorRepository.deleteById(id);
    }
}