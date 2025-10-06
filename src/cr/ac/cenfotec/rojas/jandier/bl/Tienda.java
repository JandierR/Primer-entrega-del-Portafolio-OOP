package cr.ac.cenfotec.rojas.jandier.bl;

import java.util.ArrayList;
import java.util.List;

public class Tienda {

     private List<Producto> productosStock;


    public Tienda() {
        productosStock = new ArrayList<>();
        agregarStock();
    }

    public void agregarStock() {
        productosStock.add(new Producto("Leche", 8, 1001, 1500));
        productosStock.add(new Producto("Fideos", 14, 1002, 1450));
        productosStock.add(new Producto("Manzanas", 34, 1003, 550));
        productosStock.add(new Producto("Helado", 15, 1004, 975));
        productosStock.add(new Producto("Queso", 7, 1005, 3400));
    }



    public  void mostrarStock() {
        for (Producto producto : productosStock) {
            System.out.println( "[" + producto.getNombre() + "] cantidad -> " + producto.getCantidad() + " -> precio -> $" + producto.getPrecio());
        }
    }
}
