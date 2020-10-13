package Clases;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public class Envio extends Entrega {
	
      private LocalTime horaHasta;
      private LocalTime horaDesde;
      private Ubicacion ubicacion;
      private double costo;
      
//----------constructor----------
public Envio(int id, LocalDate fecha, boolean efectivo, LocalTime horaHasta, LocalTime horaDesde, double costo, Ubicacion ubicacion) {
	super(id, fecha, efectivo);
	this.horaHasta = horaHasta;
	this.horaDesde = horaDesde;
	this.costo = costo;
	this.ubicacion = ubicacion;
}

//----------getters y setters----------
public LocalTime getHoraHasta() { 
	return horaHasta;
}
public void setHoraHasta(LocalTime horaHasta) {
	this.horaHasta = horaHasta;
}
public LocalTime getHoraDesde() {
	return horaDesde;
}
public void setHoraDesde(LocalTime horaDesde) {
	this.horaDesde = horaDesde;
}
public double getCosto() {
	return costo;
}
//Recibe por parametro ubicacion, el costoFijo y el costo por km
public void setCosto(Ubicacion ubicacion, double costoFijo, double costoPorKm) {
	//Llama al metodo (DistanciaCoord) para calcular la distancia entre 2 coordenadas
	double distancia = distanciaCoord(ubicacion.getLatitud(), ubicacion.getLongitud(), this.ubicacion.getLatitud(), this.ubicacion.getLongitud());
	//Multiplicamos la distancia por el costoPorkm y le sumamos costofijo
	double nuevoCosto = (distancia * costoPorKm) + costoFijo;
	this.costo = nuevoCosto;
}

public Ubicacion getUbicacion() {
	return ubicacion; }

public void setUbicacion(Ubicacion ubicacion) {
	this.ubicacion = ubicacion; }

//--------------metodos------------
@Override
public String toString() {
	DecimalFormat formato1 = new DecimalFormat("#.000");
	return "-----Envio----- horaHasta = " + horaHasta + "\nhoraDesde = " + horaDesde + "\ncosto = " + formato1.format(costo) + "\nubicacion = "
			+ ubicacion;
}

public LocalTime traerHora() {
		return LocalTime.now();
	}

public double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {
	double radioTierra = 6371; //en kil�metros
	double dLat = Math.toRadians(lat2 - lat1);
	double dLng = Math.toRadians(lng2 - lng1);
	double sindLat = Math.sin(dLat / 2);
	double sindLng = Math.sin(dLng / 2);
	double va1 =Math.pow(sindLat, 2)+Math.pow(sindLng, 2)*Math.cos(Math.toRadians(lat1))*
			Math.cos(Math.toRadians(lat2));
	double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
	return radioTierra * va2;
}

}//Fin Clase