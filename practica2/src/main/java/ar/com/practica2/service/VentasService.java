package ar.com.practica2.service;


import ar.com.practica2.dao.IVentasDao;
import ar.com.practica2.entities.Compradores;
import ar.com.practica2.entities.Ventas;
import ar.com.practica2.iservice.IVentasService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Service
public class VentasService implements IVentasService {
    @Autowired
    private IVentasDao entityDao;

    public List<Ventas> getAll() {
        return entityDao.findAll(Sort.by(Sort.Direction.ASC,"fecha"));
    }

    public List<Ventas> findByFecha(Date fecha) {
        return entityDao.findByFecha(fecha);
    }

    // Consulta 4
    public List<Ventas> getAllCompradorfecha(LocalDate dfecha, LocalDate hfecha, Compradores comprador) {
        return entityDao.getAllCompradorfecha(dfecha,hfecha,comprador);
    }
    //Consulta 5
    public double getalltotalventas(LocalDate desdefecha, LocalDate hastafecha, Compradores comprador) {
        return entityDao.getalltotalventas(desdefecha,hastafecha,comprador);
    }

    public Ventas get(String id) {
        return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(Ventas entity) {
        entityDao.save(entity);
    }

    @Transactional
    public String delete(Ventas entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}
