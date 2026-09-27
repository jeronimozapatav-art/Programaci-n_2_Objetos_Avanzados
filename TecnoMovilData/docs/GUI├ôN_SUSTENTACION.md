# Guion de sustentación — TecnoMovil Data

**Duración objetivo: 6–7 minutos**

## 1. Presentación — 0:00–0:40

Buenos días/tardes. Somos el grupo de la Actividad 3 de Programación 2, correspondiente a Programación Funcional. Nuestro proyecto se denomina **TecnoMovil Data** y tiene como objetivo demostrar cómo el paradigma funcional de Java puede utilizarse para procesar registros de transporte urbano de una forma declarativa y organizada.

## 2. Caso de estudio — 0:40–1:20

TecnoMovil Data representa un sistema que recibe registros generados por validadores de tarjetas, sensores de estaciones, aplicaciones móviles y dispositivos IoT. Cada registro contiene el identificador del usuario, la ruta, la estación, la acción —entrada o salida— y la fecha y hora.

## 3. Estructura — 1:20–2:00

El proyecto tiene cuatro archivos principales. `RegistroTransporte.java` representa el modelo y utiliza un `record` de Java 17 para trabajar con datos inmutables. `DatosSimulados.java` genera los registros de prueba. `ProcesadorTransporte.java` contiene las operaciones funcionales. Finalmente, `Main.java` ejecuta el procesamiento y muestra los resultados.

## 4. Conceptos funcionales — 2:00–3:20

Aplicamos inmutabilidad mediante `record` y `List.of()`. Las funciones del procesador reciben datos y producen resultados sin modificar la lista original. Utilizamos expresiones lambda en filtros y transformaciones. Los Streams permiten construir pipelines declarativos usando operaciones como `filter`, `map` y `reduce`.

También implementamos una función de orden superior con `Function<T,R>`, porque una función puede recibirse como parámetro. Finalmente usamos composición de funciones mediante `andThen()`.

## 5. Operaciones — 3:20–4:50

La primera operación calcula la afluencia por estación y cuenta las entradas. La segunda agrupa los registros por hora para identificar el flujo. La tercera calcula el uso de cada ruta. La cuarta organiza los registros de cada usuario por fecha y hora para representar sus patrones de viaje. La quinta calcula el tiempo promedio entre registros consecutivos. La sexta compara el volumen de cada ruta con un umbral simulado para identificar una posible sobrecarga.

## 6. Procesamiento paralelo — 4:50–5:25

También incluimos `parallelStream()` como demostración de procesamiento paralelo. En este ejemplo contamos las entradas usando un Stream paralelo. Este recurso puede ser útil con grandes cantidades de datos, aunque no garantiza mayor velocidad en todos los casos porque depende del tamaño de los datos, la operación y los recursos disponibles.

## 7. Ejecución — 5:25–6:15

Ahora ejecutamos `Main.java`. En la terminal observamos la cantidad de registros y los resultados de cada operación. Esta salida constituye una de las principales evidencias de la actividad.

## 8. GitHub y conclusión — 6:15–7:00

Finalmente mostramos el repositorio de GitHub, donde se encuentra el código organizado por paquetes, junto con el README y las evidencias solicitadas.

Como conclusión, la actividad permitió aplicar el paradigma funcional de Java a un caso práctico. Los Streams, las expresiones lambda, la inmutabilidad, las funciones de orden superior y la composición permiten construir operaciones declarativas y organizadas para el procesamiento de datos.

Muchas gracias.
