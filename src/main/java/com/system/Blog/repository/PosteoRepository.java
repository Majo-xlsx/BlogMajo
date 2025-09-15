//package com.system.Blog.repository;
//
//import com.system.Blog.model.Posteo;
//import org.springframework.stereotype.Repository;
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class PosteoRepository implements IposteoRepository {
//
//    private List<Posteo> posteos = new ArrayList<>();
//
//    public PosteoRepository() {
//        posteos.add(new Posteo(1L, "Aventuras en Papitas", "Generation"));
//        posteos.add(new Posteo(2L, "¿Cómo colarse en TransMilenio?", "Alcaldía Mayor de Bogotá"));
//    }
//
//    @Override
//    public List<Posteo> findAll() {
//        return posteos;
//    }
//
//    @Override
//    public Posteo findById(Long id) {
//        for (Posteo posteo : posteos) {
//            if (posteo.getId().equals(id)) {
//                return posteo;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void save(Posteo posteo) {
//        posteos.add(posteo);
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        posteos.removeIf(posteo -> posteo.getId().equals(id));
//    }
//}