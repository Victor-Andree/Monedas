import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaMoneda consultaMoneda = new ConsultaMoneda();

        boolean salir = false;

        while (!salir) {
            System.out.println("\nBienvenido al Conversor de Monedas");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Convertir moneda");
            System.out.println("2. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    realizarConversion(consultaMoneda, scanner);
                    break;
                case 2:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }

        scanner.close();
    }

    private static void realizarConversion(ConsultaMoneda consultaMoneda, Scanner scanner) {
        scanner.nextLine(); // Consumir la nueva línea pendiente

        System.out.println("\nIngrese la cantidad a convertir:");
        double cantidad = scanner.nextDouble();

        scanner.nextLine(); // Consumir la nueva línea pendiente

        System.out.println("Ingrese la moneda de origen (por ejemplo, USD):");
        String monedaOrigen = scanner.nextLine().toUpperCase();

        System.out.println("Ingrese la moneda de destino (por ejemplo, EUR):");
        String monedaDestino = scanner.nextLine().toUpperCase();

        try {
            double tasaDeCambio = consultaMoneda.obtenerTasaDeCambio(monedaOrigen, monedaDestino);
            GeneradordeMonedas converter = new GeneradordeMonedas(tasaDeCambio);
            double resultado = converter.convertir(cantidad);

            System.out.println("\nResultado de la conversión:");
            System.out.println(cantidad + " " + monedaOrigen + " son " + resultado + " " + monedaDestino);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
