```java
package tecnomovil;

import tecnomovil.datos.DatosSimulados;
import tecnomovil.modelo.RegistroTransporte;
import tecnomovil.servicio.ProcesadorTransporte;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // Cargar los datos simulados
        List<RegistroTransporte> registros =
                DatosSimulados.generarRegistros();

        // Crear el procesador
        ProcesadorTransporte procesador =
                new ProcesadorTransporte();

        System.out.println("==============================================");
        System.out.println("             TECNOMOVIL DATA");
        System.out.println("   PROCESAMIENTO FUNCIONAL DE DATOS");
        System.out.println("==============================================");

        System.out.println(
                "\nCantidad de registros: " + registros.size()
        );

        // 1. Afluencia por estación
        System.out.println(
                "\n--- 1. AFLUENCIA POR ESTACIÓN ---"
        );

        Map<String, Long> afluencia =
                procesador.calcularAfluenciaPorEstacion(registros);

        afluencia.forEach((estacion, cantidad) ->
                System.out.println(
                        estacion + " -> " + cantidad + " entradas"
                )
        );

        // 2. Horas pico
        System.out.println(
                "\n--- 2. HORAS PICO ---"
        );

        Map<Integer, Long> horas =
                procesador.calcularFlujoPorHora(registros);

        horas.entrySet()
                .stream()
                .sorted(
                        Map.Entry.<Integer, Long>
                                comparingByValue()
                                .reversed()
                )
                .forEach(entrada ->
                        System.out.println(
                                entrada.getKey()
                                        + ":00 -> "
                                        + entrada.getValue()
                                        + " registros"
                        )
                );

        // 3. Rutas más utilizadas
        System.out.println(
                "\n--- 3. RUTAS MÁS UTILIZADAS ---"
        );

        Map<String, Long> rutas =
                procesador.calcularUsoPorRuta(registros);

        rutas.entrySet()
                .stream()
                .sorted(
                        Map.Entry.<String, Long>
                                comparingByValue()
                                .reversed()
                )
                .forEach(entrada ->
                        System.out.println(
                                entrada.getKey()
                                        + " -> "
                                        + entrada.getValue()
                                        + " registros"
                        )
                );

        // 4. Patrones de viaje
        System.out.println(
                "\n--- 4. PATRONES DE VIAJE ---"
        );

        Map<String, List<RegistroTransporte>> patrones =
                procesador.obtenerPatronesDeViaje(registros);

        patrones.forEach((usuario, lista) -> {

            String recorrido = lista.stream()
                    .map(RegistroTransporte::estacion)
                    .distinct()
                    .reduce(
                            (a, b) -> a + " -> " + b
                    )
                    .orElse("Sin recorrido");

            System.out.println(
                    usuario + " -> " + recorrido
            );
        });

        // 5. Tiempo promedio
        System.out.println(
                "\n--- 5. TIEMPO PROMEDIO ENTRE ESTACIONES ---"
        );

        double promedio =
                procesador.calcularTiempoPromedioEntreEstaciones(
                        registros
                );

        System.out.printf(
                "Tiempo promedio estimado: %.2f minutos%n",
                promedio
        );

        // 6. Detección de sobrecarga
        System.out.println(
                "\n--- 6. DETECCIÓN DE SOBRECARGA ---"
        );

        Map<String, String> sobrecarga =
                procesador.detectarSobrecarga(rutas);

        sobrecarga.forEach((ruta, estado) ->
                System.out.println(
                        ruta + " -> " + estado
                )
        );

        // 7. Procesamiento paralelo
        System.out.println(
                "\n--- 7. PROCESAMIENTO PARALELO ---"
        );

        long inicio = System.nanoTime();

        long entradas =
                procesador.contarEntradasParalelo(registros);

        long fin = System.nanoTime();

        System.out.println(
                "Entradas procesadas: " + entradas
        );

        System.out.println(
                "Tiempo de procesamiento paralelo: "
                        + (fin - inicio)
                        + " ns"
        );

        // 8. Función de orden superior
        System.out.println(
                "\n--- 8. FUNCIÓN DE ORDEN SUPERIOR ---"
        );

        List<String> usuarios =
                procesador.transformar(
                        registros,
                        RegistroTransporte::idUsuario
                );

        usuarios.stream()
                .distinct()
                .forEach(usuario ->
                        System.out.println(
                                "Usuario: " + usuario
                        )
                );

        // 9. Composición de funciones
        System.out.println(
                "\n--- 9. COMPOSICIÓN DE FUNCIONES ---"
        );

        var rutaNormalizada =
                procesador.obtenerRutaNormalizada();

        registros.stream()
                .limit(3)
                .map(rutaNormalizada)
                .forEach(ruta ->
                        System.out.println(
                                "Ruta normalizada: " + ruta
                        )
                );

        System.out.println(
                "\n=============================================="
        );
        System.out.println(
                "        FIN DEL PROCESAMIENTO"
        );
        System.out.println(
                "=============================================="
        );
    }
}
```
