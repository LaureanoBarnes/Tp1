import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private LibroService libroService;
    private List<Persona> clientes;

    public Biblioteca(LibroService libroService) {
        this.libroService = libroService;
        this.clientes = new ArrayList<>();
    }

    // Métodos para gestionar clientes
    public void agregarCliente(Persona cliente) {
        clientes.add(cliente);
    }

    public void eliminarCliente(String dni) {
        Persona clienteAEliminar = null;
        for (Persona cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                clienteAEliminar = cliente;
                break;
            }
        }
        if (clienteAEliminar != null) {
            clientes.remove(clienteAEliminar);
        }
    }

    public List<Persona> getClientes() {
        return clientes;
    }

    public LibroService getLibroService() {
        return libroService;
    }
}
