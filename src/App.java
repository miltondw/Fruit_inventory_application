import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // =============================
        // Emily: Definición de arrays y variables para productos
        // =============================
        final int MAX_PRODUCTOS = 10; // Máximo de productos permitidos
        // Definicion de arrays
        String[] frutas = new String[MAX_PRODUCTOS];
        int[] cantidades = new int[MAX_PRODUCTOS];
        float[] precios = new float[MAX_PRODUCTOS];
        int numProductos = 0; // Contador de productos registrados

        System.out.println("Bienvenido al Inventario De La Fruteria");
        boolean isMenu = false;
        while (!isMenu) {
            // Menú principal
            System.out.println("\n1. Agregar producto");
            System.out.println("2. Mostrar reporte");
            System.out.println("3. Salir");
            System.out.print("Ingrese El Numero De La Opcion Deseada: ");
            int opcion = sc.nextInt(); // Leer opción del usuario
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    // =============================
                    // Juan: Entrada de datos para agregar producto
                    // =============================
                    // Permite registrar un nuevo producto en el inventario
                    if (numProductos < MAX_PRODUCTOS) {
                        System.out.print("Nombre del producto: ");
                        frutas[numProductos] = sc.nextLine();

                        System.out.print("Cantidad: ");
                        cantidades[numProductos] = sc.nextInt();

                        System.out.print("Precio por unidad: ");
                        precios[numProductos] = sc.nextFloat();

                        numProductos++; // Incrementa el contador de productos

                        System.out.println("Producto agregado correctamente.");
                    } else {
                        System.out.println("Inventario lleno. No se pueden agregar más productos.");
                    }
                    break;
                case 2:
                    // =============================
                    // Milton: Presentación del reporte final
                    // =============================
                    // Muestra el inventario en formato de tabla y el total

                    float totalInventario = 0f;

                    System.out.println("\n==============================");
                    System.out.println("REPORTE DE INVENTARIO");
                    System.out.println("==============================");
                    System.out.printf("%-15s %-10s %-15s %-15s\n", "Producto", "Cantidad", "Precio/U", "Valor Total");
                    System.out.println("-------------------------------------------------------------");

                    for (int i = 0; i < numProductos; i++) {
                        float valorTotal = cantidades[i] * precios[i]; // Calcula el valor total por producto
                        System.out.printf("%-15s %-10d %-15.2f %-15.2f\n",
                                frutas[i], cantidades[i], precios[i], valorTotal);
                        totalInventario += valorTotal; // Suma al total del inventario
                    }
                    System.out.println("-------------------------------------------------------------");
                    System.out.printf("%-15s %-10s %-15s %-15.2f\n", "TOTAL", "", "", totalInventario);
                    System.out.println("==============================");
                    break;

                case 3:
                    // Opción para isMenu del sistema
                    isMenu = true;
                    System.out.println("Gracias, hasta pronto.");
                    break;
                default:
                    // Mensaje para opción inválida
                    System.out.println("Opción no valida.");
            }
        }
        sc.close(); // Cierra el scanner
    }
}
