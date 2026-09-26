```java
package tecnomovil.datos;

import tecnomovil.modelo.RegistroTransporte;

import java.time.LocalDateTime;
import java.util.List;

public class DatosSimulados {

    public static List<RegistroTransporte> generarRegistros() {

        return List.of(

                // Usuario U001
                new RegistroTransporte(
                        "U001",
                        "R10",
                        "EstacionCentral",
                        "entrada",
                        LocalDateTime.of(2026, 9, 25, 7, 30)
                ),

                new RegistroTransporte(
                        "U001",
                        "R10",
                        "EstacionNorte",
                        "salida",
                        LocalDateTime.of(2026, 9, 25, 7, 50)
                ),

                // Usuario U002
                new RegistroTransporte(
                        "U002",
                        "R20",
                        "EstacionSur",
                        "entrada",
                        LocalDateTime.of(2026, 9, 25, 8, 10)
                ),

                new RegistroTransporte(
                        "U002",
                        "R20",
                        "EstacionUniversidad",
                        "salida",
                        LocalDateTime.of(2026, 9, 25, 8, 35)
                ),

                // Usuario U003
                new RegistroTransporte(
                        "U003",
                        "R10",
                        "EstacionCentral",
                        "entrada",
                        LocalDateTime.of(2026, 9, 25, 8, 15)
                ),

                new RegistroTransporte(
                        "U003",
                        "R10",
                        "EstacionUniversidad",
                        "salida",
                        LocalDateTime.of(2026, 9, 25, 8, 40)
                ),

                // Usuario U004
                new RegistroTransporte(
                        "U004",
                        "R30",
                        "EstacionNorte",
                        "entrada",
                        LocalDateTime.of(2026, 9, 25, 9, 0)
                ),

                new RegistroTransporte(
                        "U004",
                        "R30",
                        "EstacionSur",
                        "salida",
                        LocalDateTime.of(2026, 9, 25, 9, 30)
                ),

                // Usuario U005
                new RegistroTransporte(
                        "U005",
                        "R20",
                        "EstacionSur",
                        "entrada",
                        LocalDateTime.of(2026, 9, 25, 10, 0)
                ),

                new RegistroTransporte(
                        "U005",
                        "R20",
                        "EstacionCentral",
                        "salida",
                        LocalDateTime.of(2026, 9, 25, 10, 25)
                ),

                // Usuario U006
                new RegistroTransporte(
                        "U006",
                        "R10",
                        "EstacionCentral",
                        "entrada",
                        LocalDateTime.of(2026, 9, 25, 11, 15)
                ),

                new RegistroTransporte(
                        "U006",
                        "R10",
                        "EstacionNorte",
                        "salida",
                        LocalDateTime.of(2026, 9, 25, 11, 40)
                )
        );
    }
}
```
