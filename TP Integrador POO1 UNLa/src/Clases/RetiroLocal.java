package Clases;

import java.time.LocalDate;
import java.time.LocalTime;

public class RetiroLocal extends Entrega{

    private LocalTime horaEntrega;

    //----------constructor----------
    public RetiroLocal(int id, LocalDate fecha, boolean efectivo, LocalTime horaEntrega) {
        super(id, fecha, efectivo);
        this.horaEntrega = horaEntrega;
    }

//----------getters y setters----------

    public LocalTime getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(LocalTime horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    
//----------metodos----------
    @Override
	public String toString() {
		return "Retiro en Local [hora de Entrega=" + horaEntrega + "]";
	}

    
}
