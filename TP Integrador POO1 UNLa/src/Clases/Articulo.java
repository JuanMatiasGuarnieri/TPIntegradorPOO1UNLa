package Clases;

public class Articulo {
    private int id;
    private String nombre;
    private String codBarras;
    private double precio;

    //----------constructor----------
    public Articulo(int id, String nombre, String codBarras, double precio) throws Exception {
        super();
        this.id = id;
        this.nombre = nombre;
        this.setCodBarras(codBarras);
        this.precio = precio;
    }

    //----------getters y setters----------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) throws Exception {
		if (validarCodBarras(codBarras)==false)
			throw new Exception("Codigo de barras no valido");
		this.codBarras = codBarras;
	}

    public double getPrecio() {

        return precio;
    }

    public void setPrecio(double precio) {

        this.precio = precio;
    }

    //----------to string----------
    public String toString() {

        return "\nArticulo id = " + id + "\nnombre = " + nombre + "\ncodBarras = " + codBarras + "\nprecio = " + precio;
    }


    //----------metodos----------
    public boolean validarCodBarras(String codBarras) {
		int evens = 0; //initialize evens variable
		int odds = 0; //initialize odds variable
		int checkSum = 0; //initialize the checkSum
		long longCodBarras = Long.parseLong(codBarras);
		long ultDigito = longCodBarras % 10;
		for (int i=0;i<12; i++) {// fixed because it is fixed in pratices but you can use length() insted
		int digit = Integer.parseInt(codBarras.substring(i,i+1));
		if (i%2==0) {
		evens += digit;// then add it to the evens
		}else {
		odds += digit; // else add it to the odds
		}
		}
		odds = odds * 3; //multiply odds by three
		int total = odds + evens; //sum odds and evens
		if (total % 10 == 0){ //if total is divisible by ten, special case
		checkSum = 0;//checksum is zero
		} else { //total is not divisible by ten
		checkSum = 10 - (total % 10); //subtract the ones digit from 10 to find the checksum
		}
		return (checkSum == ultDigito);
		
		//return codBarras.matches("^[7]{1}[7]{1}[9]{1}[0-9]{10}$");
	}
}
