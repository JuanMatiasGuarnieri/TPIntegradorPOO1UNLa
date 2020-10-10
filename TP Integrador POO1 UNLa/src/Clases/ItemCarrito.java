package Clases;

public class ItemCarrito {

    private Articulo articulo;
    private int cantidad;

    //----------constructor----------
    public ItemCarrito(Articulo articulo, int cantidad) {
        super();
        this.articulo = articulo;
        this.cantidad = cantidad;
    }

    //----------getters y setters----------
    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //---------- to string ----------
    @Override
    public String toString() {
        // return "ItemCarrito [articulo=" + articulo + ", cantidad=" + cantidad + "]\n ";
        return articulo + "\n\ncantidad = " + cantidad;
    }

    //----------metodos----------
    public double calcularSubTotalItem() {
        return (articulo.getPrecio() * cantidad);
    }
    //Seleccionar/agregar Articulo
}
