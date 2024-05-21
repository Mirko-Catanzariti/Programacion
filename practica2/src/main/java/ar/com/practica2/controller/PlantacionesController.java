package ar.com.practica2.controller;


import ar.com.practica2.entities.Cultivos;
import ar.com.practica2.entities.Plantaciones;
import ar.com.practica2.iservice.ICultivosService;
import ar.com.practica2.iservice.IPlantacionesService;
import ar.com.practica2.service.CultivosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlantacionesController {
    @Autowired
    IPlantacionesService entityService;

    //Inyeccion
    @Autowired
    ICultivosService cultivosService;

    @GetMapping(path = "/plantaciones")
    public List<Plantaciones> getAll() {
        return entityService.getAll();
    }

    @GetMapping(path = "/plantaciones/{id}")
    public Plantaciones get(@PathVariable Integer id) {
        return entityService.get(id);
    }

    @GetMapping(path = "/plantaciones/search/{expresion}")
    public List<Plantaciones> getListPlantaciones(@PathVariable String expresion) {
        return entityService.findByName(expresion);
    }

    @PostMapping(value = "/plantaciones", consumes = "application/json", produces = "application/json")
    public Plantaciones save(@RequestBody Plantaciones entity) {
        entityService.save(entity);
        return entity;
    }

    @GetMapping(path = "plantaciones/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Plantaciones entity = null;
        try {
            entity = entityService.get(id);
            entityService.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }

    //================================================================================
    //Consulta 1
    @GetMapping(path = "/plantaciones/getallplantaciones/{periodo}")
    public List<Plantaciones> getAllPlantaciones(@PathVariable String periodo) {
        //cambio el parametro - por barra
        return entityService.getAllPlantaciones(periodo.replace("-","/"));
    }

    //============================================================================

    //Consulta 2

    @GetMapping(path = "/plantaciones/getallplantacionesfecha/{dfecha}/{hfecha}")
    public List<Plantaciones> getAllPlantacionesFecha(@PathVariable String dfecha,@PathVariable String hfecha) {
        //convercion de string a date
        LocalDate desde = LocalDate.parse(dfecha);
        LocalDate hasta = LocalDate.parse(hfecha);
        //cambio el parametro - por barra
        return entityService.getAllPlantacionesFecha(desde,hasta);
    }

    //=====================================================================================
    //Consulta 3
    @GetMapping(path = "/plantaciones/getallperiodocultivo/{periodo}/{cultivo}") //esto le paso al postman
    public List<Plantaciones> getListPeriodoCultivo(@PathVariable String periodo,@PathVariable Integer cultivo) {
        Cultivos c = cultivosService.get(cultivo);
        return entityService.getAllPeriodoCultivo(periodo.replace("-", "/"),c);
    }

}
