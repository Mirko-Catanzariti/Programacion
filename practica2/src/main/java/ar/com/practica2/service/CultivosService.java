package ar.com.practica2.service;

import ar.com.practica2.dao.ICultivosDao;
import ar.com.practica2.iservice.ICultivosService;
import ar.com.practica2.entities.Cultivos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CultivosService implements ICultivosService {

    @Autowired
    private ICultivosDao entityDao;


    public List<Cultivos> getAll() {
        return entityDao.findAll(Sort.by(Sort.Direction.ASC, "descrip"));
    }



    public List<Cultivos> findByDescrip(String descrip) {
        return entityDao.findByDescrip("%" + descrip + "%");
    }

    public Cultivos get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(Cultivos entity) {
        entityDao.save(entity);
    }

    @Transactional
    public String delete(Cultivos entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}
