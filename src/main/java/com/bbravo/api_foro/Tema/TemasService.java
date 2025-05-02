package com.bbravo.api_foro.Tema;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TemasService {

private final TemasRepository temaRepo;

    public Temas creaTema(Temas tema){
        return temaRepo.save(tema);
    }

    public List<Temas> getAllTema(){
        return temaRepo.findAll();
    }

    public Optional<Temas> getTema(Long id){
        return temaRepo.findById(id);
    }

    public Temas updTema(Long id, Temas tema){
        if(temaRepo.existsById(id)){
            tema.setIdTema(id);
            return temaRepo.save(tema);
        }
        else return null;
    }

    public void delTema(long id){
        temaRepo.deleteById(id);
    }
}
