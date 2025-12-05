package cr.ac.cenfotec.rojas.jandier.bl.entities;

import cr.ac.cenfotec.rojas.jandier.bl.logic.GestionStockTienda;

public abstract class Producto implements Categorizable, Descuentable{

    /*
    * Clase Producto: Representa un producto de la tienda
    * Conceptos POO aplicados
    * 1. ABSTRACCION
    *    -Esta clase modela las características esenciales de un producto, necesarias para
    *     simular un producto en una tienda como en este contexto
    *    -Solo incluye los atributos esenciales: nombre, cantidad, id, precio
    *
    * 2. ENCAPSULAMIENTO
    *    -Todos los atributos son privados
    *    -Se acceden a ellos mediante getters y setters públicos
    *    -Esto protege la integridad de los datos y permite control sobre su modificación*/

    private String nombre;
    private int cantidad;
    private int id;
    private double precio;
    private boolean contieneProductoAnimal;
    private GestionStockTienda gestionStockTienda = new GestionStockTienda();



    public Producto(String nombre, int cantidad, int id, double precio, boolean contieneProductoAnimal) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.id = id;
        this.precio = precio;
        this.contieneProductoAnimal = contieneProductoAnimal;
    }

    public Producto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public abstract double calcularDescuento();

    public abstract String getCategoria();

    public double calcularPrecioFinal() {
        return precio - calcularDescuento();
    }

    @Override
    public String toString() {
        return "Producto -> " +
                "Nombre -> " + nombre + '\n' +
                "Cantidad -> " + cantidad + '\n' +
                "Categoria -> " + getCategoria() + '\n' +
                "ID -> #" + id + '\n' +
                "Precio -> " + precio + '\n';
    }

    @Override
    public boolean esVegano(int id) {
        return !contieneProductoAnimal;
    }

    @Override
    public boolean tieneDescuento(int id) {
        if (gestionStockTienda.buscarProducto(id).cantidad < 50) {
            return true;
        }
        return false;
    }

    /*
    Conceptos aplicados:
    -1. Esta clase es una clase padre que da herencia a sus clases hijas.
    -2. Esta clase es abstracta y posee metodos abstractos para ser implementados de maneras diferentes en sus clases hijas.
     */
}
