package ar.com.practica2.iservice;

import ar.com.practica2.entities.Compradores;
import ar.com.practica2.entities.Plantaciones;
import ar.com.practica2.entities.Ventas;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IVentasService {
    List<Ventas> getAll();
    List<Ventas> findByFecha(Date fecha);

    //Consulta
    List<Ventas> getAllCompradorfecha (LocalDate dfecha, LocalDate hfecha, Compradores comprador);

    //Consulta
    double getalltotalventas (LocalDate desdefecha, LocalDate hastafecha, Compradores comprador);
    Ventas get(String id);
    void save(Ventas entity);
    String delete(Ventas entity);
}
