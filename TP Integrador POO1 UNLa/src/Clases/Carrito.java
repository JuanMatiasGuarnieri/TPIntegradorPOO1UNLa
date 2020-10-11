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

    public String mostrarListaDeItemsCarrito() {
        String articulos = " ";
        for(ItemCarrito arti : lstItemCarrito) {
            articulos += arti.toString();
        }

        return "\nLos Articulos del carrito son:\n"+articulos;
    }

    public ItemCarrito traerItemPorId(Articulo articulo) {
        ItemCarrito itemObtenido=null;
        for(ItemCarrito i : lstItemCarrito) {
            if(i.getArticulo().getId()==articulo.getId()) {
                itemObtenido=i;
            }
        }
        return itemObtenido;
    }

    public boolean agregarAlCarrito(Articulo articulo, int cantidad) {
        boolean agregado = false;

        if(traerItemPorId(articulo) != null) {
            int suma = traerItemPorId(articulo).getCantidad()+cantidad;
            traerItemPorId(articulo).setCantidad(suma);
            agregado=true;
        }

        if(!agregado) {
            this.lstItemCarrito.add(new ItemCarrito(articulo, cantidad));
        }
        return agregado;
    }

    public boolean sacarDelCarrito(Articulo articulo, int cantidad) {
        boolean eliminado = false;
        for (ItemCarrito carro : lstItemCarrito) {
            if (carro.getArticulo().getId() == articulo.getId()) {
                int resta = (carro.getCantidad() - cantidad);
                if (resta <= 0) {
                    this.lstItemCarrito.remove(carro);
                    eliminado = true;
                } else {
                    carro.setCantidad(resta);
                }
            }
        }
        return eliminado;
    }

    /*
    // Ya habia uno de estos en Comercio, que verga hice?
    public LocalTime traerHoraRetiro(LocalDate fecha) throws Exception {
        // "el método traerHoraRetiro lo habíamos pensado originalmente
        // para recuperar la hora de retiro de un carrito en particular.
        // Con eso podrías armar una lista de turnos ocupados
        // para marcar en la agenda."
        // ??????????????????????????
        // Que funcion cumple entonces "fecha" si solo es para traer la hora de retiro de un carrito???
        if (!(this.entrega instanceof RetiroLocal)) {
            throw new Exception("Este carrito no tiene fecha de retiro!");
        }
        RetiroLocal e = (RetiroLocal)getEntrega();
        return e.getHoraEntrega();
    }
    */

}
