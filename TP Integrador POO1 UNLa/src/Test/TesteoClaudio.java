package Test;

import Clases.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.function.Function;

public class TesteoClaudio {
    public static void main(String[] args) {

        //// /////////////////////////////////// Entrada de datos ///////////////////////////////////////

        // Creacion del comercio (afuera de todo que lo vamos a usar muchas veces)
        System.out.println("\n0) ----- Jelou Guorl -----");
        Ubicacion ubicacionDelAlmacen = new Ubicacion(1248, 1632);
        Contacto contactoAlmacen = new Contacto("almacen@almacen.com", "1112223333", ubicacionDelAlmacen); //R
        Comercio Almacen = null;

        System.out.println("\n1) ----- Creacion del comercio -----");
        try {
            Almacen = new Comercio(1, contactoAlmacen, "Almacen El Jesú", 123456, 550, 300, 35, 25, 15);
            System.out.println(Almacen.toString());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n2.1) ----- Creando clientes -----");
        Cliente cli1 = null, cli2 = null, cli3 = null, cli4 = null;
        try {
            cli1 = new Cliente(1,
                    new Contacto("xd@gmail.com", "2223334444", new Ubicacion(69,420)),
                    "Guarnieri", "Matias", 11222333, 'm');
            System.out.println(cli1.toString());
            cli2 = new Cliente(2,
                    new Contacto("xd@gmail.com", "2223334444", new Ubicacion(69,420)),
                    "Alegre", "Luis", 11222444, 'm');
            System.out.println(cli2.toString());
            cli3 = new Cliente(3,
                    new Contacto("xd@gmail.com", "2223334444", new Ubicacion(69,420)),
                    "Basilio", "Matias", 11222555, 'm');
            System.out.println(cli3.toString());
            cli4 = new Cliente(4,
                    new Contacto("xd@gmail.com", "2223334444", new Ubicacion(69,420)),
                    "Corsico", "Claudio", 11222666, 'm');
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

        System.out.println("\n3) ----- Articulos -----");
        System.out.println("\n3.1) ----- Agregando articulos -----");

        try {
            Almacen.agregarArticulosLstArticulos("Alfajor", "1234567890123", 30d);
            Almacen.agregarArticulosLstArticulos("Atun", "1234567890123", 60d);
            Almacen.agregarArticulosLstArticulos("Chocolatin", "1234567890123", 20d);
            Almacen.agregarArticulosLstArticulos("Uranio 236", "1234567890123", 3000d);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n4) ----- Dias de Retiro -----");
        System.out.println("\n4.1) ----- Agregando -----");
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

        System.out.println("\n4.2) ----- Un carrito cerrado! -----");
        Articulo pezkado = Almacen.traerArticuloPorId(2);
        Articulo chernobylSorpresa = Almacen.traerArticuloPorId(4);
        try {
            Almacen.agregarCarritoLstCarritos(cli3);
            Almacen.agregarCarritoLstCarritos(cli4);
            Carrito car1 = Almacen.traerCarritoPorCliente(cli3);
            Carrito car2 = Almacen.traerCarritoPorCliente(cli4);
            car1.agregarAlCarrito(chernobylSorpresa, 69);
            car2.agregarAlCarrito(pezkado, 420);
            LocalTime when = Almacen.traerHoraRetiro(unafecha);
            Almacen.generarUnaEntrega(cli4, unafecha, true, when);
            when = Almacen.traerHoraRetiro(unafecha);
            Almacen.generarUnaEntrega(cli3, unafecha, true, when);
        } catch (Exception e) {
            System.out.println("OH NO");
            System.out.println(e.toString());
        }

        System.out.println("\n4.3) ----- Agenda -----");
        Almacen.imprimirAgenda(unafecha);


    }
}
