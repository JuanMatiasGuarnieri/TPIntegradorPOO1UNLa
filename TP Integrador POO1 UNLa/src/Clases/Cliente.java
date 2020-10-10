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

    //----------metodos----------
    protected boolean validarIdentificadorUnico(long identificador) {
        boolean validar = false;
        if (identificador > 999999 && identificador < 100000000) {
            validar = true;
        }
        return validar;
    }
}
