import java.util.Date;

public class Prestamo {
    private int idPrestamo;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private String estado;
    private LibroFisico libro;
    private Usuario usuario;

    public Prestamo(int idPrestamo, LibroFisico libro, Usuario usuario, Date fechaDevolucion) {
        this.idPrestamo = idPrestamo;
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = new Date();
        this.fechaDevolucion = fechaDevolucion;
        this.estado = "ACTIVO";
    }

    public void registrarPrestamo() {
        this.libro.prestar();
        this.usuario.solicitarPrestamo();
        System.out.println("Préstamo registrado exitosamente para el usuario: " + usuario.getNombre());
    }

    public int calcularDias() {
        long diferencia = fechaDevolucion.getTime() - fechaPrestamo.getTime();
        return (int) (diferencia / (1000 * 60 * 60 * 24));
    }

    public void cerrarPrestamo() {
        this.estado = "FINALIZADO";
        this.libro.devolver();
        System.out.println("Préstamo N° " + idPrestamo + " ha sido cerrado.");
    }

    // Getters y Setters
    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
