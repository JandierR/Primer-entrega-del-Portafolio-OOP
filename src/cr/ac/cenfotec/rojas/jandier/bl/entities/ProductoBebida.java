package cr.ac.cenfotec.rojas.jandier.bl.entities;

public class ProductoBebida extends Producto {

    private boolean esGaseosa;

    public ProductoBebida(String nombre, int cantidad, int id, double precio, boolean esGaseosa) {
        super(nombre, cantidad, id, precio);
        this.esGaseosa = esGaseosa;
    }

    public ProductoBebida() {
    }

    //Este es un metodo sobreescrito que representa el concepto de sobre-escritura de metodos
    //Esta sobre-escritura de métodos se da gracias a la herencia que recibe esta clase hija de su clase padre "Producto"
    //Además, es visible que se hereda de una clase abstracta (producto) y por ende un metodo abstracto (calcularDescuento), para implementar metodos con funciones unicas.
    @Override
    public double calcularDescuento() {
        if (esGaseosa) {
            return getPrecio() * 0.15;
        }
        return 0;
    }


    @Override
    public String getCategoria() {
        return "Bebida";
    }

    public boolean isEsGaseosa() {
        return esGaseosa;
    }

    public void setEsGaseosa(boolean esGaseosa) {
        this.esGaseosa = esGaseosa;
    }

    /*
    Conceptos en esta clase:
    -1. Herencia: Esta clase hija hereda de su clase padre "Producto"
    -2. Polimorfismo: Diferentes implementaciones de métodos abstractos.
     */
}
