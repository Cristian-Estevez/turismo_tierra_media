package turismo_tierra_media;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import turismoenlatierramedia.Atraccion;
import turismoenlatierramedia.Promocion;
import turismoenlatierramedia.TipoDeAtraccion;

public class PromocionTest {
Atraccion mordor, dorien, mardelplata;
List <Atraccion> listaDeAtracciones ;
Promocion promoNueva ;
	
	@Before
	public void setUp() throws Exception {
		mordor = new Atraccion("Mordor", 25, 3, 44, TipoDeAtraccion.AVENTURA);
		dorien = new Atraccion("Mordor", 25, 3, 10, TipoDeAtraccion.AVENTURA);
		mardelplata = new Atraccion("Mordor", 25, 3, 12, TipoDeAtraccion.AVENTURA);
		listaDeAtracciones=new ArrayList<Atraccion> ();
		listaDeAtracciones.add(mordor);
		listaDeAtracciones.add(dorien);
		listaDeAtracciones.add(mardelplata);
		promoNueva= new Promocion("Nueva",22,TipoDeAtraccion.AVENTURA,listaDeAtracciones) ;
		
		
	}

	@Test
	public void test() {
		int cuposEsperados =10;
		assertEquals(cuposEsperados, promoNueva.getLugaresDisponibles());
		
		// public Promocion(String nombre, double tiempoDeDuracion, TipoDeAtraccion tipoDeAtraccion,
		
		
		
		
		
	}

}
