# TecnoMovil Data — Actividad 3: Programación Funcional

Proyecto de Programación 2 / POO II para aplicar programación funcional en Java 17 al procesamiento de datos de transporte urbano.

## Funcionalidades
- Afluencia por estación.
- Horas de mayor flujo.
- Rutas más utilizadas.
- Patrones de viaje por usuario.
- Tiempo promedio entre registros consecutivos.
- Detección simulada de sobrecarga.
- Procesamiento paralelo con `parallelStream()`.
- Funciones de orden superior y composición.

## Estructura
```text
TecnoMovilData/
├── src/tecnomovil/Main.java
├── src/tecnomovil/modelo/RegistroTransporte.java
├── src/tecnomovil/datos/DatosSimulados.java
└── src/tecnomovil/servicio/ProcesadorTransporte.java
```

## Ejecutar con Java 17
```bash
javac -d out src/tecnomovil/modelo/RegistroTransporte.java src/tecnomovil/datos/DatosSimulados.java src/tecnomovil/servicio/ProcesadorTransporte.java src/tecnomovil/Main.java
java -cp out tecnomovil.Main
```

Agregar los nombres reales de los integrantes, enlaces del PDF y video antes de entregar.
