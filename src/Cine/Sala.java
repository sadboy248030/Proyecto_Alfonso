package Cine;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase que representa una sala de cine
 */

class Sala {

    private int numero;             // Número de la sala
    private Pelicula pelicula;      // Película que se proyecta en la sala
    private boolean[][] asientos;   // Matriz de asientos en la sala
    private String[][] correos;     // Matriz para almacenar los correos electrónicos asociados a los asientos
    private Scanner scanner;        // Objeto Scanner para entrada del usuario
    private int filaReservada;      // Fila de la última butaca reservada
    private int columnaReservada;   // Columna de la última butaca reservada


    /**
     * Constructor de la Sala
     * @param numero de la sala
     * @param pelicula llamamos a la clase Pelicula
     * @param filas de la sala
     * @param columnas de la columna
     */
    public Sala(int numero, Pelicula pelicula, int filas, int columnas) {
        this.numero = numero;
        this.pelicula = pelicula;
        this.asientos = new boolean[filas][columnas];
        this.correos = new String[filas][columnas];
        this.scanner = new Scanner(System.in);
        /**
         * Inicializar con un valor que no corresponda a ninguna butaca válida
         */
        this.filaReservada = -1;
        /**
         *  Inicializar con un valor que no corresponda a ninguna butaca válida
         */
        this.columnaReservada = -1;
        /**
         * Método para generar butacas ocupadas aleatoriamente
         */
        generarButacasOcupadas();
    }

    /**
     * Método privado, ya que quiero utilizarlo en otro metodo, para generar butacas ocupadas aleatoriamente en la sala
     */

    private void generarButacasOcupadas() {
        Random random = new Random();
        for (int i = 1; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                /**
                 *  Butaca ocupada aleatoriamente
                 */
                asientos[i][j] = random.nextBoolean();
            }
        }
    }


    /**
     * Método para reservar un asiento en la sala
     * @param fila que queremos reservar
     * @param columna que queremos reservar
     * @param horaFuncion que queremso reservar
     * @param minutosFuncion que dura la pelicula
     * @return la reserva del asiento
     */
    public boolean reservarAsiento(int fila, int columna, int horaFuncion, int minutosFuncion) {
        // Verificar si el asiento está disponible
        if (!asientos[fila][columna]) {
            System.out.println("La butaca seleccionada ya está ocupada. Por favor, elija otra.");
            return false;
        }

        /**
         * Generar un correo electrónico aleatorio para asociarlo al asiento reservado
         * Almacenar el correo electrónico asociado al asiento reservado
         * Almacenar el correo electrónico asociado al asiento reservado
         *
         */

        String email = generarEmail();
        correos[fila][columna] = email;
        /**
         * Establecer el asiento como ocupado
         * Establecer el asiento como ocupado
         */

        asientos[fila][columna] = false;

        this.filaReservada = fila;
        this.columnaReservada = columna;

        System.out.println("Asiento reservado exitosamente para: " + email + " (Fila: " + fila + ", Columna: " + columna + ")");

        return true;
    }

    /**
     * Método para mostrar el estado de los asientos en la sala
     *
     */
    public void mostrarEstadoAsientos() {
        System.out.println("Estado de los asientos para la Sala " + numero + " - " +
                pelicula.getNombre() + " - Duración: " + pelicula.getDuracionFormateada());

        for (int i = 1; i < asientos.length; i++) {
            for (int j = 1; j < asientos[i].length; j++) {
                if (i == filaReservada && j == columnaReservada) {
                    /**
                     * Si se cumple la condicion se reserva butaca
                     */
                    System.out.print("R ");
                } else if (!asientos[i][j]) {
                    /**
                     * Si es distinto, la butaca esta opcuada
                     */
                    System.out.print("X ");
                } else {
                    /**
                     * Si no, la butaca esta libre
                     */
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Método para mostrar el informe de los correos electrónicos de los asientos ocupados
     */

    public void mostrarInformeCorreosOcupados() {
        System.out.println("Informe de correos electrónicos asociados a los asientos ocupados:");
        for (int i = 1; i < correos.length; i++) {
            for (int j = 1; j < correos[i].length; j++) {
                if (!asientos[i][j] && correos[i][j] != null) {
                    System.out.println("Asiento en la fila " + i + ", columna " + j + ": " + correos[i][j]);
                }
            }
        }
    }

    /**
     * Método para generar un email aleatorio con la funcion StringBuilder y lo definimos con dominio gmail
     */
    private String generarEmail() {
        StringBuilder sb = new StringBuilder();

        sb.append("Nombre@gmail.com");
        return sb.toString();
    }

    /**
     * Método para generar correos electrónicos aleatorios para los asientos ocupados
     */

    public void generarCorreosAleatorios() {
        Random random = new Random();
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789._-";

        for (int i = 1; i < correos.length; i++) {
            for (int j = 0; j < correos[i].length; j++) {
                if (!asientos[i][j]) {
                    /**
                     *  Cuando se reserva el asiento se muestra el email del usuario
                     */

                    StringBuilder sb = new StringBuilder();
                    if (i == filaReservada && j == columnaReservada) {
                        sb.append("Nombre@gmail.com");
                    } else {
                        for (int k = 0; k < 10; k++) {
                            int index = random.nextInt(caracteres.length());
                            sb.append(caracteres.charAt(index));
                        }
                        sb.append("@gmail.com");
                    }
                    /**
                     * Asignar un correo electrónico aleatorio o el fijo
                     */
                    correos[i][j] = sb.toString();
                }
            }
        }
    }
    /**
     *   GET para obtener el numero
     * @return el numero de la sala y la pelicula que se proyecta
     */
    public int getNumero() {
        return numero;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }
}
