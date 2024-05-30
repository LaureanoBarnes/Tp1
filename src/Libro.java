public class Libro {
    private String nombre;
    private Persona autor;
    private String genero;

    public Libro() {
    }

    public Libro(String nombre, Persona autor, String genero) {
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}