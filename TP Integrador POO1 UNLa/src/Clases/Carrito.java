package Clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;
//

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
	public Carrito(int id, LocalDate fecha, LocalTime hora, boolean cerrado, double descuento, Cliente cliente,Entrega entrega) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.cerrado = cerrado;
		this.descuento = descuento;
		this.cliente = cliente;
		this.entrega = entrega;
		this.lstItemCarrito=new ArrayList<ItemCarrito>();
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
		String articulos= " ";
		for(ItemCarrito arti : lstItemCarrito) {
			articulos += arti.toString();
		}

		return "\nLos Articulos del carrito son:\n"+articulos;
	}

	@Override
	public String toString() {
		String articulosMiCarrito= mostrarListaDeItemsCarrito();
		String cerr= "ABIERTO";
		if (cerrado) cerr="CERRADO";
		DecimalFormat formato1 = new DecimalFormat("#.000");
		return "\n-----Carrito-----\n\nFecha = " + fecha + "\nHora = " + hora + "\nCarrito = " + cerr + "\nDescuento = " + descuento + "\nCliente = " + cliente + "\n" + articulosMiCarrito + "\nEntrega = " + entrega +"\nTotal a pagar = "+formato1.format(totalAPagarCarrito());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (cerrado ? 1231 : 1237);
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		long temp;
		temp = Double.doubleToLongBits(descuento);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((entrega == null) ? 0 : entrega.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + id;
		result = prime * result + ((lstItemCarrito == null) ? 0 : lstItemCarrito.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrito other = (Carrito) obj;
		if (cerrado != other.cerrado)
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (Double.doubleToLongBits(descuento) != Double.doubleToLongBits(other.descuento))
			return false;
		if (entrega == null) {
			if (other.entrega != null)
				return false;
		} else if (!entrega.equals(other.entrega))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (id != other.id)
			return false;
		if (lstItemCarrito == null) {
			if (other.lstItemCarrito != null)
				return false;
		} else if (!lstItemCarrito.equals(other.lstItemCarrito))
			return false;
		return true;
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

	public boolean agregarAlCarrito(Articulo articulo,int cantidad){
		boolean agregado=false;

			if(traerItemPorId(articulo)!=null) {
				int suma= traerItemPorId(articulo).getCantidad()+cantidad;
				traerItemPorId(articulo).setCantidad(suma);
				agregado=true;
			}

			if(agregado==false) {
				this.lstItemCarrito.add(new ItemCarrito(articulo, cantidad));
			}
			return agregado;
	}
	//--------------------------------sacar item del carrito --------------------------------------------
	public boolean sacarDelCarrito(Articulo articulo,int cantidad) {
		boolean eliminado = false;
		if(traerItemPorId(articulo)!=null){
			int resta = (traerItemPorId(articulo).getCantidad() - cantidad) ;
			if (resta <= 0) {
			if (lstItemCarrito.size() == 1) {
				List<ItemCarrito> aux = new ArrayList<ItemCarrito>();
				lstItemCarrito = aux;
			} else {
				this.lstItemCarrito.remove(traerItemPorId(articulo));
				eliminado = true;
			}
		} else {
			traerItemPorId(articulo).setCantidad(resta);
		}
	}
		return  eliminado;
	}
	//-------------------------------calcular el total del carrito--------------------------------------
	public double calcularTotalCarrito() {
		double total=0;
		for(ItemCarrito item : lstItemCarrito) {
			total += item.calcularSubTotalItem();
		}
		return total;
	}
	//-------------------------------calcular descuento por dia-----------------------------------------
	public double calcularDescuentoDia(int diaDescuento, double porcentajeDescuentoDia) {
		double descuento=0;
		if(fecha.getDayOfWeek().getValue()==diaDescuento) {
			for(ItemCarrito item : lstItemCarrito) {

				int cantidad= item.getCantidad()/2;
				descuento+= (cantidad*item.getArticulo().getPrecio()*porcentajeDescuentoDia)/100;
			}
		}
		return descuento;
	}
	//--------------------------------calcular descuento por efectivo-----------------------------------
	public double calcularDescuentoEfectivo(double porcentajeDescuentoEfectivo) {
		return ((calcularTotalCarrito()*porcentajeDescuentoEfectivo)/100);
	}
	//--------------------------------calcular descuento carrito----------------------------------------
	public void calcularDescuentoCarrito(int diaDescuento, double porcentajeDescuento, double porcentajeDescuentoEfectivo) {
		double descuento=0;
		double descuentoDia= calcularDescuentoDia(diaDescuento, porcentajeDescuento);
		double descuentoEfectivo= calcularDescuentoEfectivo(porcentajeDescuentoEfectivo);
		if(descuentoDia>descuentoEfectivo) {
			descuento=descuentoDia;
		}else {descuento=descuentoEfectivo;}
		setDescuento(descuento);
	}
	//---------------------------------total a pagar el carrito-----------------------------------------
	public double totalAPagarCarrito() {
		double costo=0;
		Envio envio = null;
		if(entrega instanceof Envio) {
			envio = (Envio) entrega;
			costo = envio.getCosto();
		}
		return ((calcularTotalCarrito()+costo)-descuento);
	}

}//Fin clase
