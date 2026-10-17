import java.util.ArrayList;
import java.util.List;

public class SJF {
    public static void ejecutar() {
        System.out.println("\n--- EJECUTANDO ALGORITMO SJF (No Apropiativo) ---");
        List<Proceso> original = new ArrayList<>();
        original.add(new Proceso("A", 3, 2, 2));
        original.add(new Proceso("B", 1, 4, 3));
        original.add(new Proceso("C", 3, 0, 1));
        original.add(new Proceso("D", 4, 1, 3));
        original.add(new Proceso("E", 2, 3, 4));

        List<Proceso> completados = new ArrayList<>();
        int tiempoActual = 0;
        int n = original.size();

        System.out.println("Orden de ejecución:");
        while (completados.size() < n) {
            Proceso seleccionado = null;
            int menorRafaga = Integer.MAX_VALUE;

            for (Proceso p : original) {
                if (p.llegada <= tiempoActual && !completados.contains(p)) {
                    if (p.rafaga < menorRafaga) {
                        menorRafaga = p.rafaga;
                        seleccionado = p;
                    }
                }
            }

            if (seleccionado == null) {
                tiempoActual++;
            } else {
                System.out.print("[" + seleccionado.nombre + " t=" + tiempoActual + "] ");
                tiempoActual += seleccionado.rafaga;
                seleccionado.tiempoEspera = (tiempoActual - seleccionado.llegada) - seleccionado.rafaga;
                seleccionado.tiempoRetorno = tiempoActual; // Tiempo de finalización
                completados.add(seleccionado);
            }
        }

        double sumaEspera = completados.stream().mapToInt(p -> p.tiempoEspera).sum();
        double sumaRetorno = completados.stream().mapToInt(p -> p.tiempoRetorno).sum();

        System.out.println("\n\nTiempo Media de Espera (TEM): " + (sumaEspera / n) + " ut");
        System.out.println("Tiempo de Retorno Medio (TRM): " + (sumaRetorno / n) + " ut");
    }
}