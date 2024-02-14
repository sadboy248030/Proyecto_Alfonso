package Cine;
import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // Se crea un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        // Se crea un objeto Cine llamado cine con el nombre "CineMax" y 7 salas
        Cine cine = new Cine("CineMax", 7);

        // Bandera para verificar si se seleccionó una sala válida
        boolean salaValida = false;
        // Variable para almacenar la sala seleccionada
        Sala salaSeleccionada = null;

        // Bucle do-while para seleccionar una sala válida
        do {
            try {
                // Se muestra la información de todas las salas disponibles en el cine
                cine.verInformacionSalas();
                System.out.print("Ingrese el numero de la sala: ");
                // Se solicita al usuario que ingrese el número de la sala que desea visitar
                int numeroSala = scanner.nextInt();
                // Se busca la sala correspondiente al número ingresado por el usuario
                salaSeleccionada = cine.getSala(numeroSala);

                // Si la sala es válida (no es null), se asigna a salaSeleccionada y se establece la bandera salaValida como true
                if (salaSeleccionada != null) {
                    salaValida = true;

                    // Se muestran los horarios de las funciones para la sala seleccionada
                    System.out.println("Horarios de funciones para la Sala " + salaSeleccionada.getNumero() + ":");
                    for (String horario : salaSeleccionada.getPelicula().getHorarios()) {
                        System.out.print(horario + " ");
                    }
                    System.out.println();

                    // Se muestra el estado de los asientos en la sala seleccionada
                    salaSeleccionada.mostrarEstadoAsientos();
                    // Bucle do-while anidado para realizar una reserva
                    do {
                        System.out.println("Los O son vacíos; las X son ocupados");
                        System.out.print("Ingrese la fila de la butaca: ");
                        int fila = scanner.nextInt();
                        System.out.print("Ingrese la columna de la butaca: ");
                        int columna = scanner.nextInt();

                        int numeroFuncion;
                        do {
                            // Se solicita al usuario que ingrese el número de la función a la que desea asistir
                            System.out.print("Ingrese el número de la función (1-" + salaSeleccionada.getPelicula().getHorarios().length + "): ");
                            numeroFuncion = scanner.nextInt();

                            // Verificar si el número de función ingresado es válido
                            if (numeroFuncion < 1 || numeroFuncion > salaSeleccionada.getPelicula().getHorarios().length) {
                                System.out.println("Número de función inválido. Debe estar entre 1 y " + salaSeleccionada.getPelicula().getHorarios().length);
                            }
                        } while (numeroFuncion < 1 || numeroFuncion > salaSeleccionada.getPelicula().getHorarios().length);

                        // Se obtiene la hora y los minutos de la función seleccionada
                        String[] horarios = salaSeleccionada.getPelicula().getHorarios();
                        String[] horaMinutosFuncion = horarios[numeroFuncion - 1].split(":");
                        int horaFuncion = Integer.parseInt(horaMinutosFuncion[0]);
                        int minutosFuncion = Integer.parseInt(horaMinutosFuncion[1]);

                        // Se intenta reservar el asiento en la sala seleccionada
                        if (salaSeleccionada.reservarAsiento(fila, columna, horaFuncion, minutosFuncion)) {
                            System.out.println("¡Reserva exitosa!");
                            System.out.println("Hora de la función: " + String.format("%02d:%02d", horaFuncion, minutosFuncion));
                            // Se pregunta al usuario si desea ver la información de los correos electrónicos asociados a los asientos ocupados
                            System.out.print("¿Desea ver la información de los correos electrónicos asociados a los asientos ocupados? (S/N): ");
                            String opcion = scanner.next();
                            // Si el usuario lo desea, se generan correos electrónicos aleatorios y se muestra un informe de los correos electrónicos asociados a los asientos ocupados
                            if (opcion.equalsIgnoreCase("S")) {
                                salaSeleccionada.generarCorreosAleatorios();
                                salaSeleccionada.mostrarInformeCorreosOcupados();
                            }
                            // Se sale del bucle do-while si la reserva es exitosa
                            break;
                        } else {
                            System.out.println("La butaca no está disponible o la hora de la función no es válida. Intente con otra.");
                        }
                    } while (true); // Repetir hasta que se realice una reserva exitosa

                    // Se muestra el estado de los asientos en la sala seleccionada después de la reserva
                    salaSeleccionada.mostrarEstadoAsientos();
                } else {
                    System.out.println("La sala ingresada no existe. Vuelva a intentar.");
                }
            } catch (InputMismatchException e) {
                // Captura de la excepción InputMismatchException en caso de que se ingrese un valor no numérico
                System.out.println("Error: Ingrese un número válido.");
                // Se limpia el búfer del scanner
                scanner.next();
            }
        } while (!salaValida); // Se repite el bucle do-while principal hasta que se seleccione una sala válida

        // Se muestra un mensaje de fin de programa
        System.out.println("FIN DEL PROGRAMA");

        // Se cierra el objeto Scanner
        scanner.close();
    }
}
                 
