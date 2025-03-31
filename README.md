# Cotxox

## Descripción del Proyecto

Cotxox es una simulación de un sistema de transporte similar a servicios de ride-hailing como Uber o Lyft. Este proyecto está diseñado para modelar y gestionar carreras (viajes) entre un origen y un destino, asignar conductores disponibles, calcular costos y propinas, y permitir la valoración de los conductores. El sistema está implementado en Java y utiliza pruebas unitarias para garantizar su correcto funcionamiento.

---

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes y clases:

### 1. **Paquete `edu.estatuas.cotxox`**
   - **Clase `Cotxox`**: Es el punto de entrada principal del programa. Contiene el método `main` que simula una carrera completa, desde la asignación de un conductor hasta el pago y la valoración del conductor.

### 2. **Paquete `edu.estatuas.cotxox.carrera`**
   - **Clase `Carrera`**: Representa un viaje o carrera. Contiene información como:
     - Tarjeta de crédito del cliente.
     - Origen y destino del viaje.
     - Distancia y tiempo estimado.
     - Coste total y propina.
     - Conductor asignado.
     - Métodos clave:
       - `asignarConductor`: Asigna un conductor disponible.
       - `realizarPago`: Registra el pago del cliente.
       - `recibirPropina`: Añade una propina al conductor.
       - `getCosteEsperado`: Calcula el coste estimado del viaje.

### 3. **Paquete `edu.estatuas.cotxox.conductores`**
   - **Clase `Conductor`**: Representa a un conductor. Contiene información como:
     - Nombre, modelo del vehículo y matrícula.
     - Valoración media basada en puntuaciones de los clientes.
     - Estado de disponibilidad (ocupado o no).
     - Métodos clave:
       - `setValoracion`: Añade una nueva valoración y actualiza la media.
       - `setOcupado`: Cambia el estado de disponibilidad del conductor.
   - **Clase `PoolConductores`**: Gestiona una lista de conductores disponibles. Métodos clave:
     - `asignarConductor`: Selecciona un conductor aleatoriamente de la lista.

### 4. **Paquete `edu.estatuas.cotxox.tarifa`**
   - **Clase `Tarifa`**: Contiene las reglas para calcular los costos de las carreras. Métodos clave:
     - `getCosteDistancia`: Calcula el coste basado en la distancia.
     - `getCosteTiempo`: Calcula el coste basado en el tiempo.
     - `getCosteTotalEsperado`: Calcula el coste total esperado, incluyendo una comisión.

---

## Ejecución del Programa

El programa se ejecuta desde la clase `Cotxox`. Aquí hay un resumen de lo que ocurre:

1. **Configuración de la Carrera**:
   - Se crea una instancia de `Carrera` con una tarjeta de crédito.
   - Se establecen el origen, destino, distancia y tiempo estimado.

2. **Cálculo del Coste**:
   - Se calcula el coste estimado del viaje utilizando la clase `Tarifa`.

3. **Asignación de un Conductor**:
   - Se crea un pool de conductores con nombres, matrículas y modelos de vehículos.
   - Se asigna un conductor disponible a la carrera.

4. **Pago y Propina**:
   - El cliente realiza el pago del coste estimado.
   - Se añade una propina al conductor.

5. **Valoración del Conductor**:
   - El cliente valora al conductor con una puntuación.

---

## Pruebas Unitarias

El proyecto incluye pruebas unitarias para garantizar la funcionalidad de las clases principales. Estas pruebas están implementadas en el paquete `src/test/java` y utilizan JUnit. Aquí hay un resumen:

- **`CarreraTest`**: Prueba los métodos de la clase `Carrera`, como la asignación de conductores, el cálculo de costes y la gestión de propinas.
- **`ConductorTest`**: Verifica la funcionalidad de la clase `Conductor`, como la gestión de valoraciones y el estado de disponibilidad.
- **`PoolConductoresTest`**: Asegura que los conductores se asignen correctamente desde el pool.
- **`TarifaTest`**: Valida los cálculos de costes basados en distancia y tiempo.

---

## Requisitos del Sistema

- **Java**: Versión 21 o superior.
- **Maven**: Para gestionar las dependencias y construir el proyecto.

---

## Cómo Ejecutar el Proyecto

1. Clona este repositorio en tu máquina local.
2. Asegúrate de tener Java y Maven instalados.
3. Compila el proyecto con Maven:
   ```bash
   mvn clean install
   ```
4. Ejecuta la clase principal:
    ```bash
    java -cp target/cotxox-1.0.0.jar edu.estatuas.cotxox.Cotxox
    ```
## Licencia
Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.