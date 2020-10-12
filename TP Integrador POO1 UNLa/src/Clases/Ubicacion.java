package Clases;

//import almacen.Ubicacion;

public class Ubicacion {

    private double latitud;
    private double longitud;

    //----------constructor----------
    public Ubicacion(double latitud, double longitud) {
        super();
        this.latitud = latitud;
        this.longitud = longitud;
    }

    //----------getters y setters----------
    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

  /*  public double distanciaCoord (double lat1, double lng1,double lat2, double lng2) {
    	double radioTierra = 6371;
    	double dLat = Math.toRadians(lat2-lat1);
    	double dLng = Math.toRadians(lng2-lng1);
    	double sindLat = Math.sin(dLat/2);
    	double sindLng = Math.sin(dLng/2);
    	double va1= Math.pow(sindLat, 2)+Math.pow(sindLng, 2)*Math.cos(Math.toRadians(lat1))*Math.cos(Math.toRadians(lat2));
    	double va2= 2*Math.atan2(Math.sqrt(va1),Math.sqrt(1-va1));
    	
    	return radioTierra *va2;
    }*/
    
//----------metodos----------
    @Override
	public String toString() {
		return "Ubicacion [latitud=" + latitud + ", longitud=" + longitud + "]";
	}
	
	public Ubicacion traerUbicacion() {
		return new Ubicacion(latitud, longitud);
	}
}


