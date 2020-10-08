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

public String toString () {
    	
    	return "\n id:" +id+ "\n diaSemana: " +diaSemana+ "\n horaDesde: " +horaDesde+ "\n horaHasta: " +horaHasta+ "\n intervalo: " +intervalo;
    }

    
//----------metodos----------

}
