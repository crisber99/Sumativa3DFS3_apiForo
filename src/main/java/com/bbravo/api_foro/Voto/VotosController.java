package com.bbravo.api_foro.Voto;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbravo.api_foro.Exception.api_foroNotFoundException;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/voto")
@RequiredArgsConstructor
public class VotosController {

    private final VotosService votoService;
    private static final Logger log = LoggerFactory.getLogger(VotosController.class);

    @PostMapping    
    public void addUser(@RequestBody Votos user) {
        votoService.creaVoto(user);
    }
    
    @GetMapping("/{id}")
    public EntityModel<Votos> getVotoByid(@PathVariable Long id) {
        log.info("getVotoByid");
        Optional<Votos> voto = votoService.getVoto(id);
        if(voto.isPresent()){
            return EntityModel.of(voto.get(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getVotoByid(id)).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllVoto()).withRel("all-votos"));
        }
        else{
            throw new api_foroNotFoundException("Votos no funciona con el id: " + id);
        }      
    }
    
    @GetMapping
    public List<Votos> getAllVoto() {
        return votoService.getAllVoto();
    }

    @PutMapping("/{id}")
    public Votos updVotoes(@PathVariable Long id, @RequestBody Votos user) {
        return votoService.updVoto(id, user);
    }

    @DeleteMapping("/{id}")
    public void delVoto(@PathVariable Long id){
        votoService.delVoto(id);
    }
}
