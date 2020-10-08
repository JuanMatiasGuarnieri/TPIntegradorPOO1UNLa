package Test;
import java.time.LocalDate;
import java.time.LocalTime;

import Clases.*;
public class TesteoCUIT { 

	public static void main(String[] args) {

		//OBJETOS INSTANCIADOS
		Ubicacion ubicacionCliente1= new Ubicacion(-34.726534,-58.395042);
		Ubicacion ubicacionCliente2= new Ubicacion(-34.733059,-58.396243);
		Contacto contactoCliente1= new Contacto("Cliente1@hotmail.com", "116485216", ubicacionCliente1);
		Contacto contactoCliente2= new Contacto("Cliente2@hotmail.com", "119418216", ubicacionCliente2);
		Cliente cliente1= null;
		Cliente cliente2= null;
		Ubicacion ubicacionDelAlmacen= new Ubicacion(-34.731301 , -58.393473);
		Contacto contAlmacen= new Contacto("almacen@hotmail.com","1614585",ubicacionDelAlmacen);
		Comercio almacenGranate= null;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("///////////Testeo de cuit////////////.");
		System.out.println("CUIT VALIDADO: VERDADERO.");
		System.out.println("COMO ES VERDADERO NO TIRA EXCEPCION.");
		System.out.println();
		
		try {
		almacenGranate= new Comercio(1, contAlmacen, "AlmacenGranate",30418459219l, 100, 500, 10, 50, 10);
		//System.out.println("El cuit es: " +almacenGranate.validarIdentificadorUnico(30418459219l));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println("CUIT VALIDADO: ERRÓNEO CON EXCEPCION.");
		try {
			almacenGranate= new Comercio(1, contAlmacen, "AlmacenGranate",33418459219l, 100, 500, 10, 50, 10);
			//System.out.println("Penes garfield" +almacenGranate.validarIdentificadorUnico(33389451229l));
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		
	}
	}
	
	
//cierra clase

