package ar.com.practica2.iservice;

import ar.com.practica2.entities.Cultivos;

import java.util.List;

public interface ICultivosService {

    List<Cultivos> getAll();

    List<Cultivos> findByDescrip(String descrip);

    Cultivos get(Integer id);
    void save(Cultivos entity);
    String delete(Cultivos entity);
}
