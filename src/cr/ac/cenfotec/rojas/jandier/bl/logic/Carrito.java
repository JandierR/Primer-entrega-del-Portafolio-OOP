package cr.ac.cenfotec.rojas.jandier.bl.logic;

import cr.ac.cenfotec.rojas.jandier.bl.entities.Producto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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

    private List<Producto> miCarrito = new ArrayList<>();

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


    public Carrito() {
    }

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

        //Se solicita al usuario el ID del producto
        System.out.print("Ingrese el ID del producto dentro de su carrito que desea eliminar: ");

        //Se lee el ID del producto ingresado por el usuario y se almacena en la variable id
        int id = Integer.parseInt(in.readLine());

        //Se obtiene una referencia al producto con el producto que retorna la metodo de buscarProductoId(id)
        //Con el anterior id como argumento
        Producto producto = tienda.buscarProductoId(id);

        //Se valida que producto no sea nulo y que carrito contenga el producto
        if (producto != null && miCarrito.contains(producto)) {

            //Si la condicion se cumple:
            //El producto se elimina de la lista miCarrito
            miCarrito.remove(producto);

            //Despues ese producto se devuelve al stock, utilizando su id
            tienda.devolverStock(id);

            //Finalmente se imprime un mensaje de la accion realizada
            System.out.println(producto.getNombre() + " fue eliminado de su carrito");
        } else {

            //Si no se cumple la anterior condicion, significa que no hay ningun producto con tal id en el carrito
            //Por lo que se imprime tal mensaje
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
