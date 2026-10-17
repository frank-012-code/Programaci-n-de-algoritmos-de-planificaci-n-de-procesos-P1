import java.util.Scanner; // 1. Asegúrate de tener este import arriba del todo
public class main {
    public static void main(String[] args) {
        // 2. Crea el objeto scanner aquí arriba antes de usarlo
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== MENÚ DE PLANIFICACIÓN DE CPU ===");
        System.out.println("1. FIFO");
        System.out.println("2. SJF");
        System.out.println("3. Prioridad");
        System.out.println("4. Round Robin");
        System.out.println("-------------------------------------");
        System.out.print("Selecciona una opción (1-4): ");
        int opcion = scanner.nextInt(); // Ahora sí lo encontrará
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
            default:
                System.out.println("Opción no válida.");
        }
        scanner.close();
    }
}