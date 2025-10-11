package cr.ac.cenfotec.rojas.jandier.bl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
    * Clase Main: Punto de entrada del sistema
    * Conceptos OOP
    *
    * 1. MODULARIDAD
    *    -Separación clara entre interfaz de usuario y logica de negocio en Carrito y Tienda.
    *    -Método menuAcciones encapsula toda la lógica del menu
    *
    * 2. RELACIONES
    *    -Dependencia con Tienda y Carrito: Los crea y usa pero no los almacena como atributos
    *    -Asociacion: Coordina la interaccion entre Tienda y Carrito */
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        menuAcciones();
    }


    public static void menuAcciones() throws IOException {
        int opcion;
        Tienda tienda = new Tienda();
        Carrito carrito = new Carrito();

        do {
            System.out.println();
            System.out.println("""
                    Elija una opcion:
                    -1. Mostrar productos de la tienda
                    -2. Agregar producto a mi carrito
                    -3. Eliminar producto de mi carrito
                    -4. Mostrar contenido de mi carrito
                    -5. Pagar productos e imprimir factura
                    -0. Salir""");
            System.out.println();

            opcion = Integer.parseInt(in.readLine());

            switch (opcion) {
                case 1 -> tienda.mostrarStock();
                case 2 -> carrito.agregarProducto(tienda);
                case 3 -> carrito.eliminarProducto(tienda);
                case 4 -> carrito.imprimirCarrito();
                case 5 -> tienda.imprimirFactura(carrito);
                case 0 -> System.exit(0);
                default -> System.out.println("Valor invalido!!!");
            }
        } while (opcion != 0);
    }
}
