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
            System.out.println("4. Actualizar producto");
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

                        // Validación de cantidad
                        int cantidad;
                        do {
                            System.out.print("Cantidad: ");
                            cantidad = sc.nextInt();
                            if (cantidad < 0) {
                                System.out.println("La cantidad debe ser positiva.");
                            }
                        } while (cantidad < 0);
                        cantidades[numProductos] = cantidad;

                        // Validación de precio
                        float precio;
                        do {
                            System.out.print("Precio por unidad: ");
                            precio = sc.nextFloat();
                            if (precio < 0) {
                                System.out.println("El precio debe ser positivo.");
                            }
                        } while (precio < 0);
                        precios[numProductos] = precio;
                        sc.nextLine(); // Limpiar buffer

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
                    // Opción para salir del sistema
                    isMenu = true;
                    System.out.println("Gracias, hasta pronto.");
                    break;
                case 4:
                    // =============================
                    // Opción para actualizar producto existente por índice
                    // =============================
                    if (numProductos == 0) {
                        System.out.println("No hay productos para actualizar.");
                        break;
                    }
                    System.out.println("Lista de productos:");
                    for (int i = 0; i < numProductos; i++) {
                        System.out.printf("[%d] %s - Cantidad: %d - Precio: %.2f\n", i, frutas[i], cantidades[i],
                                precios[i]);
                    }
                    int idx;
                    do {
                        System.out.print("Ingrese el índice del producto a actualizar: ");
                        idx = sc.nextInt();
                        if (idx < 0 || idx >= numProductos) {
                            System.out.println("Índice inválido. Intente nuevamente.");
                        }
                    } while (idx < 0 || idx >= numProductos);
                    sc.nextLine(); // Limpiar buffer

                    // Validación de cantidad
                    int nuevaCantidad;
                    do {
                        System.out.print("Nueva cantidad: ");
                        nuevaCantidad = sc.nextInt();
                        if (nuevaCantidad < 0) {
                            System.out.println("La cantidad debe ser positiva.");
                        }
                    } while (nuevaCantidad < 0);
                    cantidades[idx] = nuevaCantidad;

                    // Validación de precio
                    float nuevoPrecio;
                    do {
                        System.out.print("Nuevo precio por unidad: ");
                        nuevoPrecio = sc.nextFloat();
                        if (nuevoPrecio < 0) {
                            System.out.println("El precio debe ser positivo.");
                        }
                    } while (nuevoPrecio < 0);
                    precios[idx] = nuevoPrecio;
                    sc.nextLine(); // Limpiar buffer

                    System.out.println("Producto actualizado correctamente.");
                    break;
                default:
                    // Mensaje para opción inválida
                    System.out.println("Opción no valida.");
            }
        }
        sc.close(); // Cierra el scanner
    }
}
