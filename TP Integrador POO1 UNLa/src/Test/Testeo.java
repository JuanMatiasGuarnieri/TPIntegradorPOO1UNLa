package Test;

import Clases.*;

class Testeo {
    public static void main(String[] args) {

        //// /////////////////////////////////// Entrada de datos ///////////////////////////////////////
        // Ingreso cliente
        try {
            System.out.println("\n-----Ingreso cliente-----");
            Ubicacion ubicacionCliente1 = new Ubicacion(70, 40);//R
            Contacto contactoCliente1 = new Contacto("cliente@gmail.com", "11 30421030", ubicacionCliente1);//R
            Cliente cliente1 = new Cliente(1, contactoCliente1, "Guarnieri", "Matias", 41785928, 'm');//R
            System.out.println(cliente1);
        }//Fin try
        catch (Exception e) {
            System.out.println(e.getMessage());
        }//Fin catch

        // Ingreso cliente con DNI invalidado
        try {
            System.out.println("\n-----Ingreso cliente con DNI invalidado-----");
            Ubicacion ubicacionCliente1 = new Ubicacion(70, 40);//R
            Contacto contactoCliente1 = new Contacto("cliente@gmail.com", "11 30421030", ubicacionCliente1);//R
            Cliente cliente1 = new Cliente(1, contactoCliente1, "Guarnieri", "Matias", 417859285, 'm');//R
            System.out.println(cliente1);
        }//Fin try
        catch (Exception e) {
            System.out.println(e.getMessage());
        }//Fin catch

        //-----Fin del ingreso de cliente-----


        //------------------------------ 8) + agregar(Articulo articulo, int cantidad)------------------------------

        //-----//--/--//----- Ingreso de Articulos a la lista del comercio -----//--/--//-----
        try {
            System.out.println("-----Ingreso de Articulos a la lista del comercio-----");
            //almacen
            Ubicacion ubicacionDelAlmacen = new Ubicacion(3901, 1832);//DATOS REALES
            Contacto contactoAlmacen = new Contacto("almacen@gmail.com", "785928", ubicacionDelAlmacen); //R
            Comercio almacenGranate = new Comercio(1, contactoAlmacen, "Almacen Granate", 30418459219l, 550, 300, 35, 25, 15);//R
            //articulos
            almacenGranate.agregarArticulosLstArticulos("Chocolate", "7791234567898", 250);//R
            almacenGranate.agregarArticulosLstArticulos("Dulce de leche", "7792345678909", 100);//R
            //muestro productos
            System.out.println("Articulos: ");
            System.out.println(almacenGranate.traerArticuloPorId(1));    //R
            System.out.println(almacenGranate.traerArticuloPorCodBarras("7792345678909"));//R
        }//Fin try

        catch (Exception e) {
            System.out.println(e.getMessage());
        }//Fin catch


        //-----//--/--//----- Ingreso de Articulos con codigo de barras invalido -----//--/--//-----
        try {
            System.out.println("\n\n-----Ingreso de Articulos con codigo de barras invalido-----");
            //comercio
            Ubicacion ubicacionDelAlmacen = new Ubicacion(3901, 1832);//R
            Contacto contactoAlmacen = new Contacto("almacen@gmail.com", "785928", ubicacionDelAlmacen); //R
            Comercio almacenGranate = new Comercio(1, contactoAlmacen, "Almacen Granate", 30418459219l, 550, 300, 35, 25, 15);//R
            //producto
            almacenGranate.agregarArticulosLstArticulos("Chocolate", "123456789123456789", 250);//R
            //muestro
            System.out.println(almacenGranate.traerArticuloPorId(1));

        }//Fin try

        catch (Exception e) {
            System.out.println(e.getMessage());
        }//Fin catch

        //-----Fin del ingreso de productos-----

        /////////////////////////////////////// Creo Carrito ///////////////////////////////////////

        //-----//--/--//----- creo un carrito para cliente 1 -----//--/--//-----
        try {
            System.out.println("\n\n-----Ingreso del carrito-----");
            //cliente
            Ubicacion ubicacionCliente1 = new Ubicacion(70, 40);//R
            Contacto contactoCliente1 = new Contacto("cliente1@gmail.com", "11 30421030", ubicacionCliente1);//R
            Cliente cliente1 = new Cliente(1, contactoCliente1, "Alegre", "Luis", 41785928, 'm');//R
            //almacen
            Ubicacion ubicacionDelAlmacen = new Ubicacion(3901, 1832);//R
            Contacto contactoAlmacen = new Contacto("almacen@hotmail.com", "1614585", ubicacionDelAlmacen);
            Comercio almacenGranate = new Comercio(1, contactoAlmacen, "AlmacenGranate", 30418459219l, 100, 500, 10, 50, 10);

            almacenGranate.agregarCarritoLstCarritos(cliente1);

        }//Fin try
        catch (Exception e) {
            System.out.println(e.getMessage());
        }//Fin catch


        //-----//--/--//-----Ingreso de dos carrito al mismo cliente-----//--/--//-----

        try {
            System.out.println("\n\n-----Se ingresan dos carritos para un mismo cliente-----");
            //cliente
            Ubicacion ubicacionCliente1 = new Ubicacion(70, 40);
            Contacto contactoCliente1 = new Contacto("Cliente@hotmail.com", "116485216", ubicacionCliente1);
            Cliente cliente1 = new Cliente(1, contactoCliente1, "cruz", "Ignacio", 41581415, 'm');
            //almacen
            Ubicacion ubicacionDelAlmacen = new Ubicacion(3901, 1832);
            Contacto contactoAlmacen = new Contacto("almacen@gmail.com", "785928", ubicacionDelAlmacen);//R
            Comercio almacenGranate = new Comercio(1, contactoAlmacen, "Almacen Granate", 30418459219l, 550, 300, 35, 25, 15);//R
            //llamados
            almacenGranate.agregarCarritoLstCarritos(cliente1);//R
            almacenGranate.agregarCarritoLstCarritos(cliente1);//R


        }//Fin try
        catch (Exception e) {
            System.out.println(e.getMessage());
        }//Fin catch

        /////////////////////////////////////// Ingreso Articulos al carrito///////////////////////////////////////

        try {
            System.out.println("\n\n-----Agrego productos al carrito-----");
            //cliente
            Ubicacion ubicacionCliente1 = new Ubicacion(70, 40);//R
            Contacto contactoCliente1 = new Contacto("cliente1@gmail.com", "11 30421030", ubicacionCliente1);//R
            Cliente cliente1 = new Cliente(1, contactoCliente1, "Alegre", "Luis", 41785928, 'm');//R
            //almacen
            Ubicacion ubicacionDelAlmacen = new Ubicacion(3901, 1832);//R
            Contacto contactoAlmacen = new Contacto("almacen@gmail.com", "785928", ubicacionDelAlmacen);//R
            Comercio almacenGranate = new Comercio(1, contactoAlmacen, "Almacen Granate", 30418459219l, 550, 300, 35, 25, 15);//R
            //llamados
            almacenGranate.agregarArticulosLstArticulos("Chocolate", "7791234567898", 250);//R
            almacenGranate.agregarArticulosLstArticulos("Dulce de leche", "7792345678909", 100);//R
            almacenGranate.agregarCarritoLstCarritos(cliente1);
            almacenGranate.traerCarritoPorCliente(cliente1).agregarAlCarrito(almacenGranate.traerArticuloPorId(1), 2);
            almacenGranate.traerCarritoPorCliente(cliente1).agregarAlCarrito(almacenGranate.traerArticuloPorId(2), 2);
            //muestro
            System.out.println(almacenGranate.traerCarritoPorCliente(cliente1).mostrarListaDeItemsCarrito());

        }//Fin try
        catch (Exception e) {
            System.out.println(e.getMessage());
        }//Fin catch


        //Retiro articulos de la lista de items

        try {
            System.out.println("\n\n-----Retiro productos del carrito-----");
            //cliente
            Ubicacion ubicacionCliente1 = new Ubicacion(70, 40);//R
            Contacto contactoCliente1 = new Contacto("cliente@gmail.com", "11 30421030", ubicacionCliente1);//R
            Cliente cliente1 = new Cliente(1, contactoCliente1, "Alegre", "Luis", 41785928, 'm');//R
            //almacen
            Ubicacion ubicacionDelAlmacen = new Ubicacion(3901, 1832);//R
            Contacto contactoAlmacen = new Contacto("almacen@gmail.com", "785928", ubicacionDelAlmacen);//R
            Comercio almacenGranate = new Comercio(1, contactoAlmacen, "AlmacenGranate", 30418459219l, 550, 300, 35, 25, 15);//R
            //llamados
            almacenGranate.agregarArticulosLstArticulos("Chocolate", "7791234567898", 250);//R
            almacenGranate.agregarArticulosLstArticulos("Dulce de leche", "7792345678909", 100);//R
            almacenGranate.agregarCarritoLstCarritos(cliente1);
            almacenGranate.traerCarritoPorCliente(cliente1).agregarAlCarrito(almacenGranate.traerArticuloPorId(1), 10);
            //muestro
            System.out.println(almacenGranate.traerCarritoPorCliente(cliente1).mostrarListaDeItemsCarrito());
            //retiro productos del carrito
            almacenGranate.traerCarritoPorCliente(cliente1).sacarDelCarrito(almacenGranate.traerArticuloPorId(1), 5);
            //muestro
            System.out.println(almacenGranate.traerCarritoPorCliente(cliente1).mostrarListaDeItemsCarrito());

        }//Fin try
        catch (Exception e) {
            System.out.println(e.getMessage());
        }//Fin catch


    }//Fin main
}
