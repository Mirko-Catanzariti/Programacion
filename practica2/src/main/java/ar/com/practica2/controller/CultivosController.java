package ar.com.practica2.controller;

import ar.com.practica2.iservice.ICultivosService;
import ar.com.practica2.entities.Cultivos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api")
public class CultivosController {
    @Autowired
    ICultivosService entityService;

    @GetMapping(path = "/cultivos")
    public List<Cultivos> getAll() {return entityService.getAll();}

    @GetMapping(path = "/cultivos/{id}")
    public Cultivos get(@PathVariable Integer id)
    {return entityService.get(id);}

    @GetMapping(path = "/cultivos/search/{expresion}")
    public List<Cultivos> getListCultivos(@PathVariable String expresion)
    {return entityService.findByDescrip(expresion);}

    @PostMapping(value = "/cultivos", consumes = "application/json", produces = "application/json")
    public Cultivos save(@RequestBody Cultivos entity) {
        entityService.save(entity);
        return entity;
    }

    @GetMapping(path = "cultivos/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Cultivos entity = null;
        try {
            entity = entityService.get(id);
            entityService.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }

}
