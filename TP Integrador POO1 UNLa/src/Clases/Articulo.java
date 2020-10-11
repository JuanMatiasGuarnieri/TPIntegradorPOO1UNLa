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
        boolean validar = validarCodBarras(codBarras);
        if (validar) {
            this.codBarras = codBarras;
        } else {
            throw new Exception("Codigo de Barras no valido");
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //----------to string----------
    public String toString() {
        return "\nArticulo id = " + id + "\nNombre = " + nombre + "\nCodigo de Barras = " + codBarras + "\nPrecio = " + precio;
    }


    //----------metodos----------
    public boolean validarCodBarras(String codBarras) {
		int pares = 0; 
		int impares = 0; 
		int checkSum = 0; 
		long longCodBarras = Long.parseLong(codBarras);
		long ultDigito = longCodBarras % 10;
		for (int i=0;i<12; i++) {
		    int digito = Integer.parseInt(codBarras.substring(i,i+1));
		    if (i%2==0) {
		        pares += digito;
		    } else {
		        impares += digito;
		    }
		}
		impares = impares * 3; //multiplicar impares por 3
		int total = impares + pares; //sumar pares e impares
		if (total % 10 == 0) { //Si el total es divisible por 10
		    checkSum = 0;//Checksum es 0
		} else { //si total no es divisible por 10
		    checkSum = 10 - (total % 10); // Hacemos mod 10 del total y ese resultado va a restar a 10.
            // Esto nos va a dar el digito verificador (El último digito)
		}
		return (checkSum == ultDigito);
	}
}
