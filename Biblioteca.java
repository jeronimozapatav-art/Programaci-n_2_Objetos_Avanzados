import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private int idBiblioteca;
    private String nombre;
    private String direccion;
    private String telefono;
    private List<Libro> libros;
    private List<Usuario> usuarios;

    public Biblioteca(int idBiblioteca, String nombre, String direccion, String telefono) {
        this.idBiblioteca = idBiblioteca;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        this.libros.add(libro);
        System.out.println("Libro '" + libro.getTitulo() + "' agregado a la biblioteca.");
    }

    public void registrarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        System.out.println("Usuario '" + usuario.getNombre() + "' registrado en la biblioteca.");
    }

    public List<Libro> listarLibros() {
        return this.libros;
    }

    // Getters y Setters
    public int getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(int idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}