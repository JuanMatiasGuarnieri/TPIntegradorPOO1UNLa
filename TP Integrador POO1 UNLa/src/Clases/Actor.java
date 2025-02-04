package Clases;



public abstract class Actor {
	protected int id;
	protected Contacto contacto;
	//constructor
	public Actor(int id, Contacto contacto) {
		super();
		this.id = id;
		this.contacto = contacto;
	}
	//getters y setters
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contacto == null) ? 0 : contacto.hashCode());
		result = prime * result + id;
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
		Actor other = (Actor) obj;
		if (contacto == null) {
			if (other.contacto != null)
				return false;
		} else if (!contacto.equals(other.contacto))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	//metodos
	protected boolean validarIdentificadorUnico (long identificador) {  //Recibe por par�metro un dni o un cuit
		String digitoStr,cuitMenosI;
		
		boolean booleano = false;
		String identificadorStr = String.valueOf(identificador);
		
		if(this instanceof Cliente) {			//Si es cliente tiene dni
			return(identificadorStr.length() == 7 || identificadorStr.length() == 8);	//Los dni tienen entre 7 y 8 digitos
		}
		
		else if(identificadorStr.length() != 11) {			//Si no es cliente es comercio y tiene cuit
	    	return booleano;								//los cuit solo tienen 11 dígitos
		}
		
		digitoStr = identificadorStr.substring(10, 11); //Guardamos el valor de ultimo digito
		cuitMenosI = identificadorStr.substring(0,11); //Guardamos el valor del cuit menos el ultimo digito
		String[] cuitArray = cuitMenosI.split(""); 
		
		//Inicializamos una matriz por la cual se multiplicar�n cada uno de los digitos
        Integer[] serie = {5, 4, 3, 2, 7, 6, 5, 4, 3, 2};
      //Creamos una variable auxiliar donde guardaremos los resultados del calculo del numero validador
        Integer aux = 0;
        //Recorremos las matrices de forma simultanea, sumando los productos de la serie por el numero en la misma posicion
        for (int i=0; i<10; i++){
            aux += Integer.valueOf(cuitArray[i]) * serie[i];
        }
      //Hacemos como se especifica: 11 menos el resto de de la division de la suma de productos anterior por 11
        aux = 11 - (aux % 11);
        //Si el resultado anterior es 11 el codigo es 0
        if (aux == 11){
            aux = 0;
        //o si el resultado anterior es 10 el codigo es 9
        } else if (aux == 10){
        	
            aux = 9;
        }
        
        int ultDigito = Integer.parseInt(digitoStr);
        if (aux == ultDigito) {
        	
        	return true;
        }
        
        return booleano;
        
		
	}
	

}
