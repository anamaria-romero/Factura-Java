package Clases.Factura;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static Clases.Factura.Cliente.clientes;
import static Clases.Factura.Producto.productos;


public class Factura {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Factura> facturas = new ArrayList<>();

    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private itemFactura[] items;

    public Factura(int folio, String descripcion, Date fecha, Cliente cliente, itemFactura[] items) {
        this.folio = folio;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.cliente = cliente;
        this.items = items;
    }

    public int getFolio() {
        return folio;
    }
    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public itemFactura[] getItems() {
        return items;
    }
    public void setItems(itemFactura[] items) {
        this.items = items;
    }

    public static void agregarFactura() {
        System.out.print("Ingrese folio de la factura: ");
        int folio = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Ingrese descripción de la factura: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese fecha de la factura (dd/MM/yyyy): ");
        String fechaStr = scanner.nextLine();
        Date fecha = parseDate(fechaStr);
        if (fecha == null) {
            System.out.println("Fecha inválida. La factura no fue creada.");
            return;
        }

        System.out.print("Ingrese NIF del cliente para la factura: ");
        String nif = scanner.nextLine();
        Cliente cliente = clientes.stream()
                .filter(c -> c.getNif().equals(nif))
                .findFirst()
                .orElse(null);
        if (cliente == null) {
            System.out.println("Cliente no encontrado. La factura no fue creada.");
            return;
        }

        System.out.print("Ingrese número de items en la factura: ");
        int numItems = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        itemFactura[] items = new itemFactura[numItems];
        for (int i = 0; i < numItems; i++) {
            System.out.print("Ingrese código del producto para el item " + (i + 1) + ": ");
            String codigo = scanner.nextLine();
            Producto producto = productos.stream()
                    .filter(p -> p.getCodigo().equals(codigo))
                    .findFirst()
                    .orElse(null);
            if (producto == null) {
                System.out.println("Producto no encontrado. El item no será agregado.");
                i--; // Reintentar el item actual
                continue;
            }
            System.out.print("Ingrese cantidad para el item " + (i + 1) + ": ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            items[i] = new itemFactura(producto, cantidad);
        }

        Factura factura = new Factura(folio, descripcion, fecha, cliente, items);
        facturas.add(factura);
        System.out.println("Factura creada con éxito.");
    }

    public static Date parseDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Error al parsear la fecha: " + e.getMessage());
            return null;
        }
    }

    public static void mostrarFacturas() {
        System.out.println("Facturas:");
        for (Factura factura : facturas) {
            System.out.println("Folio: " + factura.getFolio() + ", Descripción: " + factura.getDescripcion() + ", Fecha: " + factura.getFecha());
            System.out.println("Cliente: " + factura.getCliente().getNombre() + ", NIF: " + factura.getCliente().getNif());
            System.out.println("Items:");
            for (itemFactura item : factura.getItems()) {
                System.out.println("Producto: " + item.getProducto().getNombre() + ", Cantidad: " + item.getCantidad());
            }
        }
    }
}
