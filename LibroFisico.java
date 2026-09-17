public class LibroFisico extends Libro {

    private int numeroEjemplares;
    private String ubicacion;

    public LibroFisico(String isbn, String titulo, int anioPublicado,
                       EstadoLibro estado, Categoria categoria,
                       int numeroEjemplares, String ubicacion) {

        super(isbn, titulo, anioPublicado, estado, categoria);

        this.numeroEjemplares = numeroEjemplares;
        this.ubicacion = ubicacion;
    }

    @Override
    public void Prestar() {

        if (numeroEjemplares > 0 &&
            getEstado() == EstadoLibro.DISPONIBLE) {

            numeroEjemplares--;
            setEstado(EstadoLibro.PRESTADO);

            System.out.println(
                "Libro físico prestado: " + getTitulo()
            );

        } else {

            System.out.println(
                "No hay ejemplares disponibles de: " + getTitulo()
            );
        }
    }

    public void Reservar() {

        if (getEstado() == EstadoLibro.DISPONIBLE) {
            setEstado(EstadoLibro.RESERVADO);

            System.out.println(
                "Libro físico reservado: " + getTitulo()
            );
        }
    }

    public int ObtenerDisponibilidad() {
        return numeroEjemplares;
    }

    public int getNumeroEjemplares() {
        return numeroEjemplares;
    }

    public void setNumeroEjemplares(int numeroEjemplares) {
        this.numeroEjemplares = numeroEjemplares;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}