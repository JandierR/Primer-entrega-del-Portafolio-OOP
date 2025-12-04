package cr.ac.cenfotec.rojas.jandier.bl.entities;

public class Producto {

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


    public Producto(String nombre, int cantidad, int id, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.id = id;
        this.precio = precio;
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
}
