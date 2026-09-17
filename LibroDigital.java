public class LibroDigital extends Libro {

    private String formato;
    private double tamanioArchivo;
    private String urlDescarga;

    public LibroDigital(String isbn, String titulo, int anioPublicado,
                        EstadoLibro estado, Categoria categoria,
                        String formato, double tamanioArchivo,
                        String urlDescarga) {

        super(isbn, titulo, anioPublicado, estado, categoria);

        this.formato = formato;
        this.tamanioArchivo = tamanioArchivo;
        this.urlDescarga = urlDescarga;
    }

    @Override
    public void Prestar() {

        if (getEstado() == EstadoLibro.DISPONIBLE) {

            setEstado(EstadoLibro.PRESTADO);

            System.out.println(
                "Libro digital prestado: " + getTitulo()
            );

        } else {

            System.out.println(
                "El libro digital no está disponible."
            );
        }
    }

    public void Descargar() {

        System.out.println(
            "Descargando '" + getTitulo() +
            "' desde: " + urlDescarga
        );
    }

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