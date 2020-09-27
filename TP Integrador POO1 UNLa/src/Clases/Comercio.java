package Clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Comercio extends Actor {
    private String nombreComercio;
    private long cuit;
    private double costoFijo;
    private double costoPorKm;
    private int diaDescuento;
    private int porcentajeDescuentoDia;
    private int porcentajeDescuentoEfectivo;
    private List<DiaRetiro> lstDiaRetiro;
    private List<Carrito> lstCarrito;
    private List<Articulo> lstArticulo;

    //----------constructor----------
    public Comercio(int id, Contacto contacto, String nombreComercio, long cuit, double costoFijo, double costoPorKm,
                    int diaDescuento, int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo) throws Exception {
        super(id, contacto);
        this.nombreComercio = nombreComercio;
        setCuit(cuit);
        this.costoFijo = costoFijo;
        this.costoPorKm = costoPorKm;
        this.diaDescuento = diaDescuento;
        this.porcentajeDescuentoDia = porcentajeDescuentoDia;
        this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;
        this.lstDiaRetiro = new ArrayList<DiaRetiro>();
        this.lstCarrito = new ArrayList<Carrito>();
        this.lstArticulo = new ArrayList<Articulo>();
    }

    //----------getters y setters----------
    public String getNombreComercio() {
        return nombreComercio;
    }

    public void setNombreComercio(String nombreComercio) {
        this.nombreComercio = nombreComercio;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) throws Exception {
        if (validarIdentificadorUnico(cuit)) {
            this.cuit = cuit;
        }
    }

    public double getCostoFijo() {
        return costoFijo;
    }

    public void setCostoFijo(double costoFijo) {
        this.costoFijo = costoFijo;
    }

    public double getCostoPorKm() {
        return costoPorKm;
    }

    public void setCostoPorKm(double costoPorKm) {
        this.costoPorKm = costoPorKm;
    }

    public int getDiaDescuento() {
        return diaDescuento;
    }

    public void setDiaDescuento(int diaDescuento) {
        this.diaDescuento = diaDescuento;
    }

    public int getPorcentajeDescuentoDia() {
        return porcentajeDescuentoDia;
    }

    public void setPorcentajeDescuentoDia(int porcentajeDescuentoDia) {
        this.porcentajeDescuentoDia = porcentajeDescuentoDia;
    }

    public int getPorcentajeDescuentoEfectivo() {
        return porcentajeDescuentoEfectivo;
    }

    public void setPorcentajeDescuentoEfectivo(int porcentajeDescuentoEfectivo) {
        this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;
    }

    public List<DiaRetiro> getLstDiaRetiro() {
        return lstDiaRetiro;
    }

    public void setLstDiaRetiro(List<DiaRetiro> lstDiaRetiro) {
        this.lstDiaRetiro = lstDiaRetiro;
    }

    public List<Carrito> getLstCarrito() {
        return lstCarrito;
    }

    public void setLstCarrito(List<Carrito> lstCarrito) {
        this.lstCarrito = lstCarrito;
    }

    public List<Articulo> getLstArticulo() {
        return lstArticulo;
    }

    public void setLstArticulo(List<Articulo> lstArticulo) {
        this.lstArticulo = lstArticulo;
    }

//----------metodos----------

    //validar dni y cuit
    protected boolean validarIdentificadorUnico(long identificador) {

        return true;
    }

    //Articulos
    public Articulo traerArticuloPorId(int idArticulo) {
        Articulo resultado = null;
        for (Articulo art : this.lstArticulo) {
            if (art.getId() == idArticulo) {
                resultado = art;
            }
        }
        return resultado;
    }

    public Articulo traerArticuloPorCodBarras(String codBarras) {
        Articulo resultado = null;
        for (Articulo art : this.lstArticulo) {
            if (art.getCodBarras().equalsIgnoreCase(codBarras)) {
                resultado = art;
            }
        }
        return resultado;
    }

    public void agregarArticulosLstArticulos(String nombre, String codBarras, double precio) throws Exception {

        if (lstArticulo.size() == 0) {
            lstArticulo.add(new Articulo(1, nombre, codBarras, precio));
        }
        if (traerArticuloPorCodBarras(codBarras) == null) {
            lstArticulo.add(new Articulo(lstArticulo.get(lstArticulo.size() - 1).getId() + 1, nombre, codBarras, precio));
        }
    }

    //carritos
    public Carrito traerCarritoPorCliente(Cliente cliente) {
        Carrito tieneCarrito = null;
        for (Carrito car : lstCarrito) {
            if (car.getCliente().getDni() == cliente.getDni()) {
                tieneCarrito = car;
            }
        }
        return tieneCarrito;
    }

    public boolean verificarCarritosCerrados(Cliente cliente) {
        boolean carritosCerrados = false;
        for (Carrito car : lstCarrito) {
            if (car.getCliente().getDni() == cliente.getDni()) {
                if (car.getCerrado()) {
                    carritosCerrados = true;
                }
            }
        }
        return carritosCerrados;
    }

    public void agregarCarritoLstCarritos(Cliente cliente) throws Exception {

        if (lstCarrito.size() == 0) {
            lstCarrito.add(new Carrito(1, LocalDate.now(), LocalTime.now(), false, 0, cliente, null));
            System.out.println("carrito creado");
        } else if ((traerCarritoPorCliente(cliente) != null && verificarCarritosCerrados(cliente) == true) || (traerCarritoPorCliente(cliente) == null)) {
            lstCarrito.add(new Carrito(lstCarrito.get(lstCarrito.size() - 1).getId() + 1, LocalDate.now(), LocalTime.now(), false, 0, cliente, null));
        } else {
            throw new Exception("Cierre primero sus Carritos!");
        }
    }

    public void eliminarCarritoAbierto(long dni) {
        for (Carrito c : lstCarrito) {
            if (c.getCliente().getDni() == dni) {
                if (c.getCerrado() == true) {
                    lstCarrito.remove(c);
                }
            }
        }
    }

}
