package Test;

import java.time.LocalTime;

import Clases.Cliente;
import Clases.Comercio;
import Clases.Contacto;
import Clases.Ubicacion;

public class TesteoCharrua {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//5. DiaRetiro
		try {
			
		Ubicacion ubicacionCliente1= new Ubicacion(30, 21);
	    Contacto contactoCliente1= new Contacto("Cliente@servidor.com", "116485216", ubicacionCliente1);
		Cliente cliente1= new Cliente(1, contactoCliente1, "Oscar", "Moro", 40856987,'m');
		Ubicacion ubicacionDelAlmacen= new Ubicacion(98, 130);
		Contacto contAlmacen= new Contacto("almacen@servidor.com","2512585",ubicacionDelAlmacen);
		Comercio almacenGranate= new Comercio(1, contAlmacen, "AlmacenGranate",30418459219l, 300, 622, 15, 40, 25);
		almacenGranate.agregarDiaRetiros(7,LocalTime.of(8, 30),LocalTime.of(9, 30),30);
		almacenGranate.agregarDiaRetiros(6,LocalTime.of(9, 30),LocalTime.of(10, 30),30);
		
		System.out.println(almacenGranate.traerDiaRetiroPorId(1) );
		System.out.println(almacenGranate.traerDiaRetiroPorId(2) );
		
		//Weas del localtime
		/*LocalDate localDate = LocalDate.of(2014, Month.JUNE, 21);
	    DayOfWeek dayOfWeek = DayOfWeek.from(localDate);
	    dayOfWeek = localDate.getDayOfWeek();
	    System.out.println(dayOfWeek.getValue());
	    LocalTime l = LocalTime.now();
	    LocalTime s = l.plus(Duration.ofHours(2));
	    System.out.println(s);*/
	   // System.out.println(dayOfWeek.get(ChronoField.DAY_OF_WEEK));
		//almacenGranate.agregarDiaRetiroLstDiaRetiro(2,8,LocalTime.of(10, 30),LocalTime.of(11, 30),20);
		//DiaRetiro diaRetiro1 = new DiaRetiro (1,7,LocalTime.of(8, 30),LocalTime.of(9, 30),30);
		
		//System.out.println("La hora es: " +diaRetiro1.getHoraDesde()+ " " +diaRetiro1.getHoraHasta());
		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
