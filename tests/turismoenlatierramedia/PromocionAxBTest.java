package turismoenlatierramedia;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import turismoenlatierramedia.Atraccion;
import turismoenlatierramedia.PromocionAxB;
import turismoenlatierramedia.TipoDeAtraccion;

public class PromocionAxBTest {

	Atraccion 	minasDeTirith, abismoDeHelm, erebor;

	List<Atraccion> listaDeAtraccionesA;
	PromocionAxB packPaisajes;
	
	@Before
	public void setup() {
		
		minasDeTirith = new Atraccion("Minas de Tirith", 5, 2.5, 25, TipoDeAtraccion.PAISAJE);
		abismoDeHelm = new Atraccion("Abismo de Helm", 5, 2, 15, TipoDeAtraccion.PAISAJE);
		erebor = new Atraccion("Erebor", 12, 3, 32, TipoDeAtraccion.PAISAJE);
		
		listaDeAtraccionesA = new ArrayList<Atraccion>();
		listaDeAtraccionesA.add(minasDeTirith);
		listaDeAtraccionesA.add(erebor);
		listaDeAtraccionesA.add(abismoDeHelm);
		
		packPaisajes = new PromocionAxB("Pack Paisajes", TipoDeAtraccion.PAISAJE, listaDeAtraccionesA);
	}

	@Test
	public void alConstruirseCalculaElValorCorrectamente() {
		double valorEsperado = minasDeTirith.getCosto() + erebor.getCosto();
		assertEquals(valorEsperado, packPaisajes.getCosto(), 0);
	}

}
