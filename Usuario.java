import java.util.ArrayList;
import java.util.List;

public class Usuario {
    // Atributos encapsulados
    private String idUsuario;
    private String nombre;
    private String correo;
    
    // Lista para guardar los libros que el usuario tiene prestados (Opcional, pero muy recomendado)
    private List<Libro> librosPrestados; 

    // Constructor
    public Usuario(String idUsuario, String nombre, String correo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.librosPrestados = new ArrayList<>(); // Inicializamos la lista vacía
    }

    // Getters y Setters
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    // Método para agregar un libro a los préstamos del usuario
    public void agregarLibroPrestado(Libro libro) {
        this.librosPrestados.add(libro);
    }

    // Método para devolver un libro
    public void devolverLibro(Libro libro) {
        this.librosPrestados.remove(libro);
    }

    @Override
    public String toString() {
        return "Usuario [ID=" + idUsuario + ", Nombre=" + nombre + ", Correo=" + correo + "]";
    }
}
