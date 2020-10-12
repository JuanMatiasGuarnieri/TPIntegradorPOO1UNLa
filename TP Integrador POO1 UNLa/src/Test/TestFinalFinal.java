package Test;

import Clases.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.function.Function;

public class TestFinalFinal {
    public static void main(String[] args) {

        //// /////////////////////////////////// Entrada de datos ///////////////////////////////////////

        // Creacion del comercio (afuera de todo que lo vamos a usar muchas veces)
        System.out.println("\n0) ----- Jelou Guorl -----");
        Ubicacion ubicacionDelAlmacen = new Ubicacion(1248, 1632);
        Contacto contactoAlmacen = new Contacto("almacen@almacen.com", "1112223333", ubicacionDelAlmacen);
        Comercio Almacen = null;

        System.out.println("\n1) ----- Creacion del comercio -----");
        try {
            Almacen = new Comercio(1, contactoAlmacen, "Almacen Omero Sinso", 30418459219l, 550, 300, 35, 25, 15);
            System.out.println(Almacen.toString());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n2.1) ----- Creando clientes -----");
        Cliente cli1 = null, cli2 = null, cli3 = null, cli4 = null, cli5 = null;
        try {
            cli1 = new Cliente(1,
                    new Contacto("xd@gmail.com", "2223334444", new Ubicacion(69,420)),
                    "Guarnieri", "Matias", 11222333, 'h');
            System.out.println(cli1.toString());
            cli2 = new Cliente(2,
                    new Contacto("xd@gmail.com", "2223334444", new Ubicacion(69,420)),
                    "Alegre", "Luis", 11222444, 'm');
            System.out.println(cli2.toString());
            cli3 = new Cliente(3,
                    new Contacto("xd@gmail.com", "2223334444", new Ubicacion(69,420)),
                    "Basilio", "Matias", 11222555, 'h');
            System.out.println(cli3.toString());
            cli4 = new Cliente(4,
                    new Contacto("xd@gmail.com", "2223334444", new Ubicacion(69,420)),
                    "Corsico", "Claudio", 11222666, 'h');
            cli5 = new Cliente(5,
                    new Contacto("xd@gmail.com", "2223334444", new Ubicacion(69,420)),
                    "Seru", "Giran", 11252665, 'h');
            System.out.println(cli4.toString());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n2.2) ----- Creando clientes invalidos -----");
        System.out.println("\n2.2.1) ----- Cliente: DNI invalido -----");
        try {
            new Cliente(69,
                    new Contacto("xd@gmail.com", "2223334444", new Ubicacion(69,420)),
                    "Guarnieri", "Matias", 417859278, 'm');
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n2.2.2) ----- Cliente: SEXO invalido -----");
        try {
            new Cliente(69,
                    new Contacto("xd@gmail.com", "23334444", new Ubicacion(69,420)),
                    "Guarnieri", "Matias", 417859278, 'z');
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n3) ----- Articulos -----");
        System.out.println("\n3.1) ----- Agregando articulos -----");

        try {
            Almacen.agregarArticulosLstArticulos("Alfajor", "7792345678909", 30d);
            Almacen.agregarArticulosLstArticulos("Atun", "7791234567898", 60d);
            Almacen.agregarArticulosLstArticulos("Chocolatin", "7793456789010", 20d);
            Almacen.agregarArticulosLstArticulos("Uranio 236", "7795678901232", 3000d);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        Articulo alfajor = Almacen.traerArticuloPorId(1);
        Articulo atun = Almacen.traerArticuloPorId(2);
        Articulo chocolatin = Almacen.traerArticuloPorId(3);
        Articulo uranio = Almacen.traerArticuloPorId(4);


        System.out.println("\n3.2) ----- Cod de Barras invalido-----");
        try {
            Almacen.agregarArticulosLstArticulos("Paty", "1324364576792854", 30d);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n4) ----- Carritos -----");
        System.out.println("\n4.1) ----- Creando un carrito -----");
        try {
            Almacen.agregarCarritoLstCarritos(cli1); // Crea un carrito automaticamente
            Carrito car1 = Almacen.traerCarritoPorCliente(cli1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n4.2) ----- Agregando y quitando articulos -----");
        try {
            Carrito car1 = Almacen.traerCarritoPorCliente(cli1);
            car1.agregarAlCarrito(atun, 2);
            car1.agregarAlCarrito(chocolatin, 3);
            car1.imprimirListaDeItemsCarrito();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



        System.out.println("\n5) ----- Dias de Retiro -----");
        System.out.println("\n5.1) ----- Creando dias retiro -----");
        //System.out.println(DayOfWeek.of(1).getDisplayName(TextStyle.FULL));
        LocalDate unafecha = LocalDate.now().plusDays(1); // Mañana
        int weekday = unafecha.getDayOfWeek().getValue(); // dia de mañana pero en numero
        //System.out.println("Agenda para "+(fecha.getDayOfWeek().toString())+" "+(fecha.getDayOfMonth()));
        try {
            Almacen.agregarDiaRetiros(weekday, LocalTime.of(9, 0), LocalTime.of(10, 0), 15);
            Almacen.agregarDiaRetiros(weekday, LocalTime.of(17, 30), LocalTime.of(20, 00), 30);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n5.2) ----- Creando y cerrando carritos -----");
        try {
            Almacen.agregarCarritoLstCarritos(cli3);
            Almacen.agregarCarritoLstCarritos(cli4);
            Almacen.agregarCarritoLstCarritos(cli5);
            Carrito car3 = Almacen.traerCarritoPorCliente(cli3);
            Carrito car4 = Almacen.traerCarritoPorCliente(cli4);
            Carrito car5 = Almacen.traerCarritoPorCliente(cli5);
            car3.agregarAlCarrito(uranio, 69);
            car4.agregarAlCarrito(atun, 420);
            car5.agregarAlCarrito(atun, 530);
            LocalTime when = Almacen.traerHoraRetiro(unafecha);
            Almacen.generarUnaEntrega(cli5, unafecha, true, when);
            when = Almacen.traerHoraRetiro(unafecha);
            Almacen.generarUnaEntrega(cli4, unafecha, true, when);
            when = Almacen.traerHoraRetiro(unafecha);
            Almacen.generarUnaEntrega(cli3, unafecha, true, when);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n5.3) ----- Agenda -----");
        Almacen.imprimirAgenda(unafecha);


    }
}
