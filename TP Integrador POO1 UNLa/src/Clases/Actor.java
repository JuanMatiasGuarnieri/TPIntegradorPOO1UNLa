package Clases;

public abstract class Actor {
    protected int id;
    protected Contacto contacto;

// Matias te odio
    //----------constructor----------
    public Actor(int id, Contacto contacto) {
        super();
        this.id = id;
        this.contacto = contacto;
    }


    //----------getters y setters----------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    //----------metodos----------
    protected abstract boolean validarIdentificadorUnico(long identificador);
}
