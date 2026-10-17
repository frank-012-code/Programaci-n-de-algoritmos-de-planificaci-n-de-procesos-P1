public class Proceso {
    String nombre;
    int rafaga;
    int llegada;
    int prioridad;
    int rafagaRestante; // Para Round Robin
    int tiempoEspera;
    int tiempoRetorno;

    public Proceso(String nombre, int rafaga, int llegada, int prioridad) {
        this.nombre = nombre;
        this.rafaga = rafaga;
        this.llegada = llegada;
        this.prioridad = prioridad;
        this.rafagaRestante = rafaga;
    }
}