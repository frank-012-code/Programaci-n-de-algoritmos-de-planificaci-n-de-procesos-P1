import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RoundRobin {
    public static void ejecutar() {
        System.out.println("\n--- EJECUTANDO ROUND ROBIN (q = 3) ---");
        List<Proceso> lista = new ArrayList<>();
        lista.add(new Proceso("A", 3, 2, 2));
        lista.add(new Proceso("B", 1, 4, 3));
        lista.add(new Proceso("C", 3, 0, 1));
        lista.add(new Proceso("D", 4, 1, 3));
        lista.add(new Proceso("E", 2, 3, 4));

        lista.sort(Comparator.comparingInt(p -> p.llegada));
        Queue<Proceso> cola = new LinkedList<>();
        int tiempoActual = 0;
        int index = 0;
        int q = 3;
        int n = lista.size();
        int terminados = 0;

        System.out.println("Orden de ejecución:");
        while (terminados < n) {
            while (index < n && lista.get(index).llegada <= tiempoActual) {
                cola.add(lista.get(index));
                index++;
            }

            if (cola.isEmpty()) {
                tiempoActual = lista.get(index).llegada;
                continue;
            }

            Proceso p = cola.poll();
            int ejecucion = Math.min(p.rafagaRestante, q);
            System.out.print("[" + p.nombre + " t=" + tiempoActual + "] ");

            tiempoActual += ejecucion;
            p.rafagaRestante -= ejecucion;

            while (index < n && lista.get(index).llegada <= tiempoActual) {
                cola.add(lista.get(index));
                index++;
            }

            if (p.rafagaRestante > 0) {
                cola.add(p);
            } else {
                terminados++;
                p.tiempoRetorno = tiempoActual; // Tiempo de finalización
                p.tiempoEspera = p.tiempoRetorno - p.rafaga - p.llegada;
            }
        }

        double sumaEspera = lista.stream().mapToInt(p -> p.tiempoEspera).sum();
        double sumaRetorno = lista.stream().mapToInt(p -> p.tiempoRetorno).sum();

        System.out.println("\n\nTiempo Media de Espera (TEM): " + (sumaEspera / n) + " ut");
        System.out.println("Tiempo de Retorno Medio (TRM): " + (sumaRetorno / n) + " ut");
    }
}