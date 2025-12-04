package cr.ac.cenfotec.rojas.jandier.bl.entities;

public class ProductoLacteo extends Producto{
    private boolean esDeVaca;


    public ProductoLacteo(String nombre, int cantidad, int id, double precio, boolean esDeVaca) {
        super(nombre, cantidad, id, precio);
        this.esDeVaca = esDeVaca;
    }

    public ProductoLacteo() {
    }

    //Este es un metodo sobreescrito que representa el concepto de sobre-escritura de metodos
    //Esta sobre-escritura de métodos se da gracias a la herencia que recibe esta clase hija de su clase padre "Producto"
    //Además, es visible que se hereda de una clase abstracta (producto) y por ende un metodo abstracto (calcularDescuento), para implementar metodos con funciones unicas.
    @Override
    public double calcularDescuento() {
        if (esDeVaca) {
            return getPrecio() + .5;
        }
        return -1;
    }

    @Override
    public String getCategoria() {
        return "Lácteo";
    }

    public boolean isEsDeVaca() {
        return esDeVaca;
    }

    public void setEsDeVaca(boolean esDeVaca) {
        this.esDeVaca = esDeVaca;
    }
    /*
    Conceptos en esta clase:
    -1. Herencia: Esta clase hija hereda de su clase padre "Producto"
    -2. Polimorfismo: Diferentes implementaciones de métodos abstractos.
     */
}
