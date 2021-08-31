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
	
	Atraccion moria, minasDeTirith, laComarca, mordor, 
	  		  abismoDeHelm, lothlorien, erebor, bosqueNegro,
	  		  unaConPocoCupo, dorien, mardelplata;
	
	List<Atraccion> listaDeAtraccionesA, listaDeAtraccionesB;
	Promocion promoNueva;

	@Before
	public void setUp() throws Exception {
		// orden de los parametros para construir atracción:
		// (nombre, costo, tiempoDeDuracion, cupo, tipoDeAtraccion)
		// (String nombre, double costo, double tiempoDeDuracion, int cupo, TipoDeAtraccion tipoDeAtraccion) {

		moria = new Atraccion("Moria", 10, 2, 6,  TipoDeAtraccion.AVENTURA);
		minasDeTirith = new Atraccion("Minas de Tirith", 5, 2.5, 25, TipoDeAtraccion.PAISAJE);
		laComarca = new Atraccion("La Comarca", 3, 6.5, 150, TipoDeAtraccion.DEGUSTACION);
		mordor = new Atraccion("Mordor", 25, 3, 4, TipoDeAtraccion.AVENTURA);
		abismoDeHelm = new Atraccion("Abismo de Helm", 5, 2, 15, TipoDeAtraccion.PAISAJE);
		lothlorien = new Atraccion("Lothlórien", 35, 1, 30, TipoDeAtraccion.DEGUSTACION);
		erebor = new Atraccion("Erebor", 12, 3, 32, TipoDeAtraccion.PAISAJE);
		bosqueNegro = new Atraccion("Bosque Negro", 3, 4, 12, TipoDeAtraccion.AVENTURA);
		unaConPocoCupo = new Atraccion("Una con poco cupo", 3, 1, 2, TipoDeAtraccion.DEGUSTACION);
		dorien = new Atraccion("Dorien", 25, 3, 10, TipoDeAtraccion.AVENTURA);
		mardelplata = new Atraccion("Mar del Plata", 25, 3, 12, TipoDeAtraccion.AVENTURA);

		listaDeAtraccionesA= new ArrayList<Atraccion>();
		listaDeAtraccionesA.add(mordor);
		listaDeAtraccionesA.add(dorien);
		listaDeAtraccionesA.add(mardelplata);
		listaDeAtraccionesA.add(lothlorien);
		
		promoNueva = new Promocion("Nueva", 22, TipoDeAtraccion.AVENTURA, listaDeAtraccionesA);
	}

	@Test
	public void obtenerCuposDisponibles() {
		int cuposEsperados = 4;
		assertEquals(cuposEsperados, promoNueva.getLugaresDisponibles());
	}
	
	@Test
	public void devuelveCorrectamenteTiempoDeDuracion() {
		double tiempoEsperado = mardelplata.getTiempoDeDuracion() 
				                + dorien.getTiempoDeDuracion() 
				                + mordor.getTiempoDeDuracion()
				                + lothlorien.getTiempoDeDuracion();
								
		System.out.println(tiempoEsperado);
		assertEquals(tiempoEsperado, promoNueva.getTiempoDeDuracion(), 0);
	}

}
