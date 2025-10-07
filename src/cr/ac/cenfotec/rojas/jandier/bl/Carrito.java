package cr.ac.cenfotec.rojas.jandier.bl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Carrito {

    private List<Producto> miCarrito = new ArrayList<>();

    protected BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public List<Producto> getMiCarrito() {
        return miCarrito;
    }


    public void agregarProducto(Tienda tienda) throws IOException {

        System.out.print("Ingrese el ID del producto que desea agregar: ");
        int id = Integer.parseInt(in.readLine());

        Producto producto = tienda.buscarProductoId(id);

        if (producto != null && producto.getCantidad() > 0) {
            miCarrito.add(producto);
            tienda.eliminarStock(id);
            System.out.println(producto.getNombre() + " agregado exitosamente a mi carrito!");
        }else {
            System.out.println("El producto con el ID = #" + id  + " no existe!");
        }
    }

    public void eliminarProducto(Tienda tienda) throws IOException {

        System.out.print("Ingrese el ID del producto dentro de su carrito que desea eliminar: ");
        int id = Integer.parseInt(in.readLine());
        Producto producto = tienda.buscarProductoId(id);

        if (producto != null && miCarrito.contains(producto)) {
            miCarrito.remove(producto);
            tienda.devolverStock(id);
            System.out.println(producto.getNombre() + " fue eliminado de su carrito");
        } else {
            System.out.println("El producto con el ID = #" + id + " no existe en su carrito");
        }
    }

    public void imprimirCarrito() {

        //Tengo que buscar una manera de agregar la cantidad de tal producto en mi carrito
        System.out.println("Productos de mi carrito -->");
        for (Producto producto : miCarrito) {
            System.out.println("Producto: " + producto.getNombre() + " --> Precio: $" + producto.getPrecio());
        }
    }




}
