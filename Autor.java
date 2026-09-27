public class Autor {
    // Atributos encapsulados (privados)
    private String nombre;
    private String nacionalidad;
    private String fechaNacimiento; // Opcional, pero útil en el contexto de una biblioteca

    // Constructor
    public Autor(String nombre, String nacionalidad, String fechaNacimiento) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    // Método para imprimir el autor de forma legible
    @Override
    public String toString() {
        return "Autor: " + nombre + " (" + nacionalidad + ")";
    }
}
