package Clases;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Entrega {
    protected int id;
    protected LocalDate fecha;
    protected boolean efectivo;

//----------constructor----------

    public Entrega(int id, LocalDate fecha, boolean efectivo) {
        super();
        this.id = id;
        this.fecha = fecha;
        this.efectivo = efectivo;
    }

    //----------getters y setteres----------
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

    public boolean isEfectivo() {
        return efectivo;
    }

    public void setEfectivo(boolean efectivo) {
        this.efectivo = efectivo;
    }
//----------metodos----------
    
}
