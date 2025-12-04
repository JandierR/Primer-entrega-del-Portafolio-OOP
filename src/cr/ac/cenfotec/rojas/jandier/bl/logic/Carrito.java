package cr.ac.cenfotec.rojas.jandier.bl.logic;

import cr.ac.cenfotec.rojas.jandier.bl.entities.Producto;
import cr.ac.cenfotec.rojas.jandier.dl.Data;

import java.io.IOException;

public class Carrito {

    /*
    * Clase Carrito: Gestiona los productos seleccionados por el cliente
    *
    * 1. ABSTRACCION
    *    -Modela el concepto de un carrito de compras:
    *    -Presenta operacions signficativas: agregar, eliminar, imprimir.
    *    -Oculta implementacion interna
    *
    * 2. ENCAPSULAMIENTO
    *    -miCarrito es privado, solo accesible mediante getMiCarrito()
    *    -BufferedReader es privado
    *
    * 3. MODULARIDAD
    *    -Cada metodo tiene una responsabilidad unica y clara
    *    -agregarProducto() solo agrega productos
    *    -eliminarProducto() elimina
    *    -imprimirCarrito() muestra
    *
    * 4. RELACIONES
    *    -Agregacion con Producto: el carrito contiene productos, pero los productos pueden existir
    *     independientemente en la tienda.
    *    -Dependencia con Tienda: utiliza metodos de tienda pero no la almacena
    * */

//    private List<Producto> miCarrito = new ArrayList<>();

//    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private Data data;
    private Tienda tienda;
    ;

    public Carrito(Data data, Tienda tienda) {
        this.data = data;
        this.tienda = tienda;
    }




    public String agregarProducto(Producto producto, int id) throws IOException {

        if (producto != null && producto.getCantidad() > 0) {
            data.agregarProductoCarrito(producto);
            tienda.eliminarStock(id);
            return producto.getNombre() + " agregado exitosamente a mi carrito!";
        }
            return  "El producto con el ID = #" + id  + " no existe!";
    }

    public String eliminarProducto(Producto producto, int id) throws IOException {


        //Se valida que producto no sea nulo y que carrito contenga el producto
        if (producto != null && data.getMiCarrito().contains(producto)) {

            //Si la condicion se cumple:
            //El producto se elimina de la lista miCarrito
            data.getMiCarrito().remove(producto);

            //Despues ese producto se devuelve al stock, utilizando su id
            tienda.devolverStock(id);

            //Finalmente se imprime un mensaje de la accion realizada
            return producto.getNombre() + " fue eliminado de su carrito";
        } else {

            //Si no se cumple la anterior condicion, significa que no hay ningun producto con tal id en el carrito
            //Por lo que se imprime tal mensaje
            return ("El producto con el ID = #" + id + " no existe en su carrito");
        }
    }
}
