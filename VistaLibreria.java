/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.upb.examenanalisis.LibreriaModel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VistaLibreria {

    private Controlador controlador;
    private Scanner scanner;

    public VistaLibreria() {
        scanner = new Scanner(System.in);
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void mostrarMenu() {
        System.out.println("Bienvenido a Libros para Todos");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Ver lista de libros");
        System.out.println("2. Buscar libro por título");
        System.out.println("3. Reservar libro");
        System.out.println("4. Comprar libro");
        System.out.println("5. Agregar nuevo libro");
        System.out.println("6. Devolver libro");
        System.out.println("7. Eliminar libro");
        System.out.println("8. Buscar libro por autor");
        System.out.println("9. Ver informe de ventas");
        System.out.println("10. Recomendaciones de libros");
    }

    public void mostrarListaLibros() {
        System.out.println("Lista de libros disponibles:");
        for (Libro libro : controlador.obtenerListaLibros()) {
            System.out.println(libro);
        }
    }

    public void buscarLibroPorTitulo() {
        System.out.print("Ingrese el título del libro a buscar: ");
        scanner.nextLine(); // Consumir el salto de línea después de la opción del menú
        String titulo = scanner.nextLine();
        Libro libro = controlador.buscarLibroPorTitulo(titulo);
        if (libro != null) {
            System.out.println("Se encontró el libro: ");
            System.out.println(libro);
        } else {
            System.out.println("No se encontró ningún libro con el título ingresado.");
        }
    }

    public void reservarLibro() {
        System.out.print("Ingrese el título del libro a reservar: ");
        scanner.nextLine(); // Consumir el salto de línea después de la opción del menú
        String titulo = scanner.nextLine();
        boolean exito = controlador.reservarLibro(titulo);
        if (exito) {
            System.out.println("Libro reservado exitosamente.");
        } else {
            System.out.println("No se pudo reservar el libro. Verifique la disponibilidad y que el título sea correcto.");
        }
    }

    public void comprarLibro() {
        System.out.print("Ingrese el título del libro a comprar: ");
        scanner.nextLine(); // Consumir el salto de línea después de la opción del menú
        String titulo = scanner.nextLine();
        boolean exito = controlador.comprarLibro(titulo);
        if (exito) {
            System.out.println("Libro comprado exitosamente.");
        } else {
            System.out.println("No se pudo comprar el libro. Verifique la disponibilidad y que el título sea correcto.");
        }
    }

    public void agregarNuevoLibro() {
        System.out.print("Ingrese el título del nuevo libro: ");
        scanner.nextLine(); // Consumir el salto de línea después de la opción del menú
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el nombre del autor del nuevo libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese la categoría del nuevo libro: ");
        String categoria = scanner.nextLine();
        System.out.print("Ingrese la cantidad de copias disponibles del nuevo libro: ");
        int cantidad = ingresarEnteroPositivo();
        controlador.agregarNuevoLibro();
    }
        public void devolverLibro() {
        System.out.print("Ingrese el título del libro a devolver: ");
        scanner.nextLine(); // Consumir el salto de línea después de la opción del menú
        String titulo = scanner.nextLine();
        boolean exito = controlador.devolverLibro(titulo);
        if (exito) {
            System.out.println("Libro devuelto exitosamente.");
        } else {
            System.out.println("No se pudo devolver el libro. Verifique que el título sea correcto y que el libro esté reservado.");
        }
    }

    public void eliminarLibro() {
        System.out.print("Ingrese el título del libro a eliminar: ");
        scanner.nextLine(); // Consumir el salto de línea después de la opción del menú
        String titulo = scanner.nextLine();
        boolean exito = controlador.eliminarLibro(titulo);
        if (exito) {
            System.out.println("Libro eliminado exitosamente.");
        } else {
            System.out.println("No se pudo eliminar el libro. Verifique que el título sea correcto y que el libro no esté reservado.");
        }
    }

    public void buscarLibroPorAutor() {
        System.out.print("Ingrese el nombre del autor a buscar: ");
        scanner.nextLine(); // Consumir el salto de línea después de la opción del menú
        String autor = scanner.nextLine();
        List<Libro> libros = controlador.buscarLibroPorAutor(autor);
        if (libros.isEmpty()) {
            System.out.println("No se encontró ningún libro del autor ingresado.");
        } else {
            System.out.println("Libros encontrados del autor " + autor + ":");
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
    }

    public void verInformeVentas() {
        System.out.println("Informe de ventas:");
        System.out.println("Total de libros vendidos: " + controlador.obtenerTotalLibrosVendidos());
        System.out.println("Total de dinero recaudado: " + controlador.obtenerTotalDineroRecaudado());
    }

    public void mostrarRecomendaciones() {
        System.out.println("Recomendaciones de libros:");
        for (Libro libro : controlador.mostrarRecomendaciones()) {
            System.out.println(libro);
        }
    }

