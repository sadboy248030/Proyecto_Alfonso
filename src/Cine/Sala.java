package Cine;

import java.util.Random;
import java.util.Scanner;

// Clase que representa una sala de cine
class Sala {
    private int numero;             // Número de la sala
    private Pelicula pelicula;      // Película que se proyecta en la sala
    private boolean[][] asientos;   // Matriz de asientos en la sala
    private String[][] correos;     // Matriz para almacenar los correos electrónicos asociados a los asientos
    private Scanner scanner;        // Objeto Scanner para entrada del usuario
    private int filaReservada;      // Fila de la última butaca reservada
    private int columnaReservada;   // Columna de la última butaca reservada

    // Constructor de la Sala, recibe el número, la película, y las dimensiones de la matriz de asientos
    public Sala(int numero, Pelicula pelicula, int filas, int columnas) {
        this.numero = numero;
        this.pelicula = pelicula;
        this.asientos = new boolean[filas][columnas];
        this.correos = new String[filas][columnas];
        this.scanner = new Scanner(System.in);
        this.filaReservada = -1;    // Inicializar con un valor que no corresponda a ninguna butaca válida
        this.columnaReservada = -1; // Inicializar con un valor que no corresponda a ninguna butaca válida
        generarButacasOcupadas(); // Método para generar butacas ocupadas aleatoriamente
    }

    // Método privado para generar butacas ocupadas aleatoriamente en la sala
    private void generarButacasOcupadas() {
        Random random = new Random();
        for (int i = 1; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                asientos[i][j] = random.nextBoolean(); // Butaca ocupada aleatoriamente
            }
        }
    }

    // Método para reservar un asiento en la sala, recibe la fila, columna, hora y minutos de la función
    public boolean reservarAsiento(int fila, int columna, int horaFuncion, int minutosFuncion) {
        // Verificar si el asiento está disponible
        if (!asientos[fila][columna]) {
            System.out.println("La butaca seleccionada ya está ocupada. Por favor, elija otra.");
            return false;
        }

        // Generar un correo electrónico aleatorio para asociarlo al asiento reservado
        String email = generarEmail();

        // Almacenar el correo electrónico asociado al asiento reservado
        correos[fila][columna] = email;

        // Establecer el asiento como ocupado
        asientos[fila][columna] = false;

        // Actualizar la última butaca reservada
        this.filaReservada = fila;
        this.columnaReservada = columna;

        System.out.println("Asiento reservado exitosamente para: " + email + " (Fila: " + fila + ", Columna: " + columna + ")");

        return true; // Indica que la reserva fue exitosa
    }

    // Método para mostrar el estado de los asientos en la sala
    public void mostrarEstadoAsientos() {
        System.out.println("Estado de los asientos para la Sala " + numero + " - " +
                pelicula.getNombre() + " - Duración: " + pelicula.getDuracionFormateada());

        for (int i = 1; i < asientos.length; i++) {
            for (int j = 1; j < asientos[i].length; j++) {
                if (i == filaReservada && j == columnaReservada) {
                    System.out.print("R "); // Butaca reservada
                } else if (!asientos[i][j]) {
                    System.out.print("X "); // Butaca ocupada
                } else {
                    System.out.print("O "); // Butaca libre
                }
            }
            System.out.println(); // Salto de línea al final de cada fila
        }
    }

    // Método para mostrar el informe de los correos electrónicos de los asientos ocupados
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

    // Método para generar un email aleatorio
    private String generarEmail() {
        StringBuilder sb = new StringBuilder();

        sb.append("Nombre@gmail.com"); // Usamos Gmail como dominio
        return sb.toString();
    }

    // Método para generar correos electrónicos aleatorios para los asientos ocupados
    public void generarCorreosAleatorios() {
        Random random = new Random();
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789._-";

        for (int i = 1; i < correos.length; i++) {
            for (int j = 0; j < correos[i].length; j++) {
                if (!asientos[i][j]) { // Si el asiento está ocupado
                    StringBuilder sb = new StringBuilder();
                    if (i == filaReservada && j == columnaReservada) {
                        sb.append("Nombre@gmail.com");
                    } else {
                        for (int k = 0; k < 10; k++) {
                            int index = random.nextInt(caracteres.length());
                            sb.append(caracteres.charAt(index));
                        }
                        sb.append("@gmail.com"); // Usamos Gmail como dominio
                    }
                    correos[i][j] = sb.toString(); // Asignar un correo electrónico aleatorio o el fijo
                }
            }
        }
    }

    // Métodos para obtener el número de la sala y la película que se proyecta en la sala
    public int getNumero() {
        return numero;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }
}
