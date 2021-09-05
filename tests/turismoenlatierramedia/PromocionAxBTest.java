package turismoenlatierramedia;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PromocionAxBTest {

	Atraccion 	minasDeTirith, abismoDeHelm, erebor, laComarca, lothlorien, delicatessen, cataratasDeChocolate;

	List<Atraccion> listaDeAtraccionesA, listaDeAtraccionesB;
	PromocionAxB packPaisajes, packDegustacion;
	
	@Before
	public void setup() {
		
		minasDeTirith = new Atraccion("Minas de Tirith", 5, 2.5, 25, TipoDeAtraccion.PAISAJE);
		abismoDeHelm = new Atraccion("Abismo de Helm", 5, 2, 15, TipoDeAtraccion.PAISAJE);
		erebor = new Atraccion("Erebor", 12, 3, 32, TipoDeAtraccion.PAISAJE);
		
		lothlorien = new Atraccion("Lothlórien", 35, 1, 30, TipoDeAtraccion.DEGUSTACION);
		laComarca = new Atraccion("La Comarca", 3, 6.5, 150, TipoDeAtraccion.DEGUSTACION);
		delicatessen = new Atraccion("Una con poco cupo", 3, 1, 2, TipoDeAtraccion.DEGUSTACION);
		cataratasDeChocolate = new Atraccion("Cataratas de Chocolate", 13, 3, 10, TipoDeAtraccion.DEGUSTACION);

		
		listaDeAtraccionesA = new ArrayList<Atraccion>();
		listaDeAtraccionesA.add(minasDeTirith);
		listaDeAtraccionesA.add(erebor);
		listaDeAtraccionesA.add(abismoDeHelm);
		
		listaDeAtraccionesB = new ArrayList<Atraccion>();
		listaDeAtraccionesB.add(lothlorien);
		listaDeAtraccionesB.add(laComarca);
		listaDeAtraccionesB.add(delicatessen);
		listaDeAtraccionesB.add(cataratasDeChocolate);
		
		packDegustacion = new PromocionAxB("Pack Degustacion", TipoDeAtraccion.DEGUSTACION, listaDeAtraccionesB);
		
		packPaisajes = new PromocionAxB("Pack Paisajes", TipoDeAtraccion.PAISAJE, listaDeAtraccionesA);
	}

	@Test
	public void alConstruirseCalculaElValorCorrectamente() {
		double valorEsperado = minasDeTirith.getCosto() + erebor.getCosto();
		assertEquals(valorEsperado, packPaisajes.getCosto(), 0);
	}
	
	@Test 
	public void alConstruirseCalculaElValorCorrectamentePruebaDos() {
		double valorSinDescuentoAxB = 54;
		double costoDeLaUltimaAtraccion = 13;
		assertEquals((valorSinDescuentoAxB - costoDeLaUltimaAtraccion), packDegustacion.getCosto(), 0);
	}
	

}
