import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creado una sola vez antes del bucle
        int opcion;

        do {
            System.out.println("\n=== MENÚ DE PLANIFICACIÓN DE CPU ===");
            System.out.println("1. FIFO");
            System.out.println("2. SJF");
            System.out.println("3. Prioridad");
            System.out.println("4. Round Robin");
            System.out.println("5. Comparar cual es el más rapido");
            System.out.println("6. Salir");
            System.out.println("-------------------------------------");
            System.out.print("Selecciona una opción (1-6): ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    FIFO.ejecutar();
                    break;
                case 2:
                    SJF.ejecutar();
                    break;
                case 3:
                    Prioridad.ejecutar();
                    break;
                case 4:
                    RoundRobin.ejecutar();
                    break;
                case 5:
                    Comparador.ejecutar();
                    break; // ¡Importante para que no pase al caso 6!
                case 6:
                    System.out.println("Saliendo del programa....");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 6); // Debe ser 6 para que coincida con la opción de salida

        scanner.close(); // Se cierra al terminar completamente el programa
    }
}