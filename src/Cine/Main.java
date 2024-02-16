package Cine;
import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /**
         *  Se crea un objeto Cine llamado cine con el nombre "CineMax" y 7 salas
         */
        Cine cine = new Cine("CineMax", 7);
        /**
         * Bandera para verificar si se seleccionó una sala válida
         */
        boolean salaValida = false;
        /**
         * Variable para almacenar la sala seleccionada
         */
        Sala salaSeleccionada = null;
        /**
         * Menu con Bucle do-while para seleccionar una sala válida
         */

        do {
            try {
                // Se muestra la información de todas las salas disponibles en el cine
                cine.verInformacionSalas();
                System.out.print("Ingrese el numero de la sala: ");
                int numeroSala = scanner.nextInt();
                salaSeleccionada = cine.getSala(numeroSala);
                /**
                 *  Si la sala es válida (no es null), se asigna a salaSeleccionada y se establece la bandera salaValida como true
                 */

                if (salaSeleccionada != null) {
                    salaValida = true;

                    // Se muestran los horarios de las funciones para la sala seleccionada
                    System.out.println("Horarios de funciones para la Sala " + salaSeleccionada.getNumero() + ":");
                    for (String horario : salaSeleccionada.getPelicula().getHorarios()) {
                        System.out.print(horario + " ");
                    }
                    System.out.println();

                    /**
                     * Llamada al metodo que muestra el estado de los asientos en la sala seleccionada
                     */

                    salaSeleccionada.mostrarEstadoAsientos();
                    /**
                     * Menu con Bucle do-while anidado para realizar una reserva
                     */

                    do {
                        System.out.println("Los O son vacíos; las X son ocupados");
                        System.out.print("Ingrese la fila de la butaca: ");
                        int fila = scanner.nextInt();
                        System.out.print("Ingrese la columna de la butaca: ");
                        int columna = scanner.nextInt();

                        int numeroFuncion;
                        do {
                            System.out.print("Ingrese el número de la función (1-" + salaSeleccionada.getPelicula().getHorarios().length + "): ");
                            numeroFuncion = scanner.nextInt();
                            if (numeroFuncion < 1 || numeroFuncion > salaSeleccionada.getPelicula().getHorarios().length) {
                                System.out.println("Número de función inválido. Debe estar entre 1 y " + salaSeleccionada.getPelicula().getHorarios().length);
                            }
                        } while (numeroFuncion < 1 || numeroFuncion > salaSeleccionada.getPelicula().getHorarios().length);

                        /**
                         *  Llamada al metodo donde se obtiene la hora y los minutos de la función seleccionada
                         */

                        String[] horarios = salaSeleccionada.getPelicula().getHorarios();
                        String[] horaMinutosFuncion = horarios[numeroFuncion - 1].split(":");
                        int horaFuncion = Integer.parseInt(horaMinutosFuncion[0]);
                        int minutosFuncion = Integer.parseInt(horaMinutosFuncion[1]);

                        /**
                         * Se intenta reservar el asiento en la sala seleccionada
                         * Se pregunta al usuario si desea ver la información de los correos electrónicos asociados a los asientos ocupados
                         */

                        if (salaSeleccionada.reservarAsiento(fila, columna, horaFuncion, minutosFuncion)) {
                            System.out.println("¡Reserva exitosa!");
                            System.out.println("Hora de la función: " + String.format("%02d:%02d", horaFuncion, minutosFuncion));

                            System.out.print("¿Desea ver la información de los correos electrónicos asociados a los asientos ocupados? (S/N): ");
                            String opcion = scanner.next();
                            /**
                             * Si el usuario lo desea, se generan correos electrónicos aleatorios y se muestra un informe de los correos electrónicos asociados a los asientos ocupados
                             */

                            if (opcion.equalsIgnoreCase("S")) {
                                salaSeleccionada.generarCorreosAleatorios();
                                salaSeleccionada.mostrarInformeCorreosOcupados();
                            }

                            break;
                        } else {
                            System.out.println("La butaca no está disponible o la hora de la función no es válida. Intente con otra.");
                        }
                    } while (true);

                    /**
                     *  Llamado al metodo donde se muestra el estado de los asientos en la sala seleccionada después de la reserva
                     */
                    salaSeleccionada.mostrarEstadoAsientos();
                } else {
                    System.out.println("La sala ingresada no existe. Vuelva a intentar.");
                }
            } catch (InputMismatchException e) {
                /**
                 * Captura de la excepción InputMismatchException en caso de que se ingrese un valor no numérico
                 */

                System.out.println("Error: Ingrese un número válido.");

                scanner.next();
            }
        } while (!salaValida);

        System.out.println("FIN DEL PROGRAMA");

        scanner.close();
    }
}
                 
