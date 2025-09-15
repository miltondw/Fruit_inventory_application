import java.util.Scanner;

public class Inventario {
    public static void main(String[] args) {
        // Definición de arrays según los requisitos
        String[] names = {"manzana", "pera", "melocoton", "cereza", "ciruela"};
        int[] fruitQuantity = {10, 10, 10, 10, 10};
        Float[] fruitPrices = {2500f, 1500f, 3000f, 5000f, 6500f};
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println(" BIENVENIDO AL SISTEMA DE INVENTARIO DE LA FRUTERÍA MILFRUTY");
        
        // Menú principal
        while (true) {
            System.out.println("\n" + "=".repeat(40));
            System.out.println("SISTEMA DE INVENTARIO - FRUTERÍA");
            System.out.println("=".repeat(40));
            System.out.println("1. Mostrar inventario completo");
            System.out.println("2. Agregar stock");
            System.out.println("3. Vender producto");
            System.out.println("4. Buscar producto");
            System.out.println("5. Salir");
            System.out.println("=".repeat(40));
            
            System.out.print("Seleccione una opción (1-5): ");
            String option = scanner.nextLine();
            
            switch (option) {
                case "1":
                    total_inventory(names, fruitQuantity, fruitPrices);
                    break;
                case "2":
                    add_Stock(names, fruitQuantity, fruitPrices, scanner);
                    break;
                case "3":
                    products_sell(names, fruitQuantity, fruitPrices, scanner);
                    break;
                case "4":
                    search_product(names, fruitQuantity, fruitPrices, scanner);
                    break;
                case "5":
                    System.out.println("¡Gracias por usar el sistema de la frutería MILFRUTY! ");
                    scanner.close();
                    return;
                default:
                    System.out.println(" Opción inválida. Intente de nuevo.");
            }
        }
    }
    
    // Método para mostrar el inventario usando arrays
    public static void total_inventory(String[] names, int[] fruitQuantity, Float[] fruitPrices) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("INVENTARIO DE LA FRUTERÍA");
        System.out.println("=".repeat(50));
        System.out.printf("%-12s %-10s %-12s %-12s\n", "Producto", "Cantidad", "Precio", "Valor Total");
        System.out.println("-".repeat(50));

        Float total_product_value = 0f;

        // Recorremos los arrays usando for con índice

        int product_counter = names.length;
        for (int i = 0; i < product_counter; i++) {
            Float value_product = fruitQuantity[i] * fruitPrices[i];
            total_product_value += value_product;
            System.out.printf("%-12s %-10d $%-11.2f $%-11.2f\n",
            names[i], fruitQuantity[i], fruitPrices[i], value_product);
        }
        
        System.out.println("-".repeat(50));
        System.out.printf("%s $%.2f\n", "TOTAL INVENTARIO:", total_product_value);
        System.out.println("=".repeat(50));
    }
    
    // Método para agregar stock usando arrays
    public static void add_Stock(String[] names, int[] fruitQuantity, Float[] fruitPrices, Scanner scanner) {
        System.out.println("\n--- AGREGAR STOCK ---");
        
        // Mostrar productos disponibles
        System.out.println("Productos disponibles:");


        int product_counter = names.length;
        for (int i = 0; i < product_counter; i++) {
        System.out.println((i + 1) + ". " + names[i] + " - Stock: " + fruitQuantity[i]);
        }
        
        try {
            System.out.print("\nSeleccione el producto (1-5): ");
            int option = Integer.parseInt(scanner.nextLine()) - 1;
            
            // Validar que la opción esté dentro del rango del array
            if (option >= 0 && option < product_counter) {
                System.out.print("Ingrese la cantidad de " + names[option] + " a agregar: ");
                int fruit_quantity = Integer.parseInt(scanner.nextLine());
                
                if (fruit_quantity > 0) {
                    // Actualizar el array de fruitQuantity
                    fruitQuantity[option] += fruit_quantity;
                    System.out.println(" Se agregaron " + fruit_quantity + " unidades de " + names[option]);
                    System.out.println("Nuevo stock: " + fruitQuantity[option] + " unidades");
                } else {
                    System.out.println(" La cantidad debe ser mayor a 0");
                }
            } else {
                System.out.println(" Opción inválida. Debe ser entre 1 y " + product_counter);
            }
        } catch (NumberFormatException e) {
            System.out.println(" Por favor ingrese un número válido");
        }
    }
    
    // Método para vender productos usando arrays
    public static void products_sell(String[] names, int[] fruitQuantity, Float[] fruitPrices, Scanner scanner) {
        System.out.println("\n--- VENDER PRODUCTO ---");
        
        // Mostrar productos disponibles
        System.out.println("Productos disponibles:");
        int product_counter = names.length;
        for (int i = 0; i < product_counter; i++) {
            System.out.println((i + 1) + ". " + names[i] + " - $" + fruitPrices[i] + " - Stock: " + fruitQuantity[i]);
        }
        
        try {
            System.out.print("\nSeleccione el producto a vender (1-5): ");
            int option = Integer.parseInt(scanner.nextLine()) - 1;
            
            if (option >= 0 && option < product_counter) {
                if (fruitQuantity[option] > 0) {
                    System.out.println("Stock disponible de " + names[option] + ": " + fruitQuantity[option] + " unidades");
                    System.out.print("Ingrese la cantidad a vender: ");
                    int fruit_quantity = Integer.parseInt(scanner.nextLine());
                    
                    if (fruit_quantity > 0 && fruit_quantity <= fruitQuantity[option]) {
                        // Calcular total y actualizar array de fruitQuantity
                        Float total_sale = fruit_quantity * fruitPrices[option];
                        fruitQuantity[option] -= fruit_quantity;
                        
                        System.out.println(" Venta realizada: " + fruit_quantity + " x " + names[option]);
                        System.out.println(" Total a pagar: $" + total_sale);
                        System.out.println("Stock restante: " + fruitQuantity[option] + " unidades");
                    } else {
                        System.out.println(" Cantidad no disponible");
                    }
                } else {
                    System.out.println(" No hay stock de " + names[option]);
                }
            } else {
                System.out.println(" Opción inválida. Debe ser entre 1 y " + product_counter);
            }
        } catch (NumberFormatException e) {
            System.out.println(" Por favor ingrese un número válido");
        }
    }
    
    // Método para buscar producto usando arrays
    public static void search_product(String[] names, int[] fruitQuantity, Float[] fruitPrices, Scanner scanner) {
        System.out.print("\nIngrese el nombre del producto a buscar: ");
        String nombreBuscar = scanner.nextLine().toLowerCase();
        
        boolean encontrado = false;

        int product_counter = names.length;
        // Buscar en el array de names
        for (int i = 0; i < product_counter; i++) {
            if (names[i].toLowerCase().equals(nombreBuscar)) {
                System.out.println("\nProducto encontrado:");
                System.out.println("Nombre: " + names[i]);
                System.out.println("Cantidad: " + fruitQuantity[i] + " unidades");
                System.out.println("Precio: $" + fruitPrices[i]);
                System.out.println("Valor en inventario: $" + (fruitQuantity[i] * fruitPrices[i]));
                encontrado = true;
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println(" Producto no encontrado en el inventario");
        }
    }
}