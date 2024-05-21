package ar.com.practica2.dao;

import ar.com.practica2.entities.Cultivos;
import ar.com.practica2.entities.Plantaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface IPlantacionesDao  extends JpaRepository <Plantaciones, Integer> {

    @Query("select c from Plantaciones c where c.periodo like?1")
    public List<Plantaciones> findByName (String nombre);

    // consulta Todas las Plantaciones para un determinado período.
    @Query("select c from Plantaciones c where c.periodo =?1")
    public List<Plantaciones> getAllPlantaciones (String periodo);

    // consulta Todas las Plantaciones entre dos Fechas.

    @Query("select c from Plantaciones c where c.fecha between ?1 and ?2 order by c.fecha" )
    public List<Plantaciones> getAllPlantacionesFecha (LocalDate desdefecha, LocalDate hastafecha);

    // consulta Todas las Plantaciones para un determinado Periodo – Cultivo.

    @Query("select c from Plantaciones c where c.periodo =?1 and c.cultivo =?2")
    public List<Plantaciones> getAllPeriodoCultivo (String periodo, Cultivos cultivo);






}
