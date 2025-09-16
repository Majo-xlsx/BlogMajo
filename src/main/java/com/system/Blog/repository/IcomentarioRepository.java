package com.system.Blog.repository;

import com.system.Blog.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IcomentarioRepository extends JpaRepository<Comentario, Long> {
}