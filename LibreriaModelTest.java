/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import co.edu.upb.examenanalisis.LibreriaModel.LibreriaModel;
import co.edu.upb.examenanalisis.LibreriaModel.Libro;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


    
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class LibreriaModelTest {

    @Test
    public void agregarLibro() {
        LibreriaModel libreria = new LibreriaModel();
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", "Novela", 5);
        libreria.agregarLibro(libro1);
        List<Libro> libros = libreria.obtenerLibros();
        assertTrue(libros.contains(libro1));
    }

    @Test
    public void eliminarLibro() {
        LibreriaModel libreria = new LibreriaModel();
        Libro libro2 = new Libro("La ciudad y los perros", "Mario Vargas Llosa", "Novela", 3);
        libreria.agregarLibro(libro2);
        libreria.eliminarLibro(libro2);
        List<Libro> libros = libreria.obtenerLibros();
        assertFalse(libros.contains(libro2));
    }

    @Test
    public void buscarLibrosPorTitulo() {
        LibreriaModel libreria = new LibreriaModel();
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", "Novela", 5);
        Libro libro2 = new Libro("La ciudad y los perros", "Mario Vargas Llosa", "Novela", 3);
        libreria.agregarLibro(libro1);
        libreria.agregarLibro(libro2);
        List<Libro> libros = libreria.buscarLibrosPorTitulo("Quijote");
        assertTrue(libros.contains(libro1));
        assertFalse(libros.contains(libro2));
    }

    @Test
    public void buscarLibrosPorAutor() {
        LibreriaModel libreria = new LibreriaModel();
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", "Novela", 5);
        Libro libro2 = new Libro("La ciudad y los perros", "Mario Vargas Llosa", "Novela", 3);
        libreria.agregarLibro(libro1);
        libreria.agregarLibro(libro2);
        List<Libro> libros = libreria.buscarLibrosPorAutor("Zorrilla");
        assertTrue(libros.contains(libro2));
        assertFalse(libros.contains(libro1));
    }

    @Test
    public void obtenerLibrosDisponibles() {
        LibreriaModel libreria = new LibreriaModel();
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", "Novela", 5);
        Libro libro2 = new Libro("La ciudad y los perros", "Mario Vargas Llosa", "Novela", 3);
        libreria.agregarLibro(libro1);
        libreria.agregarLibro(libro2);
        List<Libro> libros = libreria.obtenerLibrosDisponibles();
        assertTrue(libros.contains(libro2));
        assertFalse(libros.contains(libro1));
    }

  



public void testComprarLibro() {
        libreria.agregarLibro(libro1);
        int disponibilidadAntes = libro1.getDisponibilidad();
        libreria.comprarLibro(libro1);
        int disponibilidadDespues = libro1.getDisponibilidad();
        assertEquals(disponibilidadAntes - 1, disponibilidadDespues);
    }

    @Test
    public void testDevolverLibro() {
        libreria.agregarLibro(libro1);
        int disponibilidadAntes = libro1.getDisponibilidad();
        libreria.devolverLibro(libro1);
        int disponibilidadDespues = libro1.getDisponibilidad();
        assertEquals(disponibilidadAntes + 1, disponibilidadDespues);
    }

    @Test
    public void testObtenerLibros() {
        libreria.agregarLibro(libro1);
        libreria.agregarLibro(libro2);
        List<Libro> libros = libreria.obtenerLibros();
        assertEquals(2, libros.size());
        assertTrue(libros.contains(libro1));
        assertTrue(libros.contains(libro2));
    }
}