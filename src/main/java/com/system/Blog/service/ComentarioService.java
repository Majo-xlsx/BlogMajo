package com.system.Blog.service;

import com.system.Blog.model.Comentario;
import com.system.Blog.model.Posteo;
import com.system.Blog.repository.IcomentarioRepository;
import com.system.Blog.repository.IposteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService implements IcomentarioService {

    private final IcomentarioRepository icomentarioRepository;
    private final IposteoRepository iposteoRepository;

    @Autowired
    public ComentarioService(IcomentarioRepository icomentarioRepository, IposteoRepository iposteoRepository) {
        this.icomentarioRepository = icomentarioRepository;
        this.iposteoRepository = iposteoRepository;
    }

    @Override
    public List<Comentario> obtenerTodos() {
        return icomentarioRepository.findAll();
    }

    @Override
    public Comentario obtenerPorId(Long id) {
        return icomentarioRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarComentario(Comentario comentario) {
        if (comentario.getPosteo() != null && comentario.getPosteo().getId() != null) {
            Posteo p = iposteoRepository.findById(comentario.getPosteo().getId()).orElse(null);
            comentario.setPosteo(p);
        }
        icomentarioRepository.save(comentario);
    }

    @Override
    public void editarComentario(Long id, Comentario comentario) {
        Optional<Comentario> existe = icomentarioRepository.findById(id);
        if (existe.isPresent()) {
            Comentario actual = existe.get();
            actual.setTexto(comentario.getTexto());
            actual.setFechaCreacion(comentario.getFechaCreacion());
            icomentarioRepository.save(actual);
        }
    }

    @Override
    public void eliminarComentario(Long id) {
        icomentarioRepository.deleteById(id);
    }
}