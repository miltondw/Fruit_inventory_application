import java.util.Scanner;

// Ejemplo básico de inventario usando solo variables, arrays y estructuras de control
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // =============================
        // Emily: Definición de arrays y variables para productos
        // =============================
        final int MAX_PRODUCTOS = 10;
        String[] nombres = new String[MAX_PRODUCTOS];
        int[] cantidades = new int[MAX_PRODUCTOS];
        float[] precios = new float[MAX_PRODUCTOS];
        int numProductos = 0;

        System.out.println("Bienvenido al Inventario De La Fruteria");
        boolean salir = false;
        while (!salir) {
            // Menú principal
            System.out.println("\n1. Agregar producto");
            System.out.println("2. Mostrar reporte");
            System.out.println("3. Salir");
            System.out.println("Ingrese El Numero De La Opcion Deseada");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    // =============================
                    // Juan: Entrada de datos para agregar producto
                    // =============================
                    if (numProductos < MAX_PRODUCTOS) {
                        System.out.print("Nombre del producto: ");
                        nombres[numProductos] = sc.nextLine();
                        System.out.print("Cantidad: ");
                        cantidades[numProductos] = sc.nextInt();
                        System.out.print("Precio por unidad: ");
                        precios[numProductos] = sc.nextFloat();
                        System.out.println("Producto agregado correctamente.");
                    } else {
                        System.out.println("Inventario lleno. No se pueden agregar más productos.");
                    }
                    break;
                case 2:
                    // =============================
                    // Milton: Presentación del reporte final
                    // =============================
                    float totalInventario = 0f;
                    System.out.println("\nReporte Final:");

                    for (int i = 0; i < numProductos; i++) {
                        float valorTotal = cantidades[i] * precios[i];

                        System.out.printf(
                                "Producto: %s - Cantidad: %d - Precio por unidad: %.2f - Valor total: %.2f\n",
                                nombres[i], cantidades[i], precios[i], valorTotal);

                        totalInventario += valorTotal;
                    }

                    System.out.printf("Valor total del inventario: %.2f\n", totalInventario);
                    break;

                case 3:
                    salir = true;
                    System.out.println("Gracias, hasta pronto.");
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        }
        sc.close();
    }
}
