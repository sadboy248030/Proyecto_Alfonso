package Cine;

// Clase que representa un cine con varias salas y películas
class Cine {
    private String nombre;  // Nombre del cine
    private Sala[] salas;   // Arreglo de salas en el cine

    // Constructor que inicializa el cine con un nombre y un número de salas
    public Cine(String nombre, int numeroSalas) {
        this.nombre = nombre;
        this.salas = new Sala[numeroSalas];
        inicializarSalas();  // Inicializa las salas con películas predefinidas
    }

    // Método privado para inicializar las salas con películas predefinidas
    private void inicializarSalas() {
        // Creación de películas predefinidas
        Pelicula dragon = new Pelicula("Cómo Entrenar a tu Dragón", 150);
        Pelicula gatoConBota = new Pelicula("El Gato con Botas", 150);
        Pelicula shrek = new Pelicula("Shrek", 150);
        Pelicula frozen = new Pelicula("Frozen", 150);
        Pelicula frozenII = new Pelicula("FrozenII", 150);

        // Asignación de películas a las salas
        salas[0] = new Sala(1, dragon, 6, 12);
        salas[1] = new Sala(2, gatoConBota, 6, 12);
        salas[2] = new Sala(3, shrek, 6, 12);
        salas[3] = new Sala(4, frozen, 6, 12);
        salas[4] = new Sala(5, frozenII, 6, 12);
    }

    // Método para mostrar información sobre las salas y las películas
    public void verInformacionSalas() {
        System.out.println("\nNombre del cine: " + getNombre());
        System.out.println("Horarios disponibles para las películas:");
        // Itera sobre las salas y muestra información de cada sala y su película
        for (Sala sala : salas) {
            if (sala != null) {
                Pelicula pelicula = sala.getPelicula();
                System.out.println("Sala " + sala.getNumero() + ": " + pelicula.getNombre() +
                        " - Duración: " + pelicula.getDuracionFormateada());
            }
        }
    }

    // Método para obtener una sala específica por número
    public Sala getSala(int numero) {
        for (Sala sala : salas) {
            if (sala != null && sala.getNumero() == numero) {
                return sala;
            }
        }
        return null;  // Retorna null si la sala no se encuentra
    }

    // Método para obtener el nombre del cine
    public String getNombre() {
        return nombre;
    }
}

