package turismoenlatierramedia;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ConstructorDeAtraccionTest {
	
	ConstructorDeAtraccion cons1;
	ArrayList<Atraccion> atracciones, atraccionesEsperadas;
	String rutaArchivo;
	Atraccion moria, minasDeTirith, laComarca, mordor, 
	  abismoDeHelm, lothlorien, erebor, bosqueNegro;
	
	@Before
	public void setup() {
		rutaArchivo = "archivosParaTests/atraccionesParaTests.in";

		atracciones = new ArrayList<Atraccion>();
		atraccionesEsperadas = new ArrayList<Atraccion>();
		
		moria = new Atraccion(1, "Moria", 10, 2, 6,  TipoDeAtraccion.AVENTURA);
		minasDeTirith = new Atraccion(2, "Minas de Tirith", 5, 2.5, 25, TipoDeAtraccion.PAISAJE);
		laComarca = new Atraccion(3, "La Comarca", 3, 6.5, 150, TipoDeAtraccion.DEGUSTACION);
		mordor = new Atraccion(4, "Mordor", 25, 3, 4, TipoDeAtraccion.AVENTURA);
		abismoDeHelm = new Atraccion(5, "Abismo de Helm", 5, 2, 15, TipoDeAtraccion.PAISAJE);
		lothlorien = new Atraccion(6, "Lothlórien", 35, 1, 30, TipoDeAtraccion.DEGUSTACION);
		erebor = new Atraccion(7, "Erebor", 12, 3, 32, TipoDeAtraccion.PAISAJE);
		bosqueNegro = new Atraccion(8, "Bosque Negro", 3, 4, 12, TipoDeAtraccion.AVENTURA);

		atraccionesEsperadas.add(moria);
		atraccionesEsperadas.add(minasDeTirith);
		atraccionesEsperadas.add(laComarca);
		atraccionesEsperadas.add(mordor);
		atraccionesEsperadas.add(abismoDeHelm);
		atraccionesEsperadas.add(lothlorien);
		atraccionesEsperadas.add(erebor);
		atraccionesEsperadas.add(bosqueNegro);
		
	}
	
	@Test
	public void creaLasAtraccionesCorrectamenteDesdeArchivo() throws FileNotFoundException {
		cons1 = new ConstructorDeAtraccion();
		atracciones = cons1.crearListaAtracciones(rutaArchivo);
		assertEquals(atraccionesEsperadas, atracciones);
	}
}
