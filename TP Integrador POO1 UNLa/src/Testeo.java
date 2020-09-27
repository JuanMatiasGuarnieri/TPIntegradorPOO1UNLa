import Clases.*;

class Testeo {
    public static void main(String[] args) {
        //escenario 1 "ingreso de Articulos a la lista de articulos del comercio"
        try {
            System.out.println("escenario 1 ingreso de Articulos a la lista de articulos del comercio");
            Ubicacion ubicacionDelAlmacen = new Ubicacion(98, 130);

		/*(int id, Contacto contacto,String nombreComercio, long cuit, double costoFijo, double costoPorKm,
		int diaDescuento, int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo)*/

            Contacto contAlmacen = new Contacto("tioPochoAlmacenes@gmail.com", "8175369", ubicacionDelAlmacen);
            Comercio almacenTioPocho = new Comercio(1, contAlmacen, "AlmacenTioPocho", 3038945212L, 300, 622, 15, 40, 25);
            almacenTioPocho.agregarArticulosLstArticulos("Atún", "5869414836124", 30);
            almacenTioPocho.agregarArticulosLstArticulos("Papas Lays", "9475821547375", 20);


            System.out.println(almacenTioPocho.traerArticuloPorId(1));
            System.out.println(almacenTioPocho.traerArticuloPorCodBarras("9475821547375"));
            System.out.println(almacenTioPocho.getCuit());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //
        //escenario 1.b "ingreso de Articulos a la lista de articulos del comercio con codigo de barras existente"
        try {
            System.out.println("\nescenario 1.b ingreso de Articulos a la lista de articulos del comercio con excepcion por codigo de barras existente");
            Ubicacion ubicacionDelAlmacen = new Ubicacion(98, 130);
            Contacto contAlmacen = new Contacto("tioPochoAlmacenes@gmail.com", "8175369", ubicacionDelAlmacen);
            Comercio almacenTioPocho = new Comercio(1, contAlmacen, "AlmacenTioPocho", 3038945212L, 300, 622, 15, 40, 25);
            almacenTioPocho.agregarArticulosLstArticulos("Atún", "5869414836124", 30);
            almacenTioPocho.agregarArticulosLstArticulos("Papas Lays", "9475821547375", 20);


            System.out.println(almacenTioPocho.traerArticuloPorId(2));
            System.out.println(almacenTioPocho.traerArticuloPorCodBarras("5869414836124"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //escenario 1.c "\ningreso de Articulos a la lista de articulos del comercio con excepcion por codigo de barras invalido"
        try {
            System.out.println("\nescenario 1.c ingreso de Articulos a la lista de articulos del comercio con excepcion por codigo de barras invalido");
            Ubicacion ubicacionDelAlmacen = new Ubicacion(98, 130);
            Contacto contAlmacen = new Contacto("tioPochoAlmacenes@gmail.com", "8175369", ubicacionDelAlmacen);
            Comercio almacenTioPocho = new Comercio(1, contAlmacen, "AlmacenTioPocho", 3038945212L, 300, 622, 15, 40, 25);
            almacenTioPocho.agregarArticulosLstArticulos("Serú Girán", "945874212", 420);

            System.out.println(almacenTioPocho.traerArticuloPorId(1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //escenario 2.a Cliente con DNI validado
        try {
            System.out.println("\nescenario 2.a Cliente con DNI validado");
            Ubicacion ubicacionCliente1 = new Ubicacion(30, 21);
            Contacto contactoCliente1 = new Contacto("Cliente@servidor.com", "1167640645", ubicacionCliente1);
            Cliente cliente1 = new Cliente(1, contactoCliente1, "Oscar", "Moro", 40856987, 'm');
            System.out.println(cliente1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //escenario 2.b Cliente con DNI invalidado
        try {
            System.out.println("\nescenario 2.b Cliente con DNI invalidado");
            Ubicacion ubicacionCliente1 = new Ubicacion(30, 21);
            Contacto contactoCliente1 = new Contacto("Cliente@servidor.com", "116485216", ubicacionCliente1);
            Cliente cliente1 = new Cliente(1, contactoCliente1, "Oscar", "Moro", 152178452, 'm');
            System.out.println(cliente1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//escenario 3.a crear Carrito

        try {
            System.out.println("\nescenario 3.a Cliente crea carrito");
            Ubicacion ubicacionCliente1 = new Ubicacion(30, 21);
            Contacto contactoCliente1 = new Contacto("Cliente@servidor.com", "116485216", ubicacionCliente1);
            Cliente cliente1 = new Cliente(1, contactoCliente1, "Oscar", "Moro", 40856987, 'm');
            Ubicacion ubicacionDelAlmacen = new Ubicacion(98, 130);
            Contacto contAlmacen = new Contacto("almacen@servidor.com", "2512585", ubicacionDelAlmacen);
            Comercio almacenTioPocho = new Comercio(1, contAlmacen, "AlmacenTioPocho", 3038945212L, 300, 622, 15, 40, 25);

            almacenTioPocho.agregarCarritoLstCarritos(cliente1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //escenario 3.b crear Carrito con Excepcion

        try {
            System.out.println("\nescenario 3.b Cliente crea carrito con excepcion");
            Ubicacion ubicacionCliente1 = new Ubicacion(30, 21);
            Contacto contactoCliente1 = new Contacto("Cliente@servidor.com", "116485216", ubicacionCliente1);
            Cliente cliente1 = new Cliente(1, contactoCliente1, "Oscar", "Moro", 40856987, 'm');
            Ubicacion ubicacionDelAlmacen = new Ubicacion(98, 130);
            Contacto contAlmacen = new Contacto("almacen@servidor.com", "2512585", ubicacionDelAlmacen);
            Comercio almacenTioPocho = new Comercio(1, contAlmacen, "AlmacenTioPocho", 3038945212L, 300, 622, 15, 40, 25);

            almacenTioPocho.agregarCarritoLstCarritos(cliente1);
            almacenTioPocho.agregarCarritoLstCarritos(cliente1);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//4 agregar Items al carrito
        try {
            System.out.println("\nescenario 4.a agregar Items al carrito");
            Ubicacion ubicacionCliente1 = new Ubicacion(30, 21);
            Contacto contactoCliente1 = new Contacto("Cliente@servidor.com", "116485216", ubicacionCliente1);
            Cliente cliente1 = new Cliente(1, contactoCliente1, "Oscar", "Moro", 40856987, 'm');
            Ubicacion ubicacionDelAlmacen = new Ubicacion(98, 130);
            Contacto contAlmacen = new Contacto("almacen@servidor.com", "2512585", ubicacionDelAlmacen);
            Comercio almacenTioPocho = new Comercio(1, contAlmacen, "AlmacenTioPocho", 3038945212L, 300, 622, 15, 40, 25);

            almacenTioPocho.agregarArticulosLstArticulos("Arvejas", "1234567898765", 30);
            almacenTioPocho.agregarArticulosLstArticulos("Choclo", "1234567898766", 20);
            almacenTioPocho.agregarCarritoLstCarritos(cliente1);
            almacenTioPocho.traerCarritoPorCliente(cliente1).agregarAlCarrito(almacenTioPocho.traerArticuloPorId(1), 8);
            almacenTioPocho.traerCarritoPorCliente(cliente1).agregarAlCarrito(almacenTioPocho.traerArticuloPorId(2), 2);
            System.out.println(almacenTioPocho.traerCarritoPorCliente(cliente1).mostrameListaDeItemsCarrito());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //4.b Suma de Articulos a la lista de items
        try {
            System.out.println("\nescenario 4.b Suma de Articulos a la lista de items");
            Ubicacion ubicacionCliente1 = new Ubicacion(30, 21);
            Contacto contactoCliente1 = new Contacto("Cliente@servidor.com", "116485216", ubicacionCliente1);
            Cliente cliente1 = new Cliente(1, contactoCliente1, "Oscar", "Moro", 40856987, 'm');
            Ubicacion ubicacionDelAlmacen = new Ubicacion(98, 130);
            Contacto contAlmacen = new Contacto("almacen@servidor.com", "2512585", ubicacionDelAlmacen);
            Comercio almacenTioPocho = new Comercio(1, contAlmacen, "AlmacenTioPocho", 3038945212L, 300, 622, 15, 40, 25);

            almacenTioPocho.agregarArticulosLstArticulos("Atún", "5869414836124", 30);
            almacenTioPocho.agregarArticulosLstArticulos("Papas Lays", "9475821547375", 20);
            almacenTioPocho.agregarCarritoLstCarritos(cliente1);
            almacenTioPocho.traerCarritoPorCliente(cliente1).agregarAlCarrito(almacenTioPocho.traerArticuloPorId(1), 4);
            almacenTioPocho.traerCarritoPorCliente(cliente1).agregarAlCarrito(almacenTioPocho.traerArticuloPorId(1), 3);
            System.out.println(almacenTioPocho.traerCarritoPorCliente(cliente1).mostrameListaDeItemsCarrito());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //4.c Restar Articulos a la lista de items

        try {
            System.out.println("\nescenario 4.c Restar Articulos a la lista de items");
            Ubicacion ubicacionCliente1 = new Ubicacion(30, 21);
            Contacto contactoCliente1 = new Contacto("Cliente@servidor.com", "116485216", ubicacionCliente1);
            Cliente cliente1 = new Cliente(1, contactoCliente1, "Oscar", "Moro", 40856987, 'm');
            Ubicacion ubicacionDelAlmacen = new Ubicacion(98, 130);
            Contacto contAlmacen = new Contacto("almacen@servidor.com", "2512585", ubicacionDelAlmacen);
            Comercio almacenTioPocho = new Comercio(1, contAlmacen, "AlmacenTioPocho", 3038945212L, 300, 622, 15, 40, 25);

            almacenTioPocho.agregarArticulosLstArticulos("Atún", "5869414836124", 30);
            almacenTioPocho.agregarArticulosLstArticulos("Papas Lays", "9475821547375", 20);
            almacenTioPocho.agregarCarritoLstCarritos(cliente1);
            almacenTioPocho.traerCarritoPorCliente(cliente1).agregarAlCarrito(almacenTioPocho.traerArticuloPorId(1), 8);
            almacenTioPocho.traerCarritoPorCliente(cliente1).sacarDelCarrito(almacenTioPocho.traerArticuloPorId(1), 2);
            System.out.println(almacenTioPocho.traerCarritoPorCliente(cliente1).mostrameListaDeItemsCarrito());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//4.d Eliminar Articulos a la lista de items

        try {
            System.out.println("\nescenario 4.d Eliminar Articulos a la lista de items");
            Ubicacion ubicacionCliente1 = new Ubicacion(30, 21);
            Contacto contactoCliente1 = new Contacto("Cliente@servidor.com", "116485216", ubicacionCliente1);
            Cliente cliente1 = new Cliente(1, contactoCliente1, "Oscar", "Moro", 40856987, 'm');
            Ubicacion ubicacionDelAlmacen = new Ubicacion(98, 130);
            Contacto contAlmacen = new Contacto("almacen@servidor.com", "2512585", ubicacionDelAlmacen);
            Comercio almacenTioPocho = new Comercio(1, contAlmacen, "AlmacenTioPocho", 3038945212L, 300, 622, 15, 40, 25);
            System.out.println("Tio pocho.");
            almacenTioPocho.agregarArticulosLstArticulos("Atún", "5869414836124", 30);
            almacenTioPocho.agregarArticulosLstArticulos("Papas Lays", "9475821547375", 20);
            almacenTioPocho.agregarCarritoLstCarritos(cliente1);
            //agrego articulos al carrito 4 atunes
            System.out.println("Tio pocho2.");
            almacenTioPocho.traerCarritoPorCliente(cliente1).agregarAlCarrito(almacenTioPocho.traerArticuloPorId(1), 4);
            System.out.println("Tio pocho3.");
            //almacenTioPocho.traerCarritoPorCliente(cliente1).agregarAlCarrito(almacenTioPocho.traerArticuloPorId(2), 3);
            System.out.println(almacenTioPocho.traerCarritoPorCliente(cliente1).mostrameListaDeItemsCarrito());
            System.out.println("Tio pocho4.");
            //saco mis 4 atunes (ERROR NO SE PUEDE SACAR 4 ATUNES, QUEDA NULL)
            almacenTioPocho.traerCarritoPorCliente(cliente1).sacarDelCarrito(almacenTioPocho.traerArticuloPorId(1), 2);
            System.out.println("Tio pocho5.");
            System.out.println(almacenTioPocho.traerCarritoPorCliente(cliente1).mostrameListaDeItemsCarrito());
            //vuelvo a agregar 4 atunes
            System.out.println("Tio pocho6.");
            almacenTioPocho.traerCarritoPorCliente(cliente1).agregarAlCarrito(almacenTioPocho.traerArticuloPorId(1), 4);
            System.out.println(almacenTioPocho.traerCarritoPorCliente(cliente1).mostrameListaDeItemsCarrito());
            System.out.println("Tio pocho7.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
