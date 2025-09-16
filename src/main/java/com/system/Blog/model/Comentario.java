package com.system.Blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texto;
    private String fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "posteo_id")
    @JsonBackReference
    private Posteo posteo;

    public Comentario() {}
    public Comentario(Long id, String texto, String fechaCreacion) {
        this.id = id; this.texto = texto; this.fechaCreacion = fechaCreacion;
    }

    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getTexto() { return texto; } public void setTexto(String texto) { this.texto = texto; }
    public String getFechaCreacion() { return fechaCreacion; } public void setFechaCreacion(String fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    public Posteo getPosteo() { return posteo; } public void setPosteo(Posteo posteo) { this.posteo = posteo; }
}