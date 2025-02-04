package Clases;

public class Cliente extends Actor {
    private String apellido;
    private String nombre;
    private long dni;
    private char sexo;

    //----------constructor----------
    public Cliente(int id, Contacto contacto, String apellido, String nombre, long dni, char sexo) throws Exception {
        super(id, contacto);
        this.apellido = apellido;
        this.nombre = nombre;
        setSexo(sexo);
        setDni(dni);
    }

    //----------getters y setters----------
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) throws Exception {
        if (validarIdentificadorUnico(dni)) {
            this.dni = dni;
        } else {
            throw new Exception("El DNI ingresado es invalido");
        }
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) throws Exception {
		if(!validarSexo(sexo)) throw new Exception("Error: Sexo invalido ('H' o 'M')");
		this.sexo = Character.toUpperCase(sexo);
	}
    public boolean validarSexo(char sexo) {
		return(sexo=='H' || sexo=='h' || sexo=='M' || sexo=='m');
	}

    //----------to string----------
    @Override
    public String toString() {
        return "\nCliente apellido = " + apellido + "\nNombre = " + nombre + "\ndni = " + dni;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + (int) (dni ^ (dni >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + sexo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (dni != other.dni)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (sexo != other.sexo)
			return false;
		return true;
	}

    
    
}
