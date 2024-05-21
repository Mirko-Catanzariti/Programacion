package ar.com.practica2.controller;

import ar.com.practica2.entities.Compradores;
import ar.com.practica2.entities.Cultivos;
import ar.com.practica2.entities.Plantaciones;
import ar.com.practica2.entities.Ventas;
import ar.com.practica2.iservice.ICompradoresService;
import ar.com.practica2.iservice.ICosechasService;
import ar.com.practica2.iservice.IVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/api")
public class VentasController {
    @Autowired
    IVentasService entityService;
    //Inyecccion
    @Autowired
    ICompradoresService compradoresService;

    @GetMapping(path = "/ventas")
    public List<Ventas> getAll() {return entityService.getAll();}

    @GetMapping(path = "/ventas/{id}")
    public Ventas get(@PathVariable String id) {return entityService.get(id);}

    @GetMapping(path = "/ventas/search/{expresion}")
    public List<Ventas> getListGastos(@PathVariable Date expresion) {return entityService.findByFecha(expresion);}

    @PostMapping(value = "/ventas", consumes = "application/json", produces = "application/json")
    public Ventas save(@RequestBody Ventas entity) {
        entityService.save(entity);
        return entity;
    }

    @GetMapping (path = "/ventas/delete/{id}")
    public String delete(@PathVariable String id) {
        Ventas entity = null;
        try {
            entity = entityService.get(id);
            entityService.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }

    //=====================================================================================
    //Consulta 4
    @GetMapping(path = "/ventas/getallcompradorfecha/{dfecha}/{hfecha}/{comprador}")
    public List<Ventas> getListCompradorfecha(@PathVariable String dfecha, @PathVariable String hfecha, @PathVariable Integer comprador) {
        // Conversion de String a date
        LocalDate desde = LocalDate.parse(dfecha);
        LocalDate hasta = LocalDate.parse(hfecha);
        Compradores c = compradoresService.get(comprador);
        //cambio el parametro - por barra
        return entityService.getAllCompradorfecha(desde,hasta,c);
    }

    //Consulta 5
    @GetMapping(path = "/ventas/getalltotalventas/{dfecha}/{hfecha}/{comprador}")
    public double getdoubleventas(@PathVariable String dfecha, @PathVariable String hfecha, @PathVariable Integer comprador) {
        // Conversion de String a date
        LocalDate desde = LocalDate.parse(dfecha);
        LocalDate hasta = LocalDate.parse(hfecha);
        Compradores c = compradoresService.get(comprador);
        return entityService.getalltotalventas(desde, hasta, c);
    }
}
