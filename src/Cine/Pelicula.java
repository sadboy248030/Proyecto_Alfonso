package Cine;

/**
 * Clase que representa una película
  */

class Pelicula {
    private String nombre;      // Nombre de la película
    private int duracion;       // Duración de la película en minutos
    private String[] horarios;  // Horarios de proyección de la película

    /**
     * Constructor de la Película, recibe el nombre y la duración en minutos
     */

    public Pelicula(String nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.horarios = new String[]{"09:00", "12:00", "15:00", "18:00"}; // Horarios predefinidos
    }

    /**
     * Métodos para obtener el nombre, la duración y los horarios de proyección de la película
      */

    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }



    /**
     * Método para obtener la duración formateada en horas y minutos
     * @return un String.format que da la hora en formato zulu
     */
    public String getDuracionFormateada() {
        int horas = duracion / 60;
        int minutos = duracion % 60;
        return String.format("%02d:%02d", horas, minutos);
    }

    public String[] getHorarios() {
        return horarios;
    }
}

