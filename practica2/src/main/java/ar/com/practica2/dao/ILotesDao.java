package ar.com.practica2.dao;

import ar.com.practica2.entities.Lotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILotesDao extends JpaRepository <Lotes, Integer>{
    @Query ("select c from Lotes c where c.descrip like?1")
    public List<Lotes> findByDescrip (String name);
}
