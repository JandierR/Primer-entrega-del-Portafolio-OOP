package cr.ac.cenfotec.rojas.jandier.bl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Carrito {

    private List<Producto> miCarrito = new ArrayList<>();
    private Tienda tienda = new Tienda();

    protected BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public List<Producto> getMiCarrito() {
        return miCarrito;
    }


    public boolean agregarProducto() throws IOException {

        System.out.print("Ingrese el ID del producto que desea agregar: ");
        int id = Integer.parseInt(in.readLine());

        if (tienda.buscarProductoId(id) != null) {
            miCarrito.add(tienda.buscarProductoId(id));
            tienda.eliminarStock(id);
            return true;
        } else {
            System.out.println("El producto con el ID = #" + id + " no existe");
            return false;
        }
    }

    public boolean eliminarProducto() throws IOException {

        System.out.print("Ingrese el ID del producto dentro de su carrito que desea eliminar: ");
        int id = Integer.parseInt(in.readLine());
        if (miCarrito.contains(tienda.buscarProductoId(id))) {
            miCarrito.remove(tienda.buscarProductoId(id));
            tienda.devolverStock(id);
            return true;
        }else {
            System.out.println("El producto con el ID = #" + id + " no existe en su carrito");
            return false;
        }
    }

    public void imprimirCarrito() {

        System.out.println("Productos de mi carrito -->");
        for (Producto producto : miCarrito) {
            System.out.println("Producto: " + producto.getNombre() + " --> Stock: "
                    + producto.getCantidad() + " --> Precio: $" + producto.getPrecio());
        }
    }




}
