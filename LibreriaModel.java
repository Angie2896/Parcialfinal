/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.upb.examenanalisis.LibreriaModel;

import java.util.ArrayList;
import java.util.List;

public class LibreriaModel {
    private List<Libro> libros;

    public LibreriaModel() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void eliminarLibro(Libro libro) {
        libros.remove(libro);
    }

    public List<Libro> buscarLibrosPorTitulo(String titulo) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getTitulo().contains(titulo)) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public List<Libro> buscarLibrosPorAutor(String autor) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().contains(autor)) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public List<Libro> obtenerLibrosDisponibles() {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getDisponibilidad() > 0) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public void reservarLibro(Libro libro) {
        int disponibilidad = libro.getDisponibilidad();
        if (disponibilidad > 0) {
            libro.setDisponibilidad(disponibilidad - 1);
        }
    }

    public void comprarLibro(Libro libro) {
        int disponibilidad = libro.getDisponibilidad();
        if (disponibilidad > 0) {
            libro.setDisponibilidad(disponibilidad - 1);
        }
    }

    public void devolverLibro(Libro libro) {
        int disponibilidad = libro.getDisponibilidad();
        libro.setDisponibilidad(disponibilidad + 1);
    }

    public List<Libro> obtenerLibros() {
        return libros;
    }
}
