package Test;

import Clases.*;

public class TesteoCUIT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			//Creo comercio
			Ubicacion ubicacionComercio = new Ubicacion(-34.733406, -58.393577);
			Contacto contactoComercio = new Contacto("AlmanceGranate@gmail.com", "1142335531", ubicacionComercio);
			Comercio almacen = new Comercio(1, contactoComercio, "Almacen Granate.", 30418459219l, 500, 15, 3, 25, 10);
			
			//Creo cliente
			Ubicacion ubicacionContacto1 = new Ubicacion(-34.761078, -58.397547);
			Contacto contactoChurrasco = new Contacto("Elnazidenazis@gmail.com", "1187445512", ubicacionContacto1);
			Cliente cliente1 = new Cliente(2, contactoChurrasco, "Seru", "Giran", 35007121L, 'h');
			
			
			
		System.out.println("TEST DNI INCORRECTO");
		//corto
			System.out.println("Corto: ");
			try {
				cliente1.setDni(1234L);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		//largo
			System.out.println("Largo");
			try {
				cliente1.setDni(20350071215L);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		
			
	    System.out.println("TEST DNI CORRECTO (SI ES CORRECTO NO TIRA EXCEPCION)");
	    try {
			cliente1.setDni(41835909L);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
			
		System.out.println();
		System.out.println();
		//Test sexo incorrecto
		System.out.println("TEST SEXO INCORRECTO");
		try {
			cliente1.setSexo('T');
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("TEST SEXO CORRECTO (SI ES CORRECTO NO TIRA EXCEPCION)");
		try {
			cliente1.setSexo('M');
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println();
		System.out.println();
		//Test cuit incorrecto
		System.out.println("TEST CUIT INCORRECTO");
		//corto
			System.out.println("Corto: ");
			try {
				almacen.setCuit(35007121L);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		
		//numero verificador alterado
			System.out.println("Numero verificador alterado: ");
			try {
				almacen.setCuit(30707661490L);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		
		//digito alterado
			System.out.println("Digito alterado: ");
			try {
				almacen.setCuit(30707061492L);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		
		System.out.println("TEST CUIT CORRECTO (SI ES CORRECTO NO TIRA EXCEPCION)");
		try {
			almacen.setCuit(30418459219l);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
			
		}
		
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
		
	}


