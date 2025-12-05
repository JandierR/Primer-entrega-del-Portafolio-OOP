package cr.ac.cenfotec.rojas.jandier.bl.entities;

public class ProductoAlimenticio extends Producto {
    private boolean esPerecible;

    public ProductoAlimenticio(String nombre, int cantidad, int id, double precio, boolean esPerecible) {
        super(nombre, cantidad, id, precio);
        this.esPerecible = esPerecible;
    }

    public ProductoAlimenticio() {
    }

    //Este es un metodo sobreescrito que representa el concepto de sobre-escritura de metodos
    //Esta sobre-escritura de métodos se da gracias a la herencia que recibe esta clase hija de su clase padre "Producto"
    //Además, es visible que se hereda de una clase abstracta (producto) y por ende un metodo abstracto (calcularDescuento), para implementar metodos con funciones unicas.
    @Override
    public double calcularDescuento() {
        if (esPerecible) {
            return getPrecio() * .10;

        }
        return -1;
    }

    @Override
    public boolean tieneDescuento(int id) {
        return super.tieneDescuento(id);
    }

    @Override
    public String getCategoria() {
        return "Alimenticio";
    }

    public boolean isEsPerecible() {
        return esPerecible;
    }

    public void setEsPerecible(boolean esPerecible) {
        this.esPerecible = esPerecible;
    }
    /*
    Conceptos en esta clase:
    -1. Herencia: Esta clase hija hereda de su clase padre "Producto"
    -2. Polimorfismo: Diferentes implementaciones de métodos abstractos.
     */
}
