package Clases.Factura;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Producto {
    private static Scanner scanner = new Scanner(System.in);
    static List<Producto> productos = new ArrayList<>();

    private String codigo;
    private String nombre;
    private double precio;

    public Producto(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public static void agregarProducto() {
        System.out.print("Ingrese código del producto: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        productos.add(new Producto(codigo, nombre, precio));
        System.out.println("El producto ha sido creado.");
    }

    public static void mostrarProductos() {
        System.out.println("Productos:");
        for (Producto producto : productos) {
            System.out.println("Código: " + producto.getCodigo() + ", Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
        }
    }
}
