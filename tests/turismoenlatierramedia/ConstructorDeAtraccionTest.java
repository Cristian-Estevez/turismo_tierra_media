package turismoenlatierramedia;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import turismoenlatierramedia.Atraccion;
import turismoenlatierramedia.ConstructorDeAtraccion;
import turismoenlatierramedia.TipoDeAtraccion;

public class ConstructorDeAtraccionTest {
	
	ConstructorDeAtraccion cons1;
	ArrayList<Atraccion> atracciones, atraccionesEsperadas;
	String rutaArchivo;
	Atraccion moria, minasDeTirith, laComarca, mordor, 
	  abismoDeHelm, lothlorien, erebor, bosqueNegro;
	
	@Before
	public void setup() {
		rutaArchivo = "archivos/atracciones.in";

		atracciones = new ArrayList<Atraccion>();
		atraccionesEsperadas = new ArrayList<Atraccion>();
		
		moria = new Atraccion("Moria", 10, 2, 6,  TipoDeAtraccion.AVENTURA);
		minasDeTirith = new Atraccion("Minas de Tirith", 5, 2.5, 25, TipoDeAtraccion.PAISAJE);
		laComarca = new Atraccion("La Comarca", 3, 6.5, 150, TipoDeAtraccion.DEGUSTACION);
		mordor = new Atraccion("Mordor", 25, 3, 4, TipoDeAtraccion.AVENTURA);
		abismoDeHelm = new Atraccion("Abismo de Helm", 5, 2, 15, TipoDeAtraccion.PAISAJE);
		lothlorien = new Atraccion("Lothlórien", 35, 1, 30, TipoDeAtraccion.DEGUSTACION);
		erebor = new Atraccion("Erebor", 12, 3, 32, TipoDeAtraccion.PAISAJE);
		bosqueNegro = new Atraccion("Bosque Negro", 3, 4, 12, TipoDeAtraccion.AVENTURA);

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
	public void test() throws FileNotFoundException {
		cons1 = new ConstructorDeAtraccion(rutaArchivo);
		atracciones = cons1.crearListaAtracciones();
		assertEquals(atraccionesEsperadas, atracciones);
		
	}

}
