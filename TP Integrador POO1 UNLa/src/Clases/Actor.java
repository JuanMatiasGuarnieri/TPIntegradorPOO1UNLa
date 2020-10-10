package Clases;


public abstract class Actor {
    protected int id;
    protected Contacto contacto;


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
    protected boolean validarIdentificadorUnico (long identificador) {
		String xyStr, dniStr, digitoStr,cuitMenosI;
		
		boolean booleano = false;
		String identificadorStr = String.valueOf(identificador);
		
		if(this instanceof Cliente) {															//Si es cliente tiene dni
			return(identificadorStr.length() == 7 || identificadorStr.length() == 8);		//Los dni solo tienen 8 o 9 digitos
		}
		
		else if(identificadorStr.length() != 11) {											//Si no es cliente es comercio y tiene cuit
	    	return false;																		//los cuit solo tienen 11 dígitos
		}
		
		xyStr = identificadorStr.substring(0, 2);
		dniStr = identificadorStr.substring(2, 10); 
		digitoStr = identificadorStr.substring(10, 11);
		cuitMenosI = identificadorStr.substring(0,11);
		String[] cuitArray = cuitMenosI.split(""); 
		if (identificadorStr.length() != 11 ) {
			return booleano;
		}
		//Inicializamos una matriz por la cual se multiplicar�n cada uno de los d�gitos
        Integer[] serie = {5, 4, 3, 2, 7, 6, 5, 4, 3, 2};
      //Creamos una variable auxiliar donde guardaremos los resultados del calculo del n�mero validador
        Integer aux = 0;
        //Recorremos las matrices de forma simultanea, sumando los productos de la serie por el n�mero en la misma posici�n
        for (int i=0; i<10; i++){
            aux += Integer.valueOf(cuitArray[i]) * serie[i];
        }
      //Hacemos como se especifica: 11 menos el resto de de la divisi�n de la suma de productos anterior por 11
        aux = 11 - (aux % 11);
        //Si el resultado anterior es 11 el c�digo es 0
        if (aux == 11){
            aux = 0;
        //o si el resultado anterior es 10 el c�digo es 9
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
