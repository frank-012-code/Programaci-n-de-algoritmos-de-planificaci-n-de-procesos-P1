import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class FIFO {
    public static void ejecutar() {
        System.out.println("\n--- EJECUTANDO ALGORITMO FIFO ---");
        List<Proceso> procesos = new ArrayList<>();
        procesos.add(new Proceso("A", 3, 2, 2));
        procesos.add(new Proceso("B", 1, 4, 3));
        procesos.add(new Proceso("C", 3, 0, 1));
        procesos.add(new Proceso("D", 4, 1, 3));
        procesos.add(new Proceso("E", 2, 3, 4));
        // Ordenar por tiempo de llegada
        procesos.sort(Comparator.comparingInt(p -> p.llegada));
        int tiempoActual = 0;
        double sumaEspera = 0;
        double sumaRetorno = 0;
        System.out.println("Orden de ejecución:");
        for (Proceso p : procesos) {
            if (tiempoActual < p.llegada) {
                tiempoActual = p.llegada;
            }
            System.out.print("[" + p.nombre + " desde " + tiempoActual + " hasta " + (tiempoActual + p.rafaga) + "] ");
            p.tiempoEspera = tiempoActual - p.llegada;
            p.tiempoRetorno = p.tiempoEspera + p.rafaga;
            sumaEspera += p.tiempoEspera;
            sumaRetorno += p.tiempoRetorno;
            tiempoActual += p.rafaga;
        }
        System.out.println("\n\nTiempo Media de Espera (TEM): " + (sumaEspera / procesos.size()) + " ut");
        System.out.println("Tiempo de Retorno Medio (TRM): " + (sumaRetorno / procesos.size()) + " ut");
    }
}