package com.bbravo.api_foro.Tema;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Temas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdTema;
    @Column(name = "titulo")
    @NotNull(message = "Campo en null, debe ingresar un titulo.")
    @NotEmpty(message = "Campo vacío, debe ingresar un titulo.")
    private String titulo;
    @Column(name = "contenido")
    @NotNull(message = "Campo en null, debe ingresar un contenido.")
    @NotEmpty(message = "Campo vacío, debe ingresar un contenido.")
    private String contenido;
    @Column(name = "idCategoria")
    @NotNull(message = "Campo en null, debe ingresar un id categoria.")
    private Long idCategoria;

    public Long getIdTema(){
        return IdTema;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getContenido(){
        return contenido;
    }

    public Long getIdCategoria(){
        return idCategoria;
    }

    //SET
    public void setIdTema(Long id){
        this.IdTema = id;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setContendo(String contenido){
        this.contenido = contenido;
    }

    public void setIdCategoria(Long idCategoria){
        this.idCategoria = idCategoria;
    }
}
