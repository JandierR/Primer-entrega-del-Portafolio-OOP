package cr.ac.cenfotec.rojas.jandier.dl;

import cr.ac.cenfotec.rojas.jandier.bl.entities.Producto;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<Producto> miCarrito;
    private List<Producto> productosStock;


    public Data() {
        miCarrito = new ArrayList<>();
        productosStock = new ArrayList<>();
        agregarProducto(new Producto("Leche", 8, 1001, 1500));
        agregarProducto(new Producto("Fideos", 14, 1002, 1450));
        agregarProducto(new Producto("Manzanas", 34, 1003, 550));
        agregarProducto(new Producto("Helado", 15, 1004, 975));
        agregarProducto(new Producto("Queso", 7, 1005, 3400));
        agregarProducto(new Producto("Botella de agua", 1, 1007, 875));
    }

    public List<Producto> getMiCarrito() {
        return miCarrito;
    }

    public void setMiCarrito(List<Producto> miCarrito) {
        this.miCarrito = miCarrito;
    }

    public List<Producto> getProductosStock() {
        return productosStock;
    }

    public void setProductosStock(List<Producto> productosStock) {
        this.productosStock = productosStock;
    }

    public void agregarProducto(Producto producto) {
        productosStock.add(producto);
    }
}
