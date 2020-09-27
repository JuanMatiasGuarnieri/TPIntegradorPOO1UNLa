package Clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private int id;
    private LocalDate fecha;
    private LocalTime hora;
    private boolean cerrado;
    private double descuento;
    private Cliente cliente;
    private List<ItemCarrito> lstItemCarrito;
    private Entrega entrega;

    //----------constructor----------
    public Carrito(int id, LocalDate fecha, LocalTime hora, boolean cerrado, double descuento, Cliente cliente,
                   Entrega entrega) {
        super();
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.cerrado = cerrado;
        this.descuento = descuento;
        this.cliente = cliente;
        this.entrega = entrega;
        this.lstItemCarrito = new ArrayList<ItemCarrito>();
    }

    //----------getters y setters----------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public boolean getCerrado() {
        return cerrado;
    }

    public void setCerrado(boolean cerrado) {
        this.cerrado = cerrado;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemCarrito> getLstItemCarrito() {
        return lstItemCarrito;
    }

    public void setLstItemCarrito(List<ItemCarrito> lstItemCarrito) {
        this.lstItemCarrito = lstItemCarrito;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }


//----------metodos----------

    public String mostrameListaDeItemsCarrito() {
        String articulos = " ";
        for (ItemCarrito s : lstItemCarrito) {
            articulos += s.toString();
        }

        return "Tus Articulos son:\n" + articulos;
    }

    //buscar Articulo
//agregar item al carrito
    public boolean agregarAlCarrito(Articulo articulo, int cantidad) {
        boolean agregado = false;
        for (ItemCarrito s : lstItemCarrito) {
            if (s.getArticulo().getId() == articulo.getId()) {
                int sum = s.getCantidad() + cantidad;
                s.setCantidad(sum);
                agregado = true;
            }
        }
        if (agregado == false) {
            if (lstItemCarrito == null) {
                List<ItemCarrito> aux = new ArrayList<ItemCarrito>();
                setLstItemCarrito(aux);
                this.lstItemCarrito.add(new ItemCarrito(articulo, cantidad));
            } else {
                this.lstItemCarrito.add(new ItemCarrito(articulo, cantidad));
            }
            //resultado = true;
        }
        return agregado;
    }

    //eliminar Item
    public boolean sacarDelCarrito(Articulo articulo, int cantidad) {
        boolean eliminado = false;
        for (ItemCarrito s : lstItemCarrito) {
            if (s.getArticulo().getId() == articulo.getId()) {
                int resta = (s.getCantidad() - cantidad);
                if (resta <= 0) {
                    this.lstItemCarrito.remove(s);
                    eliminado = true;
                } else {
                    s.setCantidad(resta);
                }
            }
        }
        return eliminado;
    }

    //10) + calcularTotalCarrito() : doble
    public double calcularTotalCarrito() {
        double resultado = 0;
        for (ItemCarrito s : lstItemCarrito) {
            resultado += s.calcularSubTotalItem();
        }
        return resultado;
    }

    //10) + calcularDescuentoPorCantidad(double porcentajeDescuentoDia): double
/*public double calcularDescuentoPorCantidad(double porcentajeDescuentoDia) {
	double resultado=0;

		int cantidad= s.getCantidad()/2;
		resultado+= (cantidad*s.getArticulo().getPrecio()*porcentajeDescuentoDia)/100;
	}
	return resultado;
}*/
//11) + calcularDescuentoDia (int diaDescuento, double porcentajeDescuentoDia):double
    public double calcularDescuentoDia(int diaDescuento, double porcentajeDescuentoDia) {
        double resultado = 0;
        if (fecha.getDayOfWeek().getValue() == diaDescuento) {
            for (ItemCarrito s : lstItemCarrito) {

                int cantidad = s.getCantidad() / 2;
                resultado += (cantidad * s.getArticulo().getPrecio() * porcentajeDescuentoDia) / 100;
            }
        }
        return resultado;
    }

    //12) + calcularDescuentoEfectivo (double porcentajeDescuentoEfectivo): double
    public double calcularDescuentoEfectivo(double porcentajeDescuentoEfectivo) {
        return ((calcularTotalCarrito() * porcentajeDescuentoEfectivo) / 100);
    }

    //13) + calcularDescuentoCarrito (int diaDescuento, double porcentajeDescuento, double porcentajeDescuentoEfectivo) //determina cual es el descuento mayor
    public void calcularDescuentoCarrito(int diaDescuento, double porcentajeDescuento, double porcentajeDescuentoEfectivo) {
        double resultado = 0;
        if (calcularDescuentoDia(diaDescuento, porcentajeDescuento) > calcularDescuentoEfectivo(porcentajeDescuentoEfectivo)) {
            resultado = calcularDescuentoDia(diaDescuento, porcentajeDescuento);
        } else {
            resultado = calcularDescuentoEfectivo(porcentajeDescuentoEfectivo);
        }
        setDescuento(resultado);
    }

    //15) + totalAPagarCarrito() : double
    public double totalAPagarCarrito() {
        return (calcularTotalCarrito() - getDescuento());
    }

}
