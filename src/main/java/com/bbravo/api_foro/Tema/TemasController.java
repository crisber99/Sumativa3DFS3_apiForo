package com.bbravo.api_foro.Tema;

import java.util.List;
import java.util.Optional;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/tema")
@RequiredArgsConstructor
public class TemasController {

    private final TemasService TemaService;
    private static final Logger log = LoggerFactory.getLogger(TemasController.class);

    @PostMapping    
    public void addUser(@RequestBody Temas user) {
        TemaService.creaTema(user);
    }
    
    @GetMapping("/{id}")
    public EntityModel<Temas> getTemaByid(@PathVariable Long id) {
        log.info("getTemaByid");
        Optional<Temas> tema = TemaService.getTema(id);
        if(tema.isPresent()){
            return EntityModel.of(tema.get(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getTemaByid(id)).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllTema()).withRel("all-temas"));
        }
        else{
            throw new api_foroNotFoundException("Temas no funciona con el id: " + id);
        }   
    }
    
    @GetMapping
    public List<Temas> getAllTema() {
        return TemaService.getAllTema();
    }

    @PutMapping("/{id}")
    public Temas updTema(@PathVariable Long id, @RequestBody Temas user) {
        return TemaService.updTema(id, user);
    }

    @DeleteMapping("/{id}")
    public void delTema(@PathVariable Long id){
        TemaService.delTema(id);
    }
}
