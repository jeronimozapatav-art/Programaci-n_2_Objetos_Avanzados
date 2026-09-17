import java.util.ArrayList;
import java.util.List;

public abstract class Libro {

    private String isbn;
    private String titulo;
    private int anioPublicado;
    private EstadoLibro estado;
    private Categoria categoria;

    private static List<Libro> catalogo = new ArrayList<>();

    public Libro(String isbn, String titulo, int anioPublicado,
                 EstadoLibro estado, Categoria categoria) {

        this.isbn = isbn;
        this.titulo = titulo;
        this.anioPublicado = anioPublicado;
        this.estado = estado;
        this.categoria = categoria;

        catalogo.add(this);
    }

    public void Prestar() {
        if (estado == EstadoLibro.DISPONIBLE) {
            estado = EstadoLibro.PRESTADO;
            System.out.println("El libro '" + titulo + "' ha sido prestado.");
        } else {
            System.out.println("El libro '" + titulo + "' no está disponible.");
        }
    }

    public void Devolver() {
        estado = EstadoLibro.DISPONIBLE;
        System.out.println("El libro '" + titulo + "' ha sido devuelto.");
    }

    public String ObtenerInformacion() {
        return "ISBN: " + isbn +
               ", Título: " + titulo +
               ", Año: " + anioPublicado +
               ", Estado: " + estado +
               ", Categoría: " + categoria.getNombre();
    }

    // SOBRECARGA 1
    public List<Libro> Buscar(String palabraClave) {

        List<Libro> resultados = new ArrayList<>();

        for (Libro libro : catalogo) {
            if (libro.titulo.toLowerCase()
                    .contains(palabraClave.toLowerCase())
                    || libro.isbn.equalsIgnoreCase(palabraClave)) {

                resultados.add(libro);
            }
        }

        return resultados;
    }

    // SOBRECARGA 2
    public List<Libro> Buscar(Autor autor) {

        List<Libro> resultados = new ArrayList<>();

        for (Libro libro : catalogo) {
            if (autor != null && autor.getLibros().contains(libro)) {
                resultados.add(libro);
            }
        }

        return resultados;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnioPublicado() {
        return anioPublicado;
    }

    public void setAnioPublicado(int anioPublicado) {
        this.anioPublicado = anioPublicado;
    }

    public EstadoLibro getEstado() {
        return estado;
    }

    public void setEstado(EstadoLibro estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public static List<Libro> getCatalogo() {
        return catalogo;
    }
}