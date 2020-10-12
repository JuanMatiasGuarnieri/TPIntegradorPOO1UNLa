package Test;
import Clases.*;


import java.time.LocalDate;
import java.time.LocalTime;


public class TesteoDelTpFinal2 {

	public static void main(String[] args) {
		
		// OBJETOS INSTANCIADOS
		        Cliente cliente1 = null;
		        Cliente cliente2 = null;
		        Cliente cliente3 = null;
		        Cliente cliente4 = null;
		        LocalDate unaFecha = LocalDate.now();
		        int weekday = unaFecha.getDayOfWeek().getValue();
		        Ubicacion ubicacionCliente1 = new Ubicacion(-34.912329, -56.181482);
				Ubicacion ubicacionCliente2 = new Ubicacion(-34.902366, -56.193049);
				Ubicacion ubicacionCliente3 = new Ubicacion(-34.899121, -56.189910);
				Ubicacion ubicacionCliente4 = new Ubicacion(-34.899121, -56.189910);
				Contacto contactoCliente1 = new Contacto("Cliente1@gmail.com", "1562548596", ubicacionCliente1);// R
				Contacto contactoCliente2 = new Contacto("Cliente2@gmail.com", "1565401669", ubicacionCliente2);// R
				Contacto contactoCliente3 = new Contacto("Cliente3@gmail.com", "1542788149", ubicacionCliente3);// R
				Contacto contactoCliente4 = new Contacto("Cliente4@gmail.com", "1549828149", ubicacionCliente3);// R
				Comercio almacenGranate = null;
				Ubicacion ubicacionDelAlmacen = new Ubicacion(-34.911996, -56.186402);
				Contacto contactoAlmacen = new Contacto("almacenGranate@gmail.com", "1560025631", ubicacionDelAlmacen);// R
				

				System.out.println("ESCENARIO 1: VALIDACIONES DE CUIT Y DNI");

				try {
							System.out.println("\n-----Ingreso cliente con DNI validado-----");
							cliente1= new Cliente(2, contactoCliente1, "Guarnieri", "Matias", 41785928,'m');
							System.out.println(cliente1);
							cliente2= new Cliente(3, contactoCliente2, "Basilio", "Matias", 41835909,'m');
							System.out.println(cliente2);
							cliente3= new Cliente(4, contactoCliente3, "Corsico", "Claudio",42001124,'m');
							System.out.println(cliente3);
							cliente4= new Cliente(5, contactoCliente4, "Alegre", "Luis",42801924,'m');
							System.out.println(cliente4);
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
					System.out.println("\n-----Ingreso cliente con sexo invalidado -----");
					cliente1= new Cliente(2, contactoCliente1, "Guarnieri", "Matias", 485798,'t');
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
							almacenGranate.agregarCarritoLstCarritos(cliente3);
							almacenGranate.agregarCarritoLstCarritos(cliente4);
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
							almacenGranate.traerCarritoPorCliente(cliente1).agregarAlCarrito(almacenGranate.traerArticulo(1), 9);
							almacenGranate.traerCarritoPorCliente(cliente1).agregarAlCarrito(almacenGranate.traerArticulo(2), 6);
							almacenGranate.traerCarritoPorCliente(cliente2).agregarAlCarrito(almacenGranate.traerArticulo(2), 6);
							almacenGranate.traerCarritoPorCliente(cliente2).agregarAlCarrito(almacenGranate.traerArticulo(1), 4);
							almacenGranate.traerCarritoPorCliente(cliente3).agregarAlCarrito(almacenGranate.traerArticulo(3), 5);
							almacenGranate.traerCarritoPorCliente(cliente3).agregarAlCarrito(almacenGranate.traerArticulo(2), 4);
							almacenGranate.traerCarritoPorCliente(cliente4).agregarAlCarrito(almacenGranate.traerArticulo(1), 7);
							almacenGranate.traerCarritoPorCliente(cliente4).agregarAlCarrito(almacenGranate.traerArticulo(3), 3);
							System.out.println(almacenGranate.traerCarritoPorCliente(cliente1).mostrarListaDeItemsCarrito());
							System.out.println(almacenGranate.traerCarritoPorCliente(cliente2).mostrarListaDeItemsCarrito());
							System.out.println(almacenGranate.traerCarritoPorCliente(cliente3).mostrarListaDeItemsCarrito());
							System.out.println(almacenGranate.traerCarritoPorCliente(cliente4).mostrarListaDeItemsCarrito());
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
				
				//4.d Eliminar Articulos a la lista de items
				try {
					System.out.println("\n-----Eliminar articulos de la lista------");
					//saco mis 10 choc
					System.out.println("saco mis 10 chocolates");
					almacenGranate.traerCarritoPorCliente(cliente1).sacarDelCarrito(almacenGranate.traerArticulo(1), 10);
					almacenGranate.traerCarritoPorCliente(cliente1).sacarDelCarrito(almacenGranate.traerArticulo(2), 3);
					System.out.println(almacenGranate.traerCarritoPorCliente(cliente1).mostrarListaDeItemsCarrito());
					//vuelvo a agregar 10 choc
					System.out.println("vuelvo a agregar 10 chocolates");
					almacenGranate.traerCarritoPorCliente(cliente1).agregarAlCarrito(almacenGranate.traerArticulo(1), 10);
					System.out.println(almacenGranate.traerCarritoPorCliente(cliente1).mostrarListaDeItemsCarrito());
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
             /////////////////////////////////////// ESCENARIO 5 (CU: "generarAgenda()") ///////////////////////////////////////
				try {
					
					almacenGranate.agregarDiaRetiros(weekday, LocalTime.of(9, 0), LocalTime.of(10, 0), 15);
		            almacenGranate.agregarDiaRetiros(weekday, LocalTime.of(17, 30), LocalTime.of(20, 00), 30);
					// muestro la agenda
					
					LocalTime when = almacenGranate.traerHoraRetiro(unaFecha);
					almacenGranate.generarUnaEntrega(cliente1, unaFecha, false, when ); //definido a retiro local
					when = almacenGranate.traerHoraRetiro(unaFecha);
					almacenGranate.generarUnaEntrega(cliente2, unaFecha, false, when );
					when = almacenGranate.traerHoraRetiro(unaFecha);
					almacenGranate.imprimirAgenda(unaFecha);
					System.out.println("\nTurnos ocupados: ");
					System.out.println(almacenGranate.traerTurnosOcupados(unaFecha));
					System.out.println("\nTurnos libres: ");
					System.out.println(almacenGranate.generarTurnosLibres(unaFecha));
					System.out.println("\n-------Cierro carritos y calculo el total a pagar, incluyendo los descuentos---");
					almacenGranate.cerrarCarrito(cliente1);
					almacenGranate.cerrarCarrito(cliente2);
					System.out.println(almacenGranate.imprimirCarrito(cliente1));
					System.out.println(almacenGranate.imprimirCarrito(cliente2));
					
					
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				
				
				
		/////////////////////////////////////// ESCENARIO 5 (CU: "generarAgenda()") ///////////////////////////////////////
			/*	try {
					System.out.println("\n\n-----Genero agenda del comercio -----");
					
					// agenda
					almacenGranate.agregarDiaRetiros(weekday, LocalTime.of(9, 0), LocalTime.of(10, 0), 15);
		            almacenGranate.agregarDiaRetiros(weekday, LocalTime.of(17, 30), LocalTime.of(20, 00), 30);
					// muestro la agenda
					System.out.println("\nAgenda: ");
					almacenGranate.imprimirAgenda(unaFecha);

					System.out.println("\nTurnos ocupados: ");
					System.out.println(almacenGranate.traerTurnosOcupados(LocalDate.now()));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}*/
		/////////////////////////////////////// ESCENARIO 6 (CU: "retiroLocal()") ///////////////////////////////////////
				// retiro local
				System.out.println("\n\n-------------------ppppp-----------------------------------------");
				try {
					System.out.println("\n\n----------Retiro por local---------------");
					System.out.println("\n\nPrimero mostramos la agenda , luego agregamos otra entrega y la volvemos a mostrar");
					LocalTime when = almacenGranate.traerHoraRetiro(unaFecha);
					almacenGranate.imprimirAgenda(unaFecha);
					almacenGranate.generarUnaEntrega(cliente3, unaFecha, false, when );
					System.out.println("\n\nVolvemos a mostrar la agenda, esta vez con un nuevo turno");
					almacenGranate.imprimirAgenda(unaFecha);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
		       //retiro local (excepcion por carrito cerrado)	
				try {
					System.out.println("\n\n----------Retiro por local (carrito cerrado)---------------");
					almacenGranate.cerrarCarrito(cliente3);
					almacenGranate.generarUnaEntrega(cliente3, LocalDate.now(), false, LocalTime.of(10, 0)); 
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

		/////////////////////////////////////// ESCENARIO 7 (CU: "totalAPagarCarrito()") ///////////////////////////////////////
				// se cierra el carrito y calculo el costo
				try {
					System.out.println("\n-------Cierro el carrito y calculo el total a pagar, incluyendo los descuentos---");
					almacenGranate.cerrarCarrito(cliente3);
					System.out.println(almacenGranate.imprimirCarrito(cliente3));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
	
				

		/////////////////////////////////////// ESCENARIO 8 (CU: "envio()") ///////////////////////////////////////
				//envio a domicilio
				try {
					System.out.println("\n\n---------- Envio a domicilio---------------");
					//almacenGranate.agregarCarritoLstCarritos(cliente2);
					almacenGranate.traerCarritoPorCliente(cliente4).agregarAlCarrito(almacenGranate.traerArticulo(1), 10);
					almacenGranate.generarUnaEntrega(cliente4, unaFecha, false, LocalTime.of(10, 0), LocalTime.of(12, 0),
							ubicacionCliente4);// envio 
					almacenGranate.cargarDestino(cliente4);
					
					System.out.println("\n-----------Cierro el carrito y calculo el total a pagar, incluyendo los descuentos.---------");
					almacenGranate.cerrarCarrito(cliente4);
					System.out.println("\n" + almacenGranate.imprimirCarrito(cliente4));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}// Fin main

		}// Fin test