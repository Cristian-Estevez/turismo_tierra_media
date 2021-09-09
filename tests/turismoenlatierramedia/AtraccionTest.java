package turismoenlatierramedia;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AtraccionTest {

	Usuario eowyn, gandalf, sam, galadriel;
	Atraccion moria, minasDeTirith, laComarca, mordor, 
			  abismoDeHelm, lothlorien, erebor, bosqueNegro,
			  unaConPocoCupo;
	
	@Before
	public void setup() {
		eowyn = new Usuario("Eowyn", 10, 8, TipoDeAtraccion.AVENTURA);
		gandalf = new Usuario("Gandalf", 100, 5, TipoDeAtraccion.PAISAJE);
		sam = new Usuario("Sam", 36, 8, TipoDeAtraccion.DEGUSTACION);
		galadriel = new Usuario("Galadriel", 120, 4, TipoDeAtraccion.PAISAJE);
		
		// orden de los parametros para construir atracción:
		// (nombre, costo, tiempoDeDuracion, cupo, tipoDeAtraccion)
		moria = new Atraccion("Moria", 10, 2, 6,  TipoDeAtraccion.AVENTURA);
		minasDeTirith = new Atraccion("Minas de Tirith", 5, 2.5, 25, TipoDeAtraccion.PAISAJE);
		laComarca = new Atraccion("La Comarca", 3, 6.5, 150, TipoDeAtraccion.DEGUSTACION);
		mordor = new Atraccion("Mordor", 25, 3, 4, TipoDeAtraccion.AVENTURA);
		abismoDeHelm = new Atraccion("Abismo de Helm", 5, 2, 15, TipoDeAtraccion.PAISAJE);
		lothlorien = new Atraccion("Lothlórien", 35, 1, 30, TipoDeAtraccion.DEGUSTACION);
		erebor = new Atraccion("Erebor", 12, 3, 32, TipoDeAtraccion.PAISAJE);
		bosqueNegro = new Atraccion("Bosque Negro", 3, 4, 12, TipoDeAtraccion.AVENTURA);
		unaConPocoCupo = new Atraccion("Una con poco cupo", 3, 1, 2, TipoDeAtraccion.DEGUSTACION);
		
	}
	@Test
	public void lasPlazasDisponiblesSeDescuentanCorrectamenteAlComprarAtraccion() throws UsuarioException, AtraccionException {
		int cupoDisponibleEsperado1 = moria.getLugaresDisponibles() - 1;
		int cupoDisponibleEsperado2 = moria.getLugaresDisponibles() - 3;
		eowyn.comprarProducto(moria);
		assertEquals(cupoDisponibleEsperado1, moria.getLugaresDisponibles());
		
		gandalf.comprarProducto(moria);
		sam.comprarProducto(moria);
		assertEquals(cupoDisponibleEsperado2, moria.getLugaresDisponibles());		
	}

	@Test 
	public void unaVezOcupadosTodosLosCuposNoSigueDescontando() {
		int cupoEsperado1 = 1;
		int cupoEsperado2 = 0;
		eowyn.comprarProducto(unaConPocoCupo);
		assertEquals(cupoEsperado1, unaConPocoCupo.getLugaresDisponibles());
		gandalf.comprarProducto(unaConPocoCupo);
		assertEquals(cupoEsperado2, unaConPocoCupo.getLugaresDisponibles());
		sam.comprarProducto(unaConPocoCupo);
		assertEquals(cupoEsperado2, unaConPocoCupo.getLugaresDisponibles());
	}
}
