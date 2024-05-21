package ar.com.practica2.controller;

import ar.com.practica2.entities.Compradores;
import ar.com.practica2.iservice.ICompradoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CompradoresController {
    @Autowired
    ICompradoresService entityService;

    @GetMapping(path = "/compradores")
    public List<Compradores> getAll() {return entityService.getAll();}

    @GetMapping(path = "/compradores/{id}")
    public Compradores get(@PathVariable Integer id)
    {return entityService.get(id);}

    @GetMapping(path = "/compradores/search/{expresion}")
    public List<Compradores> getListCompradores(@PathVariable String expresion)
    {return entityService.findByName(expresion);}

    @PostMapping(value = "/compradores", consumes = "application/json", produces = "application/json")
    public Compradores save(@RequestBody Compradores entity) {
        entityService.save(entity);
        return entity;
    }

    @GetMapping(path = "compradores/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Compradores entity = null;
        try {
            entity = entityService.get(id);
            entityService.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }

}
