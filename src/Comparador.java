public class Comparador {
    public static void ejecutar() {
        System.out.println("\n=======================================================");
        System.out.println("      COMPARACIÓN DE ALGORITMOS DE PLANIFICACIÓN");
        System.out.println("=======================================================");

        String[] nombres = {"FIFO", "SJF (No Apropiativo)", "Prioridad", "Round Robin (q=3)"};
        double[] tem = {4.4, 2.6, 4.0, 5.0};
        double[] trm = {9.0, 7.2, 8.6, 9.6};

        System.out.println(String.format("%-25s | %-15s | %-15s", "Algoritmo", "TEM (Espera)", "TRM (Retorno)"));
        System.out.println("-------------------------------------------------------");

        int indiceMejor = 0;
        for (int i = 0; i < nombres.length; i++) {
            System.out.println(String.format("%-25s | %-15s | %-15s", nombres[i], tem[i] + " ut", trm[i] + " ut"));
            if (tem[i] < tem[indiceMejor]) {
                indiceMejor = i;
            }
        }

        System.out.println("-------------------------------------------------------");
        System.out.println("RESULTADO DE LA COMPARACIÓN:");
        System.out.println("-> El algoritmo MÁS RÁPIDO Y EFICIENTE es: " + nombres[indiceMejor]);
        System.out.println("   (Ofrece el menor Tiempo Medio de Espera: " + tem[indiceMejor] + " ut y menor Retorno Medio: " + trm[indiceMejor] + " ut)");
        System.out.println("=======================================================\n");
    }
}