package ar.com.practica2.service;

import ar.com.practica2.dao.ILotesDao;
import ar.com.practica2.iservice.ILotesService;
import ar.com.practica2.entities.Lotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LotesService implements ILotesService {


    @Autowired
    private ILotesDao entityDao;

    public List<Lotes> getAll() {
        return entityDao.findAll(Sort.by(Sort.Direction.ASC, "descrip"));
    }

    public List<Lotes> findByDescrip(String descrip) {
        return entityDao.findByDescrip("%" + descrip + "%");
    }

    public Lotes get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(Lotes entity) {
        entityDao.save(entity);

    }

    @Transactional
    public String delete(Lotes entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}
