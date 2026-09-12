public class Main {
    public static void main(String[] args) {
        // Creamos un nuevo Autor y le damos datos
        Autor miAutor = new Autor();
        miAutor.nombre = "Gabriel García Márquez";
        miAutor.nacionalidad = "Colombiano";

        // Imprimimos el resultado en la consola
        System.out.println("El autor es: " + miAutor.nombre);
        System.out.println("Nacionalidad: " + miAutor.nacionalidad);
    }
}