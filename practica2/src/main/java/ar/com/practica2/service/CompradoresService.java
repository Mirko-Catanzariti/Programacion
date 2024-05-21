package ar.com.practica2.service;

import ar.com.practica2.dao.ICompradoresDao;
import ar.com.practica2.iservice.ICompradoresService;
import ar.com.practica2.entities.Compradores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CompradoresService implements ICompradoresService {

    @Autowired
    public ICompradoresDao entityDao;

    public List<Compradores> getAll() {
        return entityDao.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
    }

    public List<Compradores> findByName(String nombre) {
        return entityDao.findByName("%" + nombre + "%");
    }

    public Compradores get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(Compradores entity) {
        entityDao.save(entity);

    }

    @Transactional
    public String delete(Compradores entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}
