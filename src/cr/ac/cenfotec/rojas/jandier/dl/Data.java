package cr.ac.cenfotec.rojas.jandier.dl;

import cr.ac.cenfotec.rojas.jandier.bl.entities.Producto;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<Producto> miCarrito;
    private List<Producto> productosStock;


    public Data() {
        productosStock = new ArrayList<>();
        agregarProductoStock(new Producto("Leche", 8, 1001, 1500));
        agregarProductoStock(new Producto("Fideos", 14, 1002, 1450));
        agregarProductoStock(new Producto("Manzanas", 34, 1003, 550));
        agregarProductoStock(new Producto("Helado", 15, 1004, 975));
        agregarProductoStock(new Producto("Queso", 7, 1005, 3400));
        agregarProductoStock(new Producto("Botella de agua", 1, 1007, 875));
        miCarrito = new ArrayList<>();
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

    public void agregarProductoStock(Producto producto) {
        productosStock.add(producto);
    }

    public void agregarProductoCarrito(Producto producto) {
        miCarrito.add(producto);
    }
}
