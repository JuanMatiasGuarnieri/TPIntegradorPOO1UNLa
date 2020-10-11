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
		return "\nItemCarrito [ " + articulo + ", cantidad = " + cantidad +", Subtotal = "+ calcularSubTotalItem() + "]";
	}
	
	public boolean equals(ItemCarrito itemCarrito) {
		return (articulo==itemCarrito.getArticulo() && (cantidad==itemCarrito.getCantidad()));
	}
	
	//Lo voy a usar despues en calcularTotalCarrito
	//cantidad * precio del getArticulo()
	public double calcularSubTotalItem() {
		double subTotal=articulo.getPrecio()*cantidad;
		return subTotal;
	}
    //Seleccionar/agregar Articulo
}
