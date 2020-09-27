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

        return "\nArticulo id = " + id + "\nnombre = " + nombre + "\ncodBarras = " + codBarras + "\nprecio = " + precio;
    }


    //----------metodos----------
    public boolean validarCodBarras(String cod) {
        boolean validar = false;
        if (cod.length() == 13) {
            validar = true;
        }
        return validar;
    }
}
