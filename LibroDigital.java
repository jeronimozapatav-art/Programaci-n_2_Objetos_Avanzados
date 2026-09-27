```java
public class LibroDigital extends Libro {

    private String formato;
    private double tamanioArchivo;
    private String urlDescarga;

    // Constructor
    public LibroDigital(String isbn, String titulo, int anioPublicado,
                        EstadoLibro estado, Categoria categoria,
                        String formato, double tamanioArchivo,
                        String urlDescarga) {

        super(isbn, titulo, anioPublicado, estado, categoria);

        this.formato = formato;
        this.tamanioArchivo = tamanioArchivo;
        this.urlDescarga = urlDescarga;
    }

    // =====================================================
    // SOBRESCRITURA DEL MÉTODO PRESTAR
    // =====================================================

    @Override
    public void Prestar() {

        if (getEstado() == EstadoLibro.DISPONIBLE) {

            setEstado(EstadoLibro.PRESTADO);

            System.out.println(
                "Libro digital '" + getTitulo() +
                "' prestado correctamente."
            );

        } else {

            System.out.println(
                "El libro digital '" + getTitulo() +
                "' no está disponible."
            );
        }
    }

    // =====================================================
    // DESCARGAR LIBRO DIGITAL
    // =====================================================

    public void Descargar() {

        if (urlDescarga == null || urlDescarga.trim().isEmpty()) {

            System.out.println(
                "No existe una URL de descarga para este libro."
            );

            return;
        }

        System.out.println(
            "Descargando '" + getTitulo() +
            "' desde: " + urlDescarga
        );
    }

    // =====================================================
    // GETTERS Y SETTERS
    // =====================================================

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public double getTamanioArchivo() {
        return tamanioArchivo;
    }

    public void setTamanioArchivo(double tamanioArchivo) {
        this.tamanioArchivo = tamanioArchivo;
    }

    public String getUrlDescarga() {
        return urlDescarga;
    }

    public void setUrlDescarga(String urlDescarga) {
        this.urlDescarga = urlDescarga;
    }
}
