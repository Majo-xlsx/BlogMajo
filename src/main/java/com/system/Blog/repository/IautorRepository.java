package com.system.Blog.repository;

import com.system.Blog.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IautorRepository extends JpaRepository<Autor, Long> {
}