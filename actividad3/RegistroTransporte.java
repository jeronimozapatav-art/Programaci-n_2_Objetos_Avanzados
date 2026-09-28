package ACTIVIDAD_2.actividad3; 

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


record PasajeTransporte(
    String idTicket,
    String pasajero,
    String origen,
    String destino,
    double tarifa,
    String tipoVehiculo,
    boolean pagado
) {}

public class RegistroTransporte {

    public static void main(String[] args) {

        
        List<PasajeTransporte> registros = List.of(
            new PasajeTransporte("T001", "Carlos Pérez", "Medellín", "Bogotá", 85.000, "Bus", true),
            new PasajeTransporte("T002", "Ana Gómez", "Medellín", "Cali", 95.000, "Bus", true),
            new PasajeTransporte("T003", "Luis Martínez", "Bogotá", "Tunja", 25.000, "Microbus", true),
            new PasajeTransporte("T004", "Sofía Ramírez", "Medellín", "Bogotá", 85.000, "Bus", false),
            new PasajeTransporte("T005", "Diego Torres", "Cali", "Popayán", 30.000, "Microbus", true),
            new PasajeTransporte("T006", "María Rodríguez", "Medellín", "Bogotá", 120.000, "Taxi Expreso", true)
        );

        
        Predicate<PasajeTransporte> esOrigenMedellinYPagado = 
            p -> p.origen().equalsIgnoreCase("Medellín") && p.pagado();

        System.out.println("=== REPORTES DEL SISTEMA DE TRANSPORTE ===\n");

        
        System.out.println("1. Pasajes pagados con origen 'Medellín':");
        List<String> reporteMedellin = registros.stream()
                .filter(esOrigenMedellinYPagado)
                .map(p -> String.format(" - Ticket: %s | Pasajero: %s | Destino: %s | Costo: $%.3f",
                        p.idTicket(), p.pasajero(), p.destino(), p.tarifa()))
                .toList();

        reporteMedellin.forEach(System.out::println);

      
        double totalRecaudado = registros.stream()
                .filter(PasajeTransporte::pagado)
                .mapToDouble(PasajeTransporte::tarifa)
                .reduce(0.0, Double::sum);

        System.out.println(String.format("\n2. Recaudo Total del Sistema: $%.3f", totalRecaudado));

        // C) AGRUPACIÓN POR TIPO DE VEHÍCULO
        Map<String, Long> conteoPorVehiculo = registros.stream()
                .collect(Collectors.groupingBy(
                        PasajeTransporte::tipoVehiculo,
                        Collectors.counting()
                ));

        System.out.println("\n3. Cantidad de viajes por tipo de vehículo:");
        conteoPorVehiculo.forEach((vehiculo, cantidad) -> 
            System.out.println(" - " + vehiculo + ": " + cantidad + " viaje(s)")
        );

        
        System.out.println("\n4. Cálculo de Tasa de Embarque (Función Pura):");
        double tarifaEjemplo = 85.000;
        double tasa = calcularTasaTerminal(tarifaEjemplo, 5.0);
        System.out.println(String.format(" - Para una tarifa de $%.3f, la tasa de terminal es: $%.3f", tarifaEjemplo, tasa));
    }

    public static double calcularTasaTerminal(double tarifaBase, double porcentajeTasa) {
        return tarifaBase * (porcentajeTasa / 100.0);
    }
}