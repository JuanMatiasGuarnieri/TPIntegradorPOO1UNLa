package Clases;

import java.time.LocalTime;



public class DiaRetiro {
    private int id;
    private int diaSemana;
    private LocalTime horaDesde;
    private int intervalo;
    private LocalTime horaHasta;
    //----------constructor----------
    public DiaRetiro(int id, int diaSemana, LocalTime horaDesde,LocalTime horaHasta, int intervalo) {
        super();
        this.id = id;
        this.diaSemana = diaSemana;
        this.horaDesde = horaDesde;
        this.horaHasta = horaHasta;
        this.intervalo = intervalo;
    }

    //----------getters y setteres----------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalTime getHoraDesde() {
        return horaDesde;
    }

    public void setHoraDesde(LocalTime horaDesde) {
        this.horaDesde = horaDesde;
    }

    public LocalTime getHoraHasta() {
        return horaHasta;
    }

    public void setHoraHasta(LocalTime horaHasta) {
        this.horaHasta = horaHasta;
    }

    public int getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(int intervalo) {
        this.intervalo = intervalo;
    }

/*	@Override
	public boolean equals(Object obj) {
		return this.diaSemana == ((DiaRetiro) obj).getDiaSemana();
	}
*/
    
    
	@Override
	public String toString() {
		return "DiaRetiro [id=" + id + ", diaSemana=" + diaSemana + ", horaDesde=" + horaDesde + ", horaHasta="
				+ horaHasta + ", intervalo=" + intervalo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + diaSemana;
		result = prime * result + ((horaDesde == null) ? 0 : horaDesde.hashCode());
		result = prime * result + ((horaHasta == null) ? 0 : horaHasta.hashCode());
		result = prime * result + id;
		result = prime * result + intervalo;
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
		DiaRetiro other = (DiaRetiro) obj;
		if (diaSemana != other.diaSemana)
			return false;
		if (horaDesde == null) {
			if (other.horaDesde != null)
				return false;
		} else if (!horaDesde.equals(other.horaDesde))
			return false;
		if (horaHasta == null) {
			if (other.horaHasta != null)
				return false;
		} else if (!horaHasta.equals(other.horaHasta))
			return false;
		if (id != other.id)
			return false;
		if (intervalo != other.intervalo)
			return false;
		return true;
	}

    
//----------metodos----------

}
