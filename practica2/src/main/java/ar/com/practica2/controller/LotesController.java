package ar.com.practica2.controller;


import ar.com.practica2.iservice.ILotesService;
import ar.com.practica2.entities.Lotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api")
public class LotesController {
    @Autowired
    ILotesService entityService;

    @GetMapping(path = "/lotes")
    public List<Lotes> getAll() {return entityService.getAll();}

    @GetMapping(path = "/lotes/{id}")
    public Lotes get(@PathVariable Integer id)
    {return entityService.get(id);}

    @GetMapping(path = "/Lotes/search/{expresion}")
    public List<Lotes> getListLotes(@PathVariable String expresion)
    {return entityService.findByDescrip(expresion);}

    @PostMapping(value = "/lotes", consumes = "application/json", produces = "application/json")
    public Lotes save(@RequestBody Lotes entity) {
        entityService.save(entity);
        return entity;
    }

    @GetMapping(path = "lotes/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Lotes entity = null;
        try {
            entity = entityService.get(id);
            entityService.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }

}
