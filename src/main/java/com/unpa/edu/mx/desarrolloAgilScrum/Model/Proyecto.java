package com.unpa.edu.mx.desarrolloAgilScrum.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Relación muchos a uno con Usuario (Product Owner)
    @ManyToOne
    @JoinColumn(name = "product_owner_id")
    private Usuario productOwner;

    // Relación uno a muchos con HistoriaUsuario
    @OneToMany(mappedBy = "proyecto")
    private List<HistoriaUsuario> historiasUsuario;

    // Otros atributos y relaciones

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(Usuario productOwner) {
        this.productOwner = productOwner;
    }

    public List<HistoriaUsuario> getHistoriasUsuario() {
        return historiasUsuario;
    }

    public void setHistoriasUsuario(List<HistoriaUsuario> historiasUsuario) {
        this.historiasUsuario = historiasUsuario;
    }
}
