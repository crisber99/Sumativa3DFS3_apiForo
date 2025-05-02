package com.bbravo.api_foro.Voto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Votos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdVoto;
    @Column(name = "idRespuesta")
    @NotNull(message = "Debe ingresar un valor")
    private Long idRespuesta;
    @Column(name = "idUsuario")
    @NotNull(message = "Debe ingresar un valor")
    private Long idUsuario;

    public Long getIdVoto(){
        return IdVoto;
    }

    public Long getIdRespuesta(){
        return idRespuesta;
    }

    public Long getIdUsuario(){
        return idUsuario;
    }

    //SET
    public void setIdVoto(Long id){
        this.IdVoto = id;
    }

    public void setIdRespuesta(Long id){
        this.idRespuesta = id;
    }

    public void setIdUsuario(Long id){
        this.idUsuario = id;
    }
}
