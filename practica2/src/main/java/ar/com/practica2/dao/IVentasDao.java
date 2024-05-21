package ar.com.practica2.dao;

import ar.com.practica2.entities.Compradores;
import ar.com.practica2.entities.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Repository
public interface IVentasDao extends JpaRepository <Ventas, String> {
    @Query("select c from Ventas c where c.fecha = ?1")
    public List<Ventas> findByFecha(Date fecha);

    //Todas las Ventas Realizadas por un Determinado Comprador entre dos Fechas.
    @Query("select c from Ventas c where c.fecha between ?1 and ?2 and c.comprador = ?3 order by c.fecha" )
    public List<Ventas> getAllCompradorfecha (LocalDate desdefecha, LocalDate hastafecha, Compradores comprador);

    //El Total de Ventas Realizado por un Comprador entre dos Fechas.

    @Query("select sum(c.precio) from Ventas c where c.fecha between ?1 and ?2 and c.comprador = ?3 order by c.fecha" )
    public double getalltotalventas (LocalDate desdefecha, LocalDate hastafecha, Compradores comprador);
}
