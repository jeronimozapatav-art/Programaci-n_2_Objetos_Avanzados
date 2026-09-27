```java
public class LibroFisico extends Libro {

    private int numeroEjemplares;
    private String ubicacion;

    // Constructor
    public LibroFisico(String isbn, String titulo, int anioPublicado,
                       EstadoLibro estado, Categoria categoria,
                       int numeroEjemplares, String ubicacion) {

        super(isbn, titulo, anioPublicado, estado, categoria);

        this.numeroEjemplares = numeroEjemplares;
        this.ubicacion = ubicacion;
    }

    // =====================================================
    // SOBRESCRITURA DEL MÉTODO PRESTAR
    // =====================================================

    @Override
    public void Prestar() {

        if (numeroEjemplares > 0 &&
            getEstado() == EstadoLibro.DISPONIBLE) {

            numeroEjemplares--;
            setEstado(EstadoLibro.PRESTADO);

            System.out.println(
                "Libro físico '" + getTitulo() +
                "' prestado correctamente."
            );

        } else {

            System.out.println(
                "No hay ejemplares disponibles de: " +
                getTitulo()
            );
        }
    }

    // =====================================================
    // RESERVAR
    // =====================================================

    public void Reservar() {

        if (getEstado() == EstadoLibro.DISPONIBLE &&
            numeroEjemplares > 0) {

            setEstado(EstadoLibro.RESERVADO);

            System.out.println(
                "Libro físico '" + getTitulo() +
                "' reservado correctamente."
            );

        } else {

            System.out.println(
                "El libro físico '" + getTitulo() +
                "' no está disponible para reserva."
            );
        }
    }

    // =====================================================
    // OBTENER DISPONIBILIDAD
    // =====================================================

    public int ObtenerDisponibilidad() {
        return numeroEjemplares;
    }

    // =====================================================
    // GETTERS Y SETTERS
    // =====================================================

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

