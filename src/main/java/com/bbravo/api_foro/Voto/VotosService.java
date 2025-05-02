package com.bbravo.api_foro.Voto;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VotosService {

private final VotosRepository votoRepo;

    public Votos creaVoto(Votos rol){
        return votoRepo.save(rol);
    }

    public List<Votos> getAllVoto(){
        return votoRepo.findAll();
    }

    public Optional<Votos> getVoto(Long id){
        return votoRepo.findById(id);
    }

    public Votos updVoto(Long id, Votos rol){
        if(votoRepo.existsById(id)){
            rol.setIdVoto(id);
            return votoRepo.save(rol);
        }
        else return null;
    }

    public void delVoto(long id){
        votoRepo.deleteById(id);
    }
}
