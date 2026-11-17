package mx.edu.utez.cine.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pelicula;
    private Long precioEntrada;
    private int capacidadSala;

    public Cine(Long id, String pelicula, Long precioEntrada, int capacidadSala) {
        this.id = id;
        this.pelicula = pelicula;
        this.precioEntrada = precioEntrada;
        this.capacidadSala = capacidadSala;
    }

    public Cine() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public Long getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(Long precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public int getCapacidadSala() {
        return capacidadSala;
    }

    public void setCapacidadSala(int capacidadSala) {
        this.capacidadSala = capacidadSala;
    }
}
