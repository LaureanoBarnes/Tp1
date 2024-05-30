import java.util.ArrayList;
import java.util.List;

public class LibroService {
    private List<Libro> libros;

    public LibroService() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void eliminarLibro(String nombre) {
        Libro libroAEliminar = null;
        for (Libro libro : libros) {
            if (libro.getNombre().equals(nombre)) {
                libroAEliminar = libro;
                break;
            }
        }
        if (libroAEliminar != null) {
            libros.remove(libroAEliminar);
        }
    }

    public Libro buscarLibroPorNombre(String nombre) {
        for (Libro libro : libros) {
            if (libro.getNombre().equals(nombre)) {
                return libro;
            }
        }
        return null;
    }

    public List<Libro> buscarLibrosPorAutor(String nombreAutor) {
        List<Libro> librosAutor = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().getNombre().equals(nombreAutor)) {
                librosAutor.add(libro);
            }
        }
        return librosAutor;
    }

    public List<Libro> getLibros() {
        return libros;
    }
}
