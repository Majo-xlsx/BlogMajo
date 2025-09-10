package com.system.Blog.repository;

import com.system.Blog.model.Posteo;
import java.util.List;

public interface IposteoRepository {
    List<Posteo> findAll();
    Posteo findById(Long id);
    void save(Posteo posteo);
}