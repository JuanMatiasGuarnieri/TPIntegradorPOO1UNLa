package Clases;

//import com.sun.istack.internal.NotNull;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
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

    public void setCuit(long cuit)throws Exception {
		if(validarIdentificadorUnico(cuit)==true) {
			this.cuit = cuit;
		}
		else {throw new Exception("CUIT del comercio no valido");}
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

    private void ordenarTurnos(List<Turno> turnos) {
        // Ordena turnos por hora de forma ascendente (temprano antes)
        // Podria usar collections.sort, o...
        boolean ordenado = false;
        while (ordenado = false) {
            ordenado = true; //lol
            for (int i = 0; i < turnos.size()-1; i++) {
                Turno t1 = turnos.get(i  );
                Turno t2 = turnos.get(i+1);
                if ( t1.getHora().isAfter( t2.getHora() ) ) {
                    ordenado = false;
                    turnos.set(i  , t2); // swap
                    turnos.set(i+1, t1); // swap
                }
            }
        } // Repetir hasta que no se hagan intercambios
    }

    /**
     * Un metodo que hace algo
     *
     * @param weekday No se
     */
    public List<Turno> generarTurnos(DayOfWeek weekday) {
        // Genera turnos para un determinado dia futuro a partir de lstDiaRetiro
        // ej: weekday = jueves
        List<Turno> turnos = new ArrayList<Turno>();
        List<Carrito> changuitos = new ArrayList<Carrito>();
        LocalDate proximamente = LocalDate.now();
        while (proximamente.getDayOfWeek() != weekday) {
            // ej: hoy es lunes
            // ej: Si esta instancia de LocalDate (lunes) no es weekday (jueves),
            // incrementar este LocalDate un total de 1 dia, y revisar si representa un jueves.
            // Repetir hasta que lo sea :)
            // (no tengo .of(DayOfWeek) asi que...)
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
                     tshift.isBefore(ret.getHoraHasta().plusNanos(1));
                     tshift = tshift.plusMinutes(ret.getIntervalo())) {
                    // System.out.println("DEBUG: 3");
                    Turno turno = new Turno(proximamente, tshift, false);
                    for (Carrito chn : changuitos) { // Ya se que estos tienen entrega de tipo RetiroLocal y son para hoy :)
                        // RetiroLocal rl = (RetiroLocal) chn.getEntrega();
                        // if (rl.getHoraEntrega().equals(tshift)) turno.setOcupado(true);
                        try {
                            if (chn.traerHoraRetiro(null).equals(tshift)) turno.setOcupado(true);
                        } catch (Exception e) {
                            // lol.
                            System.out.println(e.getMessage());
                        }
                    }
                    turnos.add(turno);
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
        List<Turno> t = generarTurnos(fecha.getDayOfWeek());
        ordenarTurnos(t);
        return t;
    }

    public void imprimirAgenda(LocalDate fecha) {
        System.out.println("Agenda para "+(fecha.getDayOfWeek().toString())+" "+(fecha.getDayOfMonth()));
        List<Turno> all = generarAgenda(fecha);
        for (Turno t : all) {
            System.out.println(t.toString());
        }
    }

    //validar dni y cuit
    protected boolean validarIdentificadorUnico (long identificador) {
        //sin terminar
        return true;
    }

    //Articulos
    public Articulo traerArticuloPorId(int idArticulo) {
        Articulo resultado = null;
        for(Articulo arti : this.lstArticulo) {
            if (arti.getId() == idArticulo) {
                resultado = arti;
            }
        }
        return resultado;
    }

    public Articulo traerArticuloPorCodBarras(String codBarras) {
        Articulo resultado = null;
        for (Articulo arti : this.lstArticulo) {
            if (arti.getCodBarras().equalsIgnoreCase(codBarras)) {
                resultado = arti;
            }
        }
        return resultado;
    }

    public void agregarArticulosLstArticulos(String nombre, String codBarras, double precio) throws Exception {
        if (lstArticulo.size() == 0) {
            lstArticulo.add(new Articulo(1, nombre, codBarras, precio));
        }
        if (traerArticuloPorCodBarras(codBarras) == null) {
            lstArticulo.add(new Articulo(lstArticulo.get(lstArticulo.size()-1).getId()+1, nombre, codBarras, precio));
        }
    }

    //carritos
    public Carrito traerCarritoPorCliente(Cliente cliente) {
        Carrito CarritoAbierto = null; //tiene Carrito?
        for (Carrito carro : lstCarrito) {
            if (carro.getCliente().getDni() == cliente.getDni()) {
                CarritoAbierto = carro;
            }
        }
        return CarritoAbierto;
    }

    public boolean verificarCarritosCerrados(Cliente cliente) {
        boolean carritosCerrados = false;
        for (Carrito carro : lstCarrito) {
            if (carro.getCliente().getDni() == cliente.getDni()) {
                if (carro.getCerrado()) {
                    carritosCerrados = true;
                }
            }
        }
        return carritosCerrados;
    }

    public void agregarCarritoLstCarritos(Cliente cliente) throws Exception {

        if (lstCarrito.size() == 0) {
            lstCarrito.add(new Carrito(1,LocalDate.now(),LocalTime.now(),false,0, cliente, null));
            System.out.println("carrito creado");
        } else if ((traerCarritoPorCliente(cliente) != null && verificarCarritosCerrados(cliente) == true) || (traerCarritoPorCliente(cliente) == null)) {
            lstCarrito.add(new Carrito(lstCarrito.get(lstCarrito.size()-1).getId()+1,LocalDate.now(),LocalTime.now(),false,0, cliente, null));
        } else {
            throw new Exception("Cierre primero sus Carritos!");
        }
    }

    public void eliminarCarritoAbierto(long dni) {
        for (Carrito carro : lstCarrito) {
            if (carro.getCliente().getDni() == dni) {
                if (carro.getCerrado() == true) {
                    lstCarrito.remove(carro);
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
    
    public boolean agregarDiaRetiros(int diaSemana, LocalTime horaDesde, LocalTime horaHasta, int intervalo)
			throws Exception {
		int idDiaRetiro = 1;

		// Busco el ultimo Id
		if (getLstDiaRetiro().size() != 0) { // si la lista esta vacia el Id va a ser = 1
			idDiaRetiro = lstDiaRetiro.get(getLstDiaRetiro().size() - 1).getId() + 1; // el ultimo id + 1
		}

		DiaRetiro nuevoDiaRetiro = new DiaRetiro(idDiaRetiro, diaSemana, horaDesde, horaHasta, intervalo);// creo el
																											// nuevo dia

		// Busco si el dia Existe y tiro una Exception
		for (int i = 0; i < lstDiaRetiro.size(); i++) {
			if (nuevoDiaRetiro.equals(lstDiaRetiro.get(i)))
				throw new Exception("El dia Ya Existe! " + nuevoDiaRetiro);
		}
		lstDiaRetiro.add(nuevoDiaRetiro);
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

    public void generarUnaEntrega(Cliente cliente,LocalDate fecha, boolean efectivo, LocalTime hora)throws Exception {
        Carrito car= traerCarritoPorCliente(cliente);
        if(car!=null && car.getCerrado()) {
            throw new Exception("Este Carrito ya esta cerrado, ya ingreso su tipo de entrega");
        }
        car.setEntrega(new RetiroLocal(car.getId(), fecha, efectivo, hora));
    }
    public void generarUnaEntrega(Cliente cliente,LocalDate fecha, boolean efectivo, LocalTime horaHasta,LocalTime horaDesde,Ubicacion ubicacion)throws Exception {
        Carrito car= traerCarritoPorCliente(cliente);
        if(car!=null && car.getCerrado()) {
            throw new Exception("Este Carrito ya esta cerrado, ya ingreso su tipo de entrega");
        }
        car.setEntrega(new Envio(car.getId(), fecha, efectivo,horaHasta, horaDesde, 0, ubicacion));
    }
    
    
}
