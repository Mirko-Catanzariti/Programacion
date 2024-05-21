package ar.com.practica2.iservice;

import ar.com.practica2.entities.Compradores;

import java.util.List;

public interface ICompradoresService {

    List<Compradores> getAll();

    List<Compradores> findByName(String nombre);

    Compradores get(Integer id);
    void save(Compradores entity);
    String delete(Compradores entity);
}
