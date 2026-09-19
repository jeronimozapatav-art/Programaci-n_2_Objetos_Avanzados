public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN DE BIBLIOTECA ===");

        // 1. Crear Autores usando el constructor (Responsabilidad de Jerónimo)
        Autor autor1 = new Autor("Gabriel García Márquez", "Colombiano", "06/03/1927");
        Autor autor2 = new Autor("Isabel Allende", "Chilena", "02/08/1942");

        System.out.println("\n--- Autores Registrados ---");
        System.out.println(autor1);
        System.out.println(autor2);

        // 2. Crear Usuarios (Responsabilidad de Jerónimo)
        Usuario usuario1 = new Usuario("1001", "Jerónimo Zapata Vargas", "jeronimo@est.iudigital.edu.co");
        Usuario usuario2 = new Usuario("1002", "Cristian", "cristian@est.iudigital.edu.co");

        System.out.println("\n--- Usuarios Registrados ---");
        System.out.println(usuario1);
        System.out.println(usuario2);

        // Aquí iría el código de tus compañeros más adelante, por ejemplo:
        // Libro libro1 = new LibroFisico("Cien Años de Soledad", autor1, ...);
        // usuario1.agregarLibroPrestado(libro1);
        // Prestamo prestamo1 = new Prestamo(usuario1, libro1, ...);
        
        System.out.println("\n¡Las clases de Autor y Usuario se han creado exitosamente!");
    }
}
