public abstract class Libro {
    // ================= Atributos (Encapsulamiento) =================
    private String isbn;
    private String titulo;
    private int anioPublicado;
    private EstadoLibro estado;
    private Categoria categoria;
    private List<Autor> autores; // Relación con Autor (un libro puede tener uno o varios autores)
    // ================= Constructor =================
    public Libro(String isbn, String titulo, int anioPublicado, EstadoLibro estado, Categoria categoria) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anioPublicado = anioPublicado;
        this.estado = estado;
        this.categoria = categoria;
        this.autores = new ArrayList<>();
    }