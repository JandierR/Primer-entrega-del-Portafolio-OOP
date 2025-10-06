package cr.ac.cenfotec.rojas.jandier.bl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tienda {

     private List<Producto> productosStock;
    private Carrito carrito = new Carrito();


    public Tienda() {
        productosStock = new ArrayList<>();
        agregarStock();
    }

    public List<Producto> getProductosStock() {
        return productosStock;
    }

    public void agregarStock() {
        productosStock.add(new Producto("Leche", 8, 1001, 1500));
        productosStock.add(new Producto("Fideos", 14, 1002, 1450));
        productosStock.add(new Producto("Manzanas", 34, 1003, 550));
        productosStock.add(new Producto("Helado", 15, 1004, 975));
        productosStock.add(new Producto("Queso", 7, 1005, 3400));
    }

    public void eliminarStock(int id) throws IOException {

        if (carrito.agregarProducto()) {
            productosStock.remove(buscarProductoId(id));
        }
    }

    public void devolverStock(int id) throws IOException {
        if (carrito.eliminarProducto()) {
            productosStock.add(buscarProductoId(id));
        }
    }

    public  void mostrarStock() {
        for (Producto producto : productosStock) {
            System.out.println( "[" + producto.getNombre() + "] cantidad -> " + producto.getCantidad() + " -> precio -> $" + producto.getPrecio());
        }
    }

    public Producto buscarProductoId(int id) {
        for (Producto producto : productosStock) {
            if (producto.getId() == id) {
                return producto;
            }
        }
            return null;
    }

    public double escanearProductos() {
        double total = 0;

        //Cada producto de la lista miCarrito se le va a sumar el precio al total.
        for (Producto producto : carrito.getMiCarrito()) {
            total += producto.getPrecio();
        }
        return total;
    }



    public void imprimirFactura() {
        System.out.println("-".repeat(10));
        System.out.println("---Factura---");
        System.out.println("-".repeat(10));
        carrito.imprimirCarrito();
        System.out.println("-".repeat(10));
        System.out.println("Precio total: " + escanearProductos());
        System.out.println("-".repeat(10));
    }

}
