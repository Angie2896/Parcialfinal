/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.upb.examenanalisis.LibreriaModel;

import java.util.List;
import java.util.Scanner;

import java.util.List;

import java.util.List;

public class Controlador {
    private Libreria libreria;
    private VistaLibreria vista;
    private Scanner scanner;

    public Controlador() {
        this.libreria = new Libreria();
        this.vista = new VistaLibreria();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean terminar = false;

        while (!terminar) {
            vista.mostrarMenu();
            int opcion = vista.leerOpcion();

            switch (opcion) {
                case 1:
                    mostrarListaLibros();
                    break;
                case 2:
                    buscarLibroPorTitulo();
                    break;
                case 3:
                    reservarLibro();
                    break;
                case 4:
                    comprarLibro();
                    break;
                case 5:
                    agregarNuevoLibro();
                    break;
                case 6:
                    devolverLibro();
                    break;
                case 7:
                    eliminarLibro();
                    break;
                case 8:
                    buscarLibroPorAutor();
                    break;
                case 9:
                    mostrarInformeVentas();
                    break;
                case 10:
                    mostrarRecomendaciones();
                    break;
                case 0:
                    terminar = true;
                    break;
                default:
                    vista.mostrarMensajeError("Opción inválida");
                    break;
            }
        }

        scanner.close();
    }

    private void mostrarListaLibros() {
        List<Libro> libros = libreria.getLibros();
        vista.mostrarListaLibros(libros);
    }

    private void buscarLibroPorTitulo() {
        vista.buscarLibroPorTitulo();
        String titulo = scanner.nextLine();

        Libro libroEncontrado = libreria.buscarLibroPorTitulo(titulo);

        if (libroEncontrado == null) {
            vista.mostrarMensajeError("No se encontró ningún libro con ese título.");
        } else {
            vista.mostrarLibro(libroEncontrado);
        }
    }

    private void reservarLibro() {
        vista.reservarLibro();
        String idLibro = scanner.nextLine();

        if (libreria.reservarLibro(idLibro)) {
            vista.mostrarMensajeLibroReservado();
        } else {
            vista.mostrarMensajeError("No se pudo reservar el libro. Verifique el ID del libro e intente nuevamente.");
        }
    }

    private void comprarLibro() {
        vista.comprarLibro();
        String idLibro = scanner.nextLine();

        if (libreria.comprarLibro(idLibro)) {
            vista.mostrarMensajeCompraExitosa();
        } else {
            vista.mostrarMensajeError("No se pudo comprar el libro. Verifique el ID del libro e intente nuevamente.");
        }
    }

    private void agregarNuevoLibro() {
        vista.mostrarMenuAgregarNuevoLibro();
        String titulo = scanner.nextLine();
        String autor = scanner.nextLine();
        String categoria = scanner.nextLine();
        int disponibilidad = vista.leerDisponibilidad();

        Libro nuevoLibro = new Libro(titulo, autor, categoria, disponibilidad);
        libreria.agregarLibro(nuevoLibro);
        vista.mostrarMensajeLibroAgregado();
    }

    private void devolverLibro() {
        vista.devolverLibro();
        String idLibro = scanner.nextLine();

        if (libreria.devolverLibro(idLibro



private void eliminarLibro() {
    vista.eliminarLibro();
    String idLibro = scanner.nextLine();

    if (libreria.eliminarLibro(idLibro)) {
        vista.mostrarMensajeLibroEliminado();
    } else {
        vista.mostrarMensajeError("No se pudo eliminar el libro. Verifique el ID del libro e intente nuevamente.");
    }
}

private void buscarLibroPorAutor() {
    vista.buscarLibroPorAutor();
    String autor = scanner.nextLine();

    List<Libro> librosEncontrados = libreria.buscarLibrosPorAutor(autor);

    if (librosEncontrados.isEmpty()) {
        vista.mostrarMensajeError("No se encontró ningún libro con ese autor.");
    } else {
        vista.mostrarLibros(librosEncontrados);
    }
}

private void mostrarInformeVentas() {
    vista.mostrarInformeVentas(libreria.getVentas());
}

private void mostrarRecomendaciones() {
    vista.mostrarRecomendaciones(libreria.getLibros());
}
}