package Test;
import Clases.*;
import java.time.LocalDate;
import java.time.LocalTime;


public class TesteodelTpFinal {

	public static void main(String[] args) {
		
		// OBJETOS INSTANCIADOS
		        Cliente cliente1 = null;
		        Cliente cliente2 = null;
				Ubicacion ubicacionCliente1 = new Ubicacion(-34.726534, -58.395042);
				Ubicacion ubicacionCliente2 = new Ubicacion(-34.733059, -58.396243);
				Contacto contactoCliente1 = new Contacto("Cliente1@gmail.com", "1562548596", ubicacionCliente1);// R
				Contacto contactoCliente2 = new Contacto("Cliente2@gmail.com", "1565401669", ubicacionCliente2);// R
				Comercio almacenGranate = null;
				Ubicacion ubicacionDelAlmacen = new Ubicacion(-34.731301, -58.393473);
				Contacto contactoAlmacen = new Contacto("almacenGranate@gmail.com", "1560025631", ubicacionDelAlmacen);// R
				

				System.out.println("ESCENARIO 1: VALIDACIONES DE CUIT Y DNI");

				try {
							System.out.println("\n-----Ingreso cliente con DNI validado-----");
							cliente1= new Cliente(2, contactoCliente1, "Guarnieri", "Matias", 41785928,'m');
							System.out.println(cliente1);
							cliente2= new Cliente(3, contactoCliente2, "Basilio", "Matias", 41835909,'m');
							//System.out.println(cliente2);
						}
						catch(Exception e){
							System.out.println(e.getMessage());
						}

				try {
							System.out.println("\n-----Ingreso cliente con DNI invalidado-----");
							cliente1= new Cliente(2, contactoCliente1, "Guarnieri", "Matias", 485798,'m');
							System.out.println(cliente1);
						}
						catch(Exception e){
							System.out.println(e.getMessage());
						}

				try {
							System.out.println("\n-----Ingreso comercio con Cuit validado-----");
							almacenGranate= new Comercio(1, contactoAlmacen, "AlmacenGranate",30418459219l, 100, 500, 10, 50, 10);
							System.out.println("El CUIT del Comercio número= " + almacenGranate.getCuit() + " es válido");
							System.out.println(almacenGranate);
						}
						catch(Exception e){
							System.out.println(e.getMessage());
						}	


				try {			
							System.out.println("\n-----Ingreso comercio con Cuit invalidado-----");
							almacenGranate= new Comercio(1, contactoAlmacen, "AlmacenGranate",27184658219l, 100, 500, 10, 50, 10);
							System.out.println(almacenGranate.getCuit());
						}
						catch(Exception e){
							System.out.println(e.getMessage());
						}			



				/////////////////////////////////////// ESCENARIO 2 (CU: "agregarArticulos()") /////////////////////////////////////// 	
						// Ingreso de Articulos a la lista del comercio


							
						
						
						try {
							System.out.println("\n\n-----Ingreso de Articulos a la lista del comercio-----");
									// articulos                                              
									almacenGranate.agregarArticulosLstArticulos("Chocolate", "7791234567898", 250);// R
									almacenGranate.agregarArticulosLstArticulos("Dulce de leche", "7792345678909", 100);// R
									almacenGranate.agregarArticulosLstArticulos("Saladix", "7794567890121", 125);
									// muestro articulos
									//System.out.println("-------------------------------------------------------");
									System.out.println(almacenGranate.traerArticulo(1)); // R
									System.out.println(almacenGranate.traerArticulo(2));
									System.out.println(almacenGranate.traerArticulo(3));
						}
						catch(Exception e){
							System.out.println(e.getMessage());
						}	
						//escenario 2.b "ingreso de Articulos a la lista de Articulos del Comercio con codigo de barras erróneo"
						try {
							System.out.println("\n\n-----Ingreso de Articulos con codigo de barras invalido-----");
							almacenGranate.agregarArticulosLstArticulos("Chocolate", "7794567898765", 140);
							almacenGranate.agregarArticulosLstArticulos("Dulce de leche", "7794567898765", 40);
						}
						catch(Exception e){
							System.out.println(e.getMessage());
						}


				/////////////////////////////////////// ESCENARIO 3 (CU: "crearCarrito()") ///////////////////////////////////////

				try {
							System.out.println("\n-----Ingreso del carrito-----");		
							almacenGranate.agregarCarritoLstCarritos(cliente1);
							almacenGranate.agregarCarritoLstCarritos(cliente2);
							System.out.println("Carrito ingresado Correctamente");

						}
						catch(Exception e){
							System.out.println(e.getMessage());
						}

						// Ingreso de dos carrito al mismo cliente 
						try {
							System.out.println("\n\n-----Se ingresan dos carritos para un mismo cliente-----");
				                        //llamados
							almacenGranate.agregarCarritoLstCarritos(cliente1);
							almacenGranate.agregarCarritoLstCarritos(cliente1);
							
						}
						catch(Exception e){
							System.out.println(e.getMessage());
						}

				/////////////////////////////////////// ESCENARIO 4 (CU: "agregarAlCarrito()") ///////////////////////////////////////
								// Agrego articulos al carrito

				                 try {
							System.out.println("\n\n-----Agrego productos al carrito-----");
							almacenGranate.traerCarritoPorCliente(cliente1).agregarAlCarrito(almacenGranate.traerArticulo(1), 8);
							almacenGranate.traerCarritoPorCliente(cliente1).agregarAlCarrito(almacenGranate.traerArticulo(2), 7);
							almacenGranate.traerCarritoPorCliente(cliente2).agregarAlCarrito(almacenGranate.traerArticulo(2), 6);
							almacenGranate.traerCarritoPorCliente(cliente2).agregarAlCarrito(almacenGranate.traerArticulo(1), 4);
							System.out.println(almacenGranate.traerCarritoPorCliente(cliente1).mostrarListaDeItemsCarrito());
							System.out.println(almacenGranate.traerCarritoPorCliente(cliente2).mostrarListaDeItemsCarrito());
						}
						catch(Exception e){
							System.out.println(e.getMessage());
						}

				try {
							System.out.println("\n\n-----Sumo productos del carrito-----");
							almacenGranate.traerCarritoPorCliente(cliente1).agregarAlCarrito(almacenGranate.traerArticulo(1), 3);
							almacenGranate.traerCarritoPorCliente(cliente1).agregarAlCarrito(almacenGranate.traerArticulo(2), 2);
							System.out.println(almacenGranate.traerCarritoPorCliente(cliente1).mostrarListaDeItemsCarrito());
						}
						catch(Exception e){
							System.out.println(e.getMessage());
						}

				try {
							System.out.println("\n-----Resto productos del carrito-----");
							almacenGranate.traerCarritoPorCliente(cliente1).sacarDelCarrito(almacenGranate.traerArticulo(1), 2);
							System.out.println(almacenGranate.traerCarritoPorCliente(cliente1).mostrarListaDeItemsCarrito());
						}
						catch(Exception e){
							System.out.println(e.getMessage());
						}
				try {
					almacenGranate.generarUnaEntrega(cliente1, LocalDate.now(), false, LocalTime.of(11,00 )); //definido a retiro local
					almacenGranate.generarUnaEntrega(cliente2, LocalDate.now(), false, LocalTime.of(10,00 ));
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
		/////////////////////////////////////// ESCENARIO 5 (CU: "generarAgenda()") ///////////////////////////////////////
				try {
					System.out.println("\n\n-----Genero agenda del comercio -----");
					
					// agenda
					almacenGranate.agregarDiaRetiros(7, LocalTime.of(07, 00), LocalTime.of(15, 00), 60);// R
					almacenGranate.agregarDiaRetiros(6, LocalTime.of(07, 00), LocalTime.of(15, 00), 60);// R
					almacenGranate.agregarDiaRetiros(5, LocalTime.of(07, 00), LocalTime.of(14, 00), 60);// R
					almacenGranate.agregarDiaRetiros(4, LocalTime.of(07, 00), LocalTime.of(14, 00), 60);// R
					almacenGranate.agregarDiaRetiros(3, LocalTime.of(07, 00), LocalTime.of(14, 00), 60);// R
					almacenGranate.agregarDiaRetiros(2, LocalTime.of(07, 00), LocalTime.of(14, 00), 60);// R
					almacenGranate.agregarDiaRetiros(1, LocalTime.of(07, 00), LocalTime.of(14, 00), 60);// R
					// muestro la agenda
					System.out.println("\nAgenda: ");
					System.out.println(almacenGranate.mostrarAgendaPorFecha(LocalDate.now()));
					System.out.println("\nTurnos ocupados: ");
					System.out.println(almacenGranate.traerTurnosOcupados(LocalDate.now()));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
		/////////////////////////////////////// ESCENARIO 6 (CU: "retiroLocal()") ///////////////////////////////////////
				// retiro local
				System.out.println("\n\n-------------------ppppp-----------------------------------------");
				try {
					System.out.println("\n\n----------Retiro por local---------------");
					almacenGranate.generarUnaEntrega(cliente1, LocalDate.now(), false, LocalTime.of(11,30 ));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
		       //retiro local (excepcion por carrito cerrado)	
				try {
					System.out.println("\n\n----------Retiro por local (carrito cerrado)---------------");
					almacenGranate.cerrarCarrito(cliente1);
					almacenGranate.generarUnaEntrega(cliente1, LocalDate.now(), false, LocalTime.of(10, 0)); 
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

		/////////////////////////////////////// ESCENARIO 7 (CU: "totalAPagarCarrito()") ///////////////////////////////////////
				// se cierra el carrito y calculo el costo
				try {
					System.out.println("\n-------Cierro el carrito y calculo el total a pagar, incluyendo los descuentos---");
					almacenGranate.cerrarCarrito(cliente1);
					System.out.println(almacenGranate.imprimirCarrito(cliente1));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				

		/////////////////////////////////////// ESCENARIO 8 (CU: "envio()") ///////////////////////////////////////
				//envio a domicilio
				try {
					System.out.println("\n\n---------- Envio a domicilio---------------");
					//almacenGranate.agregarCarritoLstCarritos(cliente2);
					almacenGranate.traerCarritoPorCliente(cliente2).agregarAlCarrito(almacenGranate.traerArticulo(1), 10);
					almacenGranate.generarUnaEntrega(cliente2, LocalDate.now(), false, LocalTime.of(10, 0), LocalTime.of(12, 0),
							ubicacionCliente2);// envio 
					almacenGranate.cargarDestino(cliente2);
					
					System.out.println("\n-----------Cierro el carrito y calculo el total a pagar, incluyendo los descuentos.---------");
					almacenGranate.cerrarCarrito(cliente2);
					System.out.println("\n" + almacenGranate.imprimirCarrito(cliente2));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}// Fin main

		}// Fin test