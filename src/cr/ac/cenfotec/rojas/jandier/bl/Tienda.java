package cr.ac.cenfotec.rojas.jandier.bl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tienda {

    private List<Producto> productosStock;


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
        productosStock.add(new Producto("Botella de agua", 1, 1007, 875));
    }

    public void eliminarStock(int id) throws IOException {
        Producto producto = buscarProductoId(id);
        //Este if verifica si producto existe con el null
        if (producto != null) {
            //Modifico la cantidad del producto restandole 1
            producto.setCantidad(producto.getCantidad() - 1);
        }
    }

    public void devolverStock(int id) throws IOException {
        Producto producto = buscarProductoId(id);

        if (producto != null) {
            producto.setCantidad(producto.getCantidad() + 1);
        }
    }

    public void mostrarStock() {
        for (Producto producto : productosStock) {
            System.out.println("[" + producto.getNombre() + " (#" + producto.getId() + ")] cantidad -> " + producto.getCantidad() + " -> precio -> $" + producto.getPrecio());
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

    public double escanearProductos(Carrito carrito) {
        double total = 0;

        //Cada producto de la lista miCarrito se le va a sumar el precio al total.
        for (Producto producto : carrito.getMiCarrito()) {
            total += producto.getPrecio();
        }
        return total;
    }


    public void imprimirFactura(Carrito carrito) {
        if (carrito.getMiCarrito().isEmpty()) {
            System.out.println("El carrito está vacío. No se puede generar factura.");
        } else {
            System.out.println("-".repeat(35));
            System.out.println("---Factura---");
            System.out.println("-".repeat(35));
            carrito.imprimirCarrito();
            System.out.println("-".repeat(35));
            System.out.println("Precio total: " + escanearProductos(carrito));
            System.out.println("-".repeat(35));
        }

    }

}
