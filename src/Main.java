import java.util.Scanner;

import static Clases.Factura.Cliente.agregarCliente;
import static Clases.Factura.Cliente.mostrarClientes;
import static Clases.Factura.Factura.agregarFactura;
import static Clases.Factura.Factura.mostrarFacturas;
import static Clases.Factura.Producto.agregarProducto;
import static Clases.Factura.Producto.mostrarProductos;


public class Main {
    public static void main(String[] args) {
        Menu();
    }
    public static void Menu() {
        Scanner scanner = new Scanner(System.in);
        int elegir;

        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar Cliente.");
            System.out.println("2. Agregar Producto.");
            System.out.println("3. Agregar Factura.");
            System.out.println("4. Mostrar Clientes.");
            System.out.println("5. Mostrar Productos.");
            System.out.println("6. Mostrar Facturas.");
            System.out.println("0. Salir.");

            elegir = scanner.nextInt();

            switch (elegir) {
                case 1:
                    agregarCliente();
                    break;
                case 2:
                    agregarProducto();
                    break;
                case 3:
                    agregarFactura();
                    break;
                case 4:
                    mostrarClientes();
                    break;
                case 5:
                    mostrarProductos();
                    break;
                case 6:
                    mostrarFacturas();
                    break;
                case 0:
                    System.out.println("Salió.");
                    break;
                default:
                    System.out.println("Error, selecciona una opción valida.");
                    break;
            }
        } while (elegir != 0);
        scanner.close();
    }
}