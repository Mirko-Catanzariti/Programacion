package ar.com.practica2.dao;

import ar.com.practica2.entities.Cultivos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICultivosDao extends JpaRepository <Cultivos, Integer> {
    @Query ("select c from Cultivos c where c.descrip like?1")
    public List<Cultivos> findByDescrip (String name);
}
