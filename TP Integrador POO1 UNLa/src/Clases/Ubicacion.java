package Clases;

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

//----------metodos----------
}
