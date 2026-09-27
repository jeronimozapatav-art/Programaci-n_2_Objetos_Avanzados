```java
package tecnomovil.servicio;

import tecnomovil.modelo.RegistroTransporte;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class ProcesadorTransporte {

    /*
     * 1. CÁLCULO DE AFLUENCIA POR ESTACIÓN
     *
     * Cuenta únicamente los registros cuya acción sea "entrada"
     * y agrupa la cantidad de entradas por estación.
     */
    public Map<String, Long> calcularAfluenciaPorEstacion(
            List<RegistroTransporte> registros) {

        return registros.stream()
                .filter(registro ->
                        "entrada".equalsIgnoreCase(registro.accion()))
                .collect(Collectors.groupingBy(
                        RegistroTransporte::estacion,
                        Collectors.counting()
                ));
    }

    /*
     * 2. IDENTIFICACIÓN DE HORAS PICO
     *
     * Agrupa los registros según la hora del timestamp
     * y cuenta cuántos registros existen en cada hora.
     */
    public Map<Integer, Long> calcularFlujoPorHora(
            List<RegistroTransporte> registros) {

        return registros.stream()
                .collect(Collectors.groupingBy(
                        registro -> registro.timestamp().getHour(),
                        Collectors.counting()
                ));
    }

    /*
     * 3. RUTAS MÁS UTILIZADAS
     *
     * Cuenta la cantidad de registros asociados a cada ruta.
     */
    public Map<String, Long> calcularUsoPorRuta(
            List<RegistroTransporte> registros) {

        return registros.stream()
                .collect(Collectors.groupingBy(
                        RegistroTransporte::ruta,
                        Collectors.counting()
                ));
    }

    /*
     * 4. PATRONES DE VIAJE POR USUARIO
     *
     * Agrupa los registros por usuario y conserva el orden
     * temporal de los registros.
     *
     * Se crea una nueva lista para no modificar la colección original.
     */
    public Map<String, List<RegistroTransporte>> obtenerPatronesDeViaje(
            List<RegistroTransporte> registros) {

        return registros.stream()
                .sorted((r1, r2) ->
                        r1.timestamp().compareTo(r2.timestamp()))
                .collect(Collectors.groupingBy(
                        RegistroTransporte::idUsuario,
                        Collectors.toList()
                ));
    }

    /*
     * 5. TIEMPO PROMEDIO ENTRE ESTACIONES
     *
     * Ordena los registros por usuario y tiempo.
     * Después calcula la diferencia entre registros consecutivos
     * pertenecientes al mismo usuario.
     *
     * El resultado se expresa en minutos.
     */
    public double calcularTiempoPromedioEntreEstaciones(
            List<RegistroTransporte> registros) {

        List<RegistroTransporte> ordenados = registros.stream()
                .sorted((r1, r2) -> {

                    int comparacionUsuario =
                            r1.idUsuario().compareTo(r2.idUsuario());

                    if (comparacionUsuario != 0) {
                        return comparacionUsuario;
                    }

                    return r1.timestamp().compareTo(r2.timestamp());
                })
                .toList();

        List<Long> tiempos = java.util.stream.IntStream
                .range(1, ordenados.size())
                .filter(i ->
                        ordenados.get(i - 1)
                                .idUsuario()
                                .equals(ordenados.get(i).idUsuario()))
                .mapToObj(i ->
                        Duration.between(
                                ordenados.get(i - 1).timestamp(),
                                ordenados.get(i).timestamp()
                        ).toMinutes()
                )
                .toList();

        return tiempos.stream()
                .mapToLong(Long::longValue)
                .average()
                .orElse(0.0);
    }

    /*
     * 6. DETECCIÓN DE SOBRECARGA
     *
     * Recibe el resultado del uso de rutas y determina
     * cuáles superan el umbral definido.
     *
     * Umbral utilizado para la simulación: 3 registros.
     */
    public Map<String, String> detectarSobrecarga(
            Map<String, Long> usoPorRuta) {

        final long UMBRAL_SOBRECARGA = 3;

        return usoPorRuta.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entrada -> entrada.getValue() > UMBRAL_SOBRECARGA
                                ? "CRÍTICA"
                                : "NORMAL"
                ));
    }

    /*
     * 7. PROCESAMIENTO PARALELO
     *
     * Cuenta las entradas utilizando parallelStream().
     *
     * No modifica la colección original.
     */
    public long contarEntradasParalelo(
            List<RegistroTransporte> registros) {

        return registros.parallelStream()
                .filter(registro ->
                        "entrada".equalsIgnoreCase(registro.accion()))
                .count();
    }

    /*
     * 8. FUNCIÓN DE ORDEN SUPERIOR
     *
     * Recibe una función como parámetro y la aplica
     * a cada registro.
     */
    public <T> List<T> transformar(
            List<RegistroTransporte> registros,
            Function<RegistroTransporte, T> funcion) {

        return registros.stream()
                .map(funcion)
                .toList();
    }

    /*
     * 9. COMPOSICIÓN DE FUNCIONES
     *
     * Devuelve una función que normaliza el nombre
     * de una ruta.
     */
    public UnaryOperator<String> obtenerRutaNormalizada() {

        return ruta -> ruta
                .trim()
                .toUpperCase();
    }
}
```

}