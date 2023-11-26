# Proyecto WildFly - Jakarta EE

En este proyecto eclipse se presenta una implementación de un sistema de reserva de hotel. El sistema no está terminado, por lo que usted debe completarlo con los métodos descritos y otros que usted estime conveniente.

El sistema debe ser implementado en *WildFly 30* con conexión a una base de datos *postgresql*. El framework de persistencia utilizado es *JPA*. 



### Building

Para el deployment (o implementación), en una consola escribir lo siguiente:

    mvn wildfly:deploy

### Ejemplo de Implementación

El proyecto actualmente contempla la creación un método *"main"*, el cual se encuentra implementado en la clase /src/main/java/cl.ucn.presentacion/Main.java

Actualmente este método solo crea un cliente y lo persisten en la base de datos.


### Implementar los siguientes casos de test unitarios:

1. **En la Clase Cliente: Cliente - Creación: ** Cliente(String nombre, String email, String telefono): Verifica que la creación de un cliente con información válida funcione correctamente.

2. **Cliente - Actualización de Información:** actualizarInformacion(String nuevoTelefono): Asegura que la información del cliente pueda actualizarse correctamente.

3. **En la Clase Habitacion: Habitacion - Creación:** Habitacion(int numero, TipoHabitacion tipo, double precio): Verifica la creación de una habitación con información válida.

4. **Habitacion - Disponibilidad:** estaDisponible(LocalDate fechaInicio, LocalDate fechaFin): Verifica si una habitación está disponible en un rango de fechas.

5. **En la Clase Reserva: Reserva - Creación:**  Reserva(Cliente cliente, Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin): Asegura que la creación de una reserva con información válida funcione correctamente.

6. **Reserva - Cálculo de Precio:** calcularPrecio(): Verifica que el cálculo del precio de la reserva sea correcto. 

7. **Reserva - Cancelación: cancelarReserva():** Asegura que la cancelación de una reserva funcione correctamente. 

8. **Reserva - Duración de la Estancia:** calcularDuracionEstancia(): Verifica que el cálculo de la duración de la estancia sea correcto.

9. **Reserva - Estado de la Reserva:** estaCancelada(): Asegura que el estado de la reserva se actualiza correctamente después de la cancelación.

10. **En el Sistema (Controlador, Servicio, etc.):** Sistema - Reservar Habitación: reservarHabitacion(Cliente cliente, Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin): Verifica que el proceso de reserva funcione correctamente.

11. **Sistema - Consultar Disponibilidad:** consultarDisponibilidad(LocalDate fechaInicio, LocalDate fechaFin): Asegura que el sistema pueda consultar la disponibilidad de habitaciones para un rango de fechas.

12. ** Sistema - Historial de Reservas de un Cliente:** obtenerHistorialReservasCliente(Cliente cliente): Verifica que el sistema pueda proporcionar el historial de reservas de un cliente.

