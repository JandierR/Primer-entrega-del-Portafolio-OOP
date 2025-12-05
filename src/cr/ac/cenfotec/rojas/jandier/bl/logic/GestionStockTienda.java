package cr.ac.cenfotec.rojas.jandier.bl.logic;

import cr.ac.cenfotec.rojas.jandier.bl.entities.Producto;
import cr.ac.cenfotec.rojas.jandier.dl.Data;

import java.io.IOException;

public class GestionStockTienda {

    /*CLASE TIENDA: Gestiona los productos en stock

    CONCEPTOS DE OOP APLICADOS

    -1. ABSTRACCIÓN
        -Esta clase modela las acciones dentro de la administración de una tienda en el mundo real.
        -Presenta métodos como acciones dentro de la tienda: agregar stock, eliminar stock, devolver stock, mostrar stock, buscar productos, escanear productos e imprimir factura.
        -Oculta detalles de su implementación.

     -2. ENCAPSULAMIENTO
         -productosStock es privado y es solamente accessible mediante métodos públicos controlados.

     -3. MODULARIDAD
         -Cada método tiene una estructura y función definida.
         -agregarStock() inicializa el inventario de la tienda.
         -eliminarStock() elimina productos del inventario de la tienda al ser elegido por un cliente.
         -buscarProductoId() busca productos mediante su ID
         -escanearProductos() calcula el total de los productos y su precio
         -imprimirFactura() imprime la factura del cliente con sus productos y total a pagar.

      -4. RELACIONES
          -Composición: la tienda crea y gestiona sus productos.
          -Los productos no tienen sentido sin la tienda en este contexto.
          -Asociación con carrito: interactúa con carrito pero no lo contiene.
          -Dependencia con carrito: Recibe a carrito como parámetro en algunos metodos.

      -5. SOBRECARGA: Multiples versiones de metodos como buscarProducto()

    */


    private Data data;

    public GestionStockTienda(Data data) {
        this.data = data;
    }

    public GestionStockTienda() {
    }

    public void eliminarStock(int id) throws IOException {
        Producto producto = buscarProducto(id);
        //Este if verifica si producto existe con el null
        if (producto != null) {
            //Modifico la cantidad del producto restandole 1
            producto.setCantidad(producto.getCantidad() - 1);
        }
    }

    public void devolverStock(int id) throws IOException {
        Producto producto = buscarProducto(id);

        if (producto != null) {
            producto.setCantidad(producto.getCantidad() + 1);
        }
    }


    public Producto buscarProducto(int id) {
        for (Producto producto : data.getProductosStock()) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    //Este segundo método llamado buscarProducto en relación con el anterior método, representa sobrecarga de metodos.
    //Ambos métodos tienen una firma similar. Aunque compartan el mismo nombre y tipo de dato a retornar, ambos reciben parametros diferentes.
    public Producto buscarProducto(String nombre) {
        for (Producto producto : data.getProductosStock()) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public double escanearProductos() {
        double total = 0;

        //Cada producto de la lista miCarrito se le va a sumar el precio al total.
        for (Producto producto : data.getMiCarrito()) {
            total += producto.getPrecio();
            if (producto.tieneDescuento(producto.getId())) {
                double descuento = producto.getPrecio() * .20;
                total -= descuento;
            }
        }
        return total;
    }


}
