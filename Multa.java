import java.util.Date;

public class Multa {
    private int idMulta;
    private double valor;
    private Date fecha;
    private boolean pagada;
    private Prestamo prestamo;

    public Multa(int idMulta, Prestamo prestamo) {
        this.idMulta = idMulta;
        this.prestamo = prestamo;
        this.fecha = new Date();
        this.pagada = false;
        this.valor = 0.0;
    }

    public double calcularValor(int diasRetraso) {
        // Ejemplo: Tarifa de $2,000 por cada día de retraso
        this.valor = diasRetraso * 2000.0;
        return this.valor;
    }

    public void marcarComoPagada() {
        this.pagada = true;
        System.out.println("La multa N° " + idMulta + " por un valor de $" + valor + " ha sido pagada.");
    }

    // Getters y Setters
    public int getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(int idMulta) {
        this.idMulta = idMulta;
    }

    public double getValor() {
        return valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public boolean isPagada() {
        return pagada;
    }
}