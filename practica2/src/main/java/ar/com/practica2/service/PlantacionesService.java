package ar.com.practica2.service;

import ar.com.practica2.dao.IPlantacionesDao;
import ar.com.practica2.entities.Cultivos;
import ar.com.practica2.entities.Plantaciones;
import ar.com.practica2.iservice.IPlantacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class PlantacionesService implements IPlantacionesService {

    @Autowired
    public IPlantacionesDao entityDao;

    public List<Plantaciones> getAll() {return entityDao.findAll(Sort.by(Sort.Direction.ASC, "nombre"));}

    public List<Plantaciones> findByName(String nombre) { return entityDao.findByName("%" + nombre + "%");}


    //Consulta 1
    public List<Plantaciones> getAllPlantaciones(String periodo) {
       return entityDao.getAllPlantaciones(periodo) ;
    }

    //consulta 2
    public List<Plantaciones> getAllPlantacionesFecha(LocalDate dfecha, LocalDate hfecha) {
        return entityDao.getAllPlantacionesFecha(dfecha,hfecha);
    }


    // consulta 3
    public List<Plantaciones> getAllPeriodoCultivo(String periodo, Cultivos cultivo) {
        return entityDao.getAllPeriodoCultivo(periodo,cultivo);
    }


    public Plantaciones get(Integer id) { return entityDao.findById(id).orElse(null);}

    @Transactional
    public void save(Plantaciones entity) {
        entityDao.save(entity);

    }
    @Transactional
    public String delete(Plantaciones entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }

}
