package tecnomovil;

import tecnomovil.datos.DatosSimulados;
import tecnomovil.modelo.RegistroTransporte;
import tecnomovil.servicio.ProcesadorTransporte;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<RegistroTransporte> registros = DatosSimulados.generarRegistros();
        ProcesadorTransporte p = new ProcesadorTransporte();
        System.out.println("==============================================");
        System.out.println("             TECNOMOVIL DATA");
        System.out.println("   PROCESAMIENTO FUNCIONAL DE DATOS");
        System.out.println("==============================================");
        System.out.println("\nCantidad de registros: " + registros.size());
        System.out.println("\n--- 1. AFLUENCIA POR ESTACIÓN ---");
        p.calcularAfluenciaPorEstacion(registros).forEach((e,c)->System.out.println(e+" -> "+c+" entradas"));
        System.out.println("\n--- 2. HORAS PICO ---");
        p.calcularFlujoPorHora(registros).entrySet().stream().sorted(Map.Entry.<Integer,Long>comparingByValue().reversed())
            .forEach(e->System.out.println(e.getKey()+":00 -> "+e.getValue()+" registros"));
        System.out.println("\n--- 3. RUTAS MÁS UTILIZADAS ---");
        Map<String,Long> rutas=p.calcularUsoPorRuta(registros);
        rutas.entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed())
            .forEach(e->System.out.println(e.getKey()+" -> "+e.getValue()+" registros"));
        System.out.println("\n--- 4. PATRONES DE VIAJE ---");
        p.obtenerPatronesDeViaje(registros).forEach((u,l)->System.out.println(u+" -> "+l.stream().map(RegistroTransporte::estacion).distinct().reduce((a,b)->a+" -> "+b).orElse("Sin recorrido")));
        System.out.println("\n--- 5. TIEMPO PROMEDIO ENTRE ESTACIONES ---");
        System.out.printf("Tiempo promedio estimado: %.2f minutos%n",p.calcularTiempoPromedioEntreEstaciones(registros));
        System.out.println("\n--- 6. DETECCIÓN DE SOBRECARGA ---");
        p.detectarSobrecarga(rutas).forEach((r,e)->System.out.println(r+" -> "+e));
        System.out.println("\n--- 7. PROCESAMIENTO PARALELO ---");
        long inicio=System.nanoTime(); long entradas=p.contarEntradasParalelo(registros); long fin=System.nanoTime();
        System.out.println("Entradas procesadas: "+entradas); System.out.println("Tiempo de procesamiento paralelo: "+(fin-inicio)+" ns");
        System.out.println("\n--- 8. FUNCIÓN DE ORDEN SUPERIOR ---");
        p.transformar(registros,RegistroTransporte::idUsuario).stream().distinct().forEach(u->System.out.println("Usuario: "+u));
        System.out.println("\n--- 9. COMPOSICIÓN DE FUNCIONES ---");
        var normalizar=p.obtenerRutaNormalizada(); registros.stream().limit(3).map(normalizar).forEach(r->System.out.println("Ruta normalizada: "+r));
        System.out.println("\n==============================================");
        System.out.println("        FIN DEL PROCESAMIENTO");
        System.out.println("==============================================");
    }
}
