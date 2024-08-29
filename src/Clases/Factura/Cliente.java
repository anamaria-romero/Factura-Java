package Clases.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    private static Scanner scanner = new Scanner(System.in);
    static List<Cliente> clientes = new ArrayList<>();

    private String nombre;
    private String nif; // Número de Identificación Fiscal

    public Cliente(String nombre, String nif) {
        this.nombre = nombre;
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }
    public void setNif(String nif) {
        this.nif = nif;
    }

    public static void agregarCliente() {
        System.out.print("Ingrese nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese NIF del cliente: ");
        String nif = scanner.nextLine();
        clientes.add(new Cliente(nombre, nif));
        System.out.println("El cliente ha sido creado.");
    }

    public static void mostrarClientes() {
        System.out.println("Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println("Nombre: " + cliente.getNombre() + ", NIF: " + cliente.getNif());
        }
    }
}
