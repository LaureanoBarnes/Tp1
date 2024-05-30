
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaGestionBiblioteca {

    private static Scanner scan = new Scanner(System.in);
    private static LibroService libroservice = new LibroService();
    private static Biblioteca biblioteca = new Biblioteca(libroservice);


    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            mostrarMenu();
            int opcion = scan.nextInt();
            scan.nextLine(); // Consumir el salto de línea
            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    eliminarLibro();
                    break;
                case 3:
                    buscarLibroPorNombre();
                    break;
                case 4:
                    buscarLibrosPorAutor();
                    break;
                case 5:
                    agregarCliente();
                    break;
                case 6:
                    eliminarCliente();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Agregar un nuevo libro a la biblioteca");
        System.out.println("2. Eliminar un libro de la biblioteca");
        System.out.println("3. Buscar un libro por el nombre");
        System.out.println("4. Buscar todos los libros de un autor");
        System.out.println("5. Agregar un nuevo cliente a la biblioteca");
        System.out.println("6. Eliminar un cliente de la biblioteca");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarLibro() {
        System.out.print("Ingrese el nombre del libro: ");
        String nombre = scan.nextLine();
        System.out.print("Ingrese el nombre del autor: ");
        String nombreAutor = scan.nextLine();
        System.out.print("Ingrese el DNI del autor: ");
        String dniAutor = scan.nextLine();
        System.out.print("Ingrese el género del libro: ");
        String genero = scan.nextLine();

        Persona autor = new Persona(dniAutor, nombreAutor);
        Libro libro = new Libro(nombre, autor, genero);
        biblioteca.getLibroService().agregarLibro(libro);
        System.out.println("Se ha agregado correctamente el libro: " + libro.getNombre());
    }

    private static void eliminarLibro() {
        System.out.print("Ingrese el nombre del libro a eliminar: ");
        String nombre = scan.nextLine();
        biblioteca.getLibroService().eliminarLibro(nombre);
        System.out.println("Libro eliminado exitosamente.");
    }

    private static void buscarLibroPorNombre() {
        System.out.print("Ingrese el nombre del libro a buscar: ");
        String nombre = scan.nextLine();
        Libro libro = biblioteca.getLibroService().buscarLibroPorNombre(nombre);
        if (libro != null) {
            System.out.println("Libro encontrado: " + libro.getNombre() + ", Autor: " + libro.getAutor().getNombre() + ", Género: " + libro.getGenero());
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    private static void buscarLibrosPorAutor() {
        System.out.print("Ingrese el nombre del autor: ");
        String nombreAutor = scan.nextLine();
        List<Libro> libros = biblioteca.getLibroService().buscarLibrosPorAutor(nombreAutor);
        if (libros.isEmpty()) {
            System.out.println("No se encontraron libros para el autor: " + nombreAutor);
        } else {
            System.out.println("Libros encontrados:");
            for (Libro libro : libros) {
                System.out.println(libro.getNombre());
            }
        }
    }

    private static void agregarCliente() {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scan.nextLine();
        System.out.print("Ingrese el DNI del cliente: ");
        String dni = scan.nextLine();

        Persona cliente = new Persona(dni, nombre);
        biblioteca.agregarCliente(cliente);
        System.out.println("Cliente agregado exitosamente.");
    }

    private static void eliminarCliente() {
        System.out.print("Ingrese el DNI del cliente a eliminar: ");
        String dni = scan.nextLine();
        biblioteca.eliminarCliente(dni);
        System.out.println("Cliente eliminado exitosamente.");
    }
}
