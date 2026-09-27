package tecnomovil.servicio;

import tecnomovil.modelo.RegistroTransporte;
import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProcesadorTransporte {
    public Map<String,Long> calcularAfluenciaPorEstacion(List<RegistroTransporte> registros) {
        return registros.stream().filter(r -> r.accion().equalsIgnoreCase("entrada"))
                .collect(Collectors.groupingBy(RegistroTransporte::estacion, Collectors.counting()));
    }
    public Map<Integer,Long> calcularFlujoPorHora(List<RegistroTransporte> registros) {
        return registros.stream().collect(Collectors.groupingBy(r -> r.timestamp().getHour(), Collectors.counting()));
    }
    public Map<String,Long> calcularUsoPorRuta(List<RegistroTransporte> registros) {
        return registros.stream().collect(Collectors.groupingBy(RegistroTransporte::ruta, Collectors.counting()));
    }
    public Map<String,List<RegistroTransporte>> obtenerPatronesDeViaje(List<RegistroTransporte> registros) {
        return registros.stream().collect(Collectors.groupingBy(RegistroTransporte::idUsuario,
            Collectors.collectingAndThen(Collectors.toList(), lista -> lista.stream()
                .sorted(Comparator.comparing(RegistroTransporte::timestamp)).toList())));
    }
    public double calcularTiempoPromedioEntreEstaciones(List<RegistroTransporte> registros) {
        return registros.stream().collect(Collectors.groupingBy(RegistroTransporte::idUsuario)).values().stream()
            .flatMap(lista -> { List<RegistroTransporte> o = lista.stream().sorted(Comparator.comparing(RegistroTransporte::timestamp)).toList();
                return java.util.stream.IntStream.range(1,o.size()).mapToObj(i -> Duration.between(o.get(i-1).timestamp(),o.get(i).timestamp()).toMinutes()); })
            .mapToLong(Long::longValue).average().orElse(0.0);
    }
    private static final long UMBRAL_CRITICO = 4;
    public Map<String,String> detectarSobrecarga(Map<String,Long> usoPorRuta) {
        return usoPorRuta.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
            e -> e.getValue() > UMBRAL_CRITICO ? "CRÍTICA" : "NORMAL"));
    }
    public long contarEntradasParalelo(List<RegistroTransporte> registros) {
        return registros.parallelStream().filter(r -> r.accion().equalsIgnoreCase("entrada")).count();
    }
    public <T,R> List<R> transformar(List<T> datos, Function<T,R> funcion) {
        return datos.stream().map(funcion).toList();
    }
    public Function<RegistroTransporte,String> obtenerRutaNormalizada() {
        Function<RegistroTransporte,String> obtenerRuta = RegistroTransporte::ruta;
        Function<String,String> mayusculas = String::toUpperCase;
        return obtenerRuta.andThen(mayusculas);
    }
}
