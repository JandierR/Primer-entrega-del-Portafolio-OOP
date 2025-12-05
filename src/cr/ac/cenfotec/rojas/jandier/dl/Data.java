package cr.ac.cenfotec.rojas.jandier.dl;

import cr.ac.cenfotec.rojas.jandier.bl.entities.Producto;
import cr.ac.cenfotec.rojas.jandier.bl.entities.ProductoAlimenticio;
import cr.ac.cenfotec.rojas.jandier.bl.entities.ProductoBebida;
import cr.ac.cenfotec.rojas.jandier.bl.entities.ProductoLacteo;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<Producto> miCarrito;
    private List<Producto> productosStock;


    public Data() {
        productosStock = new ArrayList<>();
        agregarProductoStock(new ProductoLacteo("Leche", 8, 1001, 1500, true, true));
        agregarProductoStock(new ProductoAlimenticio("Fideos", 14, 1002, 1450, true, true));
        agregarProductoStock(new ProductoAlimenticio("Manzanas", 34, 1003, 550,false,true));
        agregarProductoStock(new ProductoLacteo("Helado", 15, 1004, 975,true,true));
        agregarProductoStock(new ProductoLacteo("Queso", 7, 1005, 3400,true,true));
        agregarProductoStock(new ProductoBebida("Botella de agua", 1, 1007, 875,false,false));
        agregarProductoStock(new ProductoBebida("Coca Cola", 6, 1008, 1550,true,true));
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
