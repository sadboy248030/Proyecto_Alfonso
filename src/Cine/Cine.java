package Cine;

class Cine {
    private String nombre;  // Nombre del cine
    private Sala[] salas;   // Arreglo de salas en el cine

    /**
     *
     * Constructor que inicializa el cine
     * @param nombre del cine
     * @param numeroSalas que puede tener el array de la clase Sala
     */
    public Cine(String nombre, int numeroSalas) {
        this.nombre = nombre;
        this.salas = new Sala[numeroSalas];
        /**
         * Metodo Inicializa las salas con películas predefinidas
         */
        inicializarSalas();
    }

    /**
     * Método privado para inicializar las salas con películas predefinidas
     */
    private void inicializarSalas() {
        // Creación de películas predefinidas
        Pelicula dragon = new Pelicula("Cómo Entrenar a tu Dragón", 150);
        Pelicula gatoConBota = new Pelicula("El Gato con Botas", 150);
        Pelicula shrek = new Pelicula("Shrek", 150);
        Pelicula frozen = new Pelicula("Frozen", 150);
        Pelicula frozenII = new Pelicula("FrozenII", 150);
        /**
         * Creacion de la salas con la pelicula adjudicada
         */
        salas[0] = new Sala(1, dragon, 6, 12);
        salas[1] = new Sala(2, gatoConBota, 6, 12);
        salas[2] = new Sala(3, shrek, 6, 12);
        salas[3] = new Sala(4, frozen, 6, 12);
        salas[4] = new Sala(5, frozenII, 6, 12);
    }

    /**
     * Método para mostrar información sobre las salas y las películas
     */
    public void verInformacionSalas() {
        System.out.println("\nNombre del cine: " + getNombre());
        System.out.println("Horarios disponibles para las películas:");
        // Itera sobre las salas y muestra información de cada sala y su película
        for (Sala sala : salas) {
            /**
             * Si la sala es null, recuperamos la pelicula, mostrando el numero, nombre y duracion
             */
            if (sala != null) {
                Pelicula pelicula = sala.getPelicula();
                System.out.println("Sala " + sala.getNumero() + ": " + pelicula.getNombre() +
                        " - Duración: " + pelicula.getDuracionFormateada());
            }
        }
    }

    /**
     * Get para obtener una sala específica
     * @return nada si no la encuentra y en caso positivo retorna la sala
     */
    public Sala getSala(int numero) {
        for (Sala sala : salas) {
            if (sala != null && sala.getNumero() == numero) {
                return sala;
            }
        }
        return null;
    }


    /**
     * Get que muestra el nombre
     * @return el nombre de la sala
     */
    public String getNombre() {
        return nombre;
    }
}

