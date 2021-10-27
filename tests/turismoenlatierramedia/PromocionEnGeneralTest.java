package turismoenlatierramedia;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PromocionEnGeneralTest {
	
	Atraccion moria, minasDeTirith, laComarca, mordor, 
	  		  abismoDeHelm, lothlorien, erebor, bosqueNegro,
	  		delicatessen, dorien, mardelplata, chascomus, cataratasDeChocolate, elVaticano, laBaticueva;
	
	List<Atraccion> listaDeAtraccionesA, listaDeAtraccionesB, listaDeAtraccionesC;
	PromocionAbsoluta promoNueva;	
	PromocionPorcentual promoFantastica;
	PromocionAxB promoGenial;
	

	
	@Before
	public void setUp() throws Exception {
		// orden de los parametros para construir atracción:
		// (nombre, costo, tiempoDeDuracion, cupo, tipoDeAtraccion)
		// (String nombre, double costo, double tiempoDeDuracion, int cupo, TipoDeAtraccion tipoDeAtraccion) {

		moria = new Atraccion(1, "Moria", 10, 2, 6,  TipoDeAtraccion.AVENTURA);
		minasDeTirith = new Atraccion(2, "Minas de Tirith", 5, 2.5, 25, TipoDeAtraccion.PAISAJE);
		laComarca = new Atraccion(3, "La Comarca", 3, 6.5, 150, TipoDeAtraccion.DEGUSTACION);
		mordor = new Atraccion(4, "Mordor", 25, 3, 4, TipoDeAtraccion.AVENTURA);
		abismoDeHelm = new Atraccion(5, "Abismo de Helm", 5, 2, 15, TipoDeAtraccion.PAISAJE);
		lothlorien = new Atraccion(6, "Lothlórien", 35, 1, 30, TipoDeAtraccion.DEGUSTACION);
		erebor = new Atraccion(7, "Erebor", 12, 3, 32, TipoDeAtraccion.PAISAJE);
		bosqueNegro = new Atraccion(8, "Bosque Negro", 3, 4, 12, TipoDeAtraccion.AVENTURA);
		delicatessen = new Atraccion(0, "Una con poco cupo", 3, 1, 2, TipoDeAtraccion.DEGUSTACION);
		dorien = new Atraccion(0, "Dorien", 25, 3, 10, TipoDeAtraccion.AVENTURA);
		mardelplata = new Atraccion(9, "Mar del Plata", 25, 3, 12, TipoDeAtraccion.AVENTURA);
		chascomus = new Atraccion(10, "Chascomus", 14, 3.5, 8, TipoDeAtraccion.PAISAJE);
		cataratasDeChocolate = new Atraccion(0, "Cataratas", 13, 3, 10, TipoDeAtraccion.DEGUSTACION);
		elVaticano = new Atraccion(0, "El Vaticano", 1, 1, 1, TipoDeAtraccion.AVENTURA);
		laBaticueva = new Atraccion(0, "La Baticueva", 1, 1, 1, TipoDeAtraccion.AVENTURA);

		listaDeAtraccionesA= new ArrayList<Atraccion>();
		listaDeAtraccionesA.add(mordor);
		listaDeAtraccionesA.add(dorien);
		listaDeAtraccionesA.add(mardelplata);
		listaDeAtraccionesA.add(lothlorien);
		
		promoNueva = new PromocionAbsoluta(2,"Nueva", TipoDeAtraccion.AVENTURA, 22, listaDeAtraccionesA);
		
		listaDeAtraccionesB = new ArrayList<Atraccion>();
		listaDeAtraccionesB.add(minasDeTirith);
		listaDeAtraccionesB.add(abismoDeHelm);
		listaDeAtraccionesB.add(erebor);
		listaDeAtraccionesB.add(chascomus);
		
		promoFantastica = new PromocionPorcentual(1,"Fantastica", TipoDeAtraccion.PAISAJE, 20, listaDeAtraccionesB);
		
		listaDeAtraccionesC = new ArrayList<Atraccion>();
		listaDeAtraccionesC.add(elVaticano);
		listaDeAtraccionesC.add(laBaticueva);
		
		promoGenial = new PromocionAxB(4,"Genial", TipoDeAtraccion.AVENTURA, listaDeAtraccionesC);
	}

	@Test
	public void obtenerCuposDisponibles() {
		int cuposEsperados = 4;
		assertEquals(cuposEsperados, promoNueva.getLugaresDisponibles());
	}
	
	@Test 
	public void obtieneCuposEsperadosLuegoDeOcuparDosLugares() throws AtraccionException {
		int cuposEsperados = 6;
		chascomus.ocuparPlaza();
		chascomus.ocuparPlaza();
		assertEquals(cuposEsperados, promoFantastica.getLugaresDisponibles());
	}
	
	@Test
	public void devuelveCorrectamenteTiempoDeDuracion() {
		double tiempoEsperado = mardelplata.getTiempoDeDuracion() 
				                + dorien.getTiempoDeDuracion() 
				                + mordor.getTiempoDeDuracion()
				                + lothlorien.getTiempoDeDuracion();
		assertEquals(tiempoEsperado, promoNueva.getTiempoDeDuracion(), 0);
	}
	
	@Test
	public void devuelveCorrectamenteTiempoDeDuracionSegundaPrueba() {
		double tiempoEsperado = 11;
		assertEquals(tiempoEsperado, promoFantastica.getTiempoDeDuracion(), 0);
	}
	
	@Test
	public void ocupaUnLugar() throws AtraccionException {
		int lugaresEsperadosMordor = mordor.getLugaresDisponibles() - 1;
		int lugaresEsperadosDorien = dorien.getLugaresDisponibles() - 1;
		int lugaresEsperadosMarDelPlata = mardelplata.getLugaresDisponibles() - 1;
		int lugaresEsperadoslLothlorien = lothlorien.getLugaresDisponibles() - 1;
		
		promoNueva.ocuparPlaza();
		assertEquals(lugaresEsperadosMordor, mordor.getLugaresDisponibles());
		assertEquals(lugaresEsperadosDorien, dorien.getLugaresDisponibles());
		assertEquals(lugaresEsperadosMarDelPlata, mardelplata.getLugaresDisponibles());
		assertEquals(lugaresEsperadoslLothlorien, lothlorien.getLugaresDisponibles());
	}
}
