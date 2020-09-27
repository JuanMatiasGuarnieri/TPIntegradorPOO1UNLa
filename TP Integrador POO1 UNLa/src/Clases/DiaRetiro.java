package Clases;

import java.time.LocalTime;

public class DiaRetiro {
    private int id;
    private int diaSemana;
    private LocalTime horaDesde;
    private int intervalo;

    //----------constructor----------
    public DiaRetiro(int id, int diaSemana, LocalTime horaDesde, int intervalo) {
        super();
        this.id = id;
        this.diaSemana = diaSemana;
        this.horaDesde = horaDesde;
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

    public int getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(int intervalo) {
        this.intervalo = intervalo;
    }

//----------metodos----------

}
