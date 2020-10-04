package Clases;

//import com.sun.istack.internal.NotNull;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import Clases.DiaRetiro;

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

    public LocalTime traerHoraRetiro(LocalDate fordate) throws Exception {
        // Que se supone que tengo que hacer aca??????????
        // Asumo que tengo que iterar por lstDiaRetiro
        // y devolver la primera hora disponible para dado dia de la semana,
        // o tirar una excepcion en caso contrario
        LocalTime soonestTime = null;
        DayOfWeek forweekday = fordate.getDayOfWeek();
        for (DiaRetiro when: this.lstDiaRetiro) {
            DayOfWeek retiroDay = DayOfWeek.of(when.getDiaSemana());
            if (forweekday == retiroDay && (soonestTime == null || when.getHoraDesde().isBefore(soonestTime))) {
                soonestTime = when.getHoraDesde();
            }
        }
        if (soonestTime == null) throw new Exception("No existe intervalo de retiro para este dia de la semana lol");
        return soonestTime;
    }

    /**
     * Un metodo que hace algo
     *
     * @param weekday No se
     */
    public List<Turno> generarTurnos(DayOfWeek weekday) {
        // Genera turnos para un determinado dia a partir de lstDiaRetiro
        // ej: weekday = jueves
        List<Turno> turnos = new ArrayList<Turno>();
        List<Carrito> changuitos = new ArrayList<Carrito>();
        LocalDate proximamente = LocalDate.now();
        while (proximamente.getDayOfWeek() != weekday) {
            // ej: hoy es lunes
            // ej: Si esta instancia de LocalDate (lunes) no es weekday (jueves),
            // incrementar este LocalDate un total de 1 dia, y revisar si representa un jueves.
            // Repetir hasta que lo sea :)
            proximamente = proximamente.plusDays(1);
        }
        // popular [changuitos] con carritos que poseen RetiroLocal y cuya entrega sera en fecha [proximamente]
        for (Carrito car : lstCarrito) {
            if (car.getEntrega() instanceof RetiroLocal) {
                Entrega e = car.getEntrega();
                if (e.getFecha().equals(proximamente)) changuitos.add(car);
            }
        }
        for (DiaRetiro ret : lstDiaRetiro) {
            // int id, int diaSemana, LocalTime horaDesde, LocalTime horaHasta, int intervalo
            if (DayOfWeek.of(ret.getDiaSemana()) == weekday) {
                // Operar con este DiaRetiro solo si es para el dia a buscar (jueves)
                for (LocalTime tshift = ret.getHoraDesde();
                     tshift.isAfter(ret.getHoraHasta());
                     tshift = tshift.plusMinutes(ret.getIntervalo())) {
                    Turno turno = new Turno(proximamente, tshift, false);
                    for (Carrito chn : changuitos) { // Ya se que estos tienen entrega de tipo RetiroLocal y son para hoy :))
                        RetiroLocal rl = (RetiroLocal) chn.getEntrega();
                        if (rl.getHoraEntrega().equals(tshift)) turno.setOcupado(true);
                    }
                }
            }
        }
        return turnos;
    }

    public List<Turno> generarTurnosLibres(LocalDate fecha) {
        List<Turno> all = generarTurnos(fecha.getDayOfWeek());
        List<Turno> proper = new ArrayList<Turno>();
        for (Turno t : all) {
            if (!t.isOcupado()) proper.add(t);
        }
        return proper;
    }

    public List<Turno> traerTurnosOcupados(LocalDate fecha) {
        List<Turno> all = generarTurnos(fecha.getDayOfWeek());
        List<Turno> proper = new ArrayList<Turno>();
        for (Turno t : all) {
            if (t.isOcupado()) proper.add(t);
        }
        return proper;
    }

    public List<Turno> generarAgenda(LocalDate fecha) {
        System.out.println("Agenda para "+(fecha.getDayOfWeek().toString())+" "+(fecha.getDayOfMonth()));
        // Codigo para imprimir va aca
        return generarTurnos(fecha.getDayOfWeek());
    }

    // LOS CUATRO METODOS ARRIBA ESTAN SIN PROBAR.

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

    public DiaRetiro traerDiaRetiroPorId (int idDiaRetiro) {
    	DiaRetiro resultado = null;
        for (DiaRetiro dr : this.lstDiaRetiro) {
            if (dr.getId() == idDiaRetiro) {
                resultado = dr;
            }
        }
        return resultado;
    }
    
    public boolean agregarDiaRetiroLstDiaRetiro (int id,int diaSemana, LocalTime horaDesde,LocalTime horaHasta, int intervalo) throws Exception {

    	if(traerDiaRetiro(id)!=null) throw new Exception("Error: dia ya existente");
		//int id = 0;
		if(lstDiaRetiro.size() != 0) {
			id = lstDiaRetiro.get(lstDiaRetiro.size()-1).getId()+1;
		}
		lstDiaRetiro.add(new DiaRetiro(id, diaSemana, horaDesde,horaHasta,intervalo));
		return true;
	}
    
    
    
    public DiaRetiro traerDiaRetiro(int idRetiro) {
		for(DiaRetiro d: lstDiaRetiro) {
			if (d.getId() == idRetiro) {
				return d;
			}
		}
		return null;
	}
    
    
}
