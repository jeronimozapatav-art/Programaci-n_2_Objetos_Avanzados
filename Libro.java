```java
import java.util.ArrayList;
import java.util.List;

public abstract class Libro {

    private String isbn;
    private String titulo;
    private int anioPublicado;
    private EstadoLibro estado;
    private Categoria categoria;

    // Catálogo general de libros
    private static final List<Libro> catalogo = new ArrayList<>();

    // Constructor
    public Libro(String isbn, String titulo, int anioPublicado,
                 EstadoLibro estado, Categoria categoria) {

        this.isbn = isbn;
        this.titulo = titulo;
        this.anioPublicado = anioPublicado;
        this.estado = estado;
        this.categoria = categoria;

        catalogo.add(this);
    }

    // =====================================================
    // PRESTAR
    // =====================================================

    public void Prestar() {

        if (estado == EstadoLibro.DISPONIBLE) {
            estado = EstadoLibro.PRESTADO;

            System.out.println(
                "El libro '" + titulo + "' ha sido prestado."
            );

        } else {

            System.out.println(
                "El libro '" + titulo + "' no está disponible."
            );
        }
    }

    // =====================================================
    // DEVOLVER
    // =====================================================

    public void Devolver() {

        estado = EstadoLibro.DISPONIBLE;

        System.out.println(
            "El libro '" + titulo + "' ha sido devuelto."
        );
    }

    // =====================================================
    // OBTENER INFORMACIÓN
    // =====================================================

    public String ObtenerInformacion() {

        String nombreCategoria =
                (categoria != null)
                ? categoria.getNombre()
                : "Sin categoría";

        return "ISBN: " + isbn
                + ", Título: " + titulo
                + ", Año: " + anioPublicado
                + ", Estado: " + estado
                + ", Categoría: " + nombreCategoria;
    }

    // =====================================================
    // SOBRECARGA 1
    // Buscar por palabra clave
    // =====================================================

    public List<Libro> Buscar(String palabraClave) {

        List<Libro> resultados = new ArrayList<>();

        if (palabraClave == null || palabraClave.trim().isEmpty()) {
            return resultados;
        }

        String criterio = palabraClave.toLowerCase();

        for (Libro libro : catalogo) {

            if ((libro.titulo != null
                    && libro.titulo.toLowerCase().contains(criterio))
                    || (libro.isbn != null
                    && libro.isbn.equalsIgnoreCase(palabraClave))) {

                resultados.add(libro);
            }
        }

        return resultados;
    }

    // =====================================================
    // SOBRECARGA 2
    // Buscar por autor
    // =====================================================

    public List<Libro> Buscar(Autor autor) {

        List<Libro> resultados = new ArrayList<>();

        if (autor == null) {
            return resultados;
        }

        for (Libro libro : catalogo) {

            if (autor.getLibros() != null
                    && autor.getLibros().contains(libro)) {

                resultados.add(libro);
            }
        }

        return resultados;
    }

    // =====================================================
    // GETTERS Y SETTERS
    // =====================================================

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

