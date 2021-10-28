package turismoenlatierramedia;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PromocionPorcentualTest {

	/*Usuario eowyn, gandalf, sam, galadriel, userAdineradoYConMuchoTiempo; */

	Atraccion minasDeTirith, abismoDeHelm, laComarca, lothlorien, delicatessen, cataratasDeChocolate;

	List<Atraccion> listaDeAtraccionesA, listaDeAtraccionesB;
	PromocionPorcentual promoPaisajes, promoDegustacion;

	@Before
	public void setup() {
		/*eowyn = new Usuario("Eowyn", 10, 8, TipoDeAtraccion.AVENTURA);
		gandalf = new Usuario("Gandalf", 100, 5, TipoDeAtraccion.PAISAJE);
		sam = new Usuario("Sam", 36, 8, TipoDeAtraccion.DEGUSTACION);
		galadriel = new Usuario("Galadriel", 120, 4, TipoDeAtraccion.PAISAJE);
		userAdineradoYConMuchoTiempo = new Usuario("Adinerado y con tiempo", 500, 24, TipoDeAtraccion.AVENTURA);
*/
		minasDeTirith = new Atraccion(2, "Minas de Tirith", 5, 2.5, 25, TipoDeAtraccion.PAISAJE);
		abismoDeHelm = new Atraccion(5, "Abismo de Helm", 5, 2, 15, TipoDeAtraccion.PAISAJE);
		lothlorien = new Atraccion(6, "Lothlórien", 35, 1, 30, TipoDeAtraccion.DEGUSTACION);
		laComarca = new Atraccion(3, "La Comarca", 3, 6.5, 150, TipoDeAtraccion.DEGUSTACION);
		delicatessen = new Atraccion(0, "Una con poco cupo", 3, 1, 2, TipoDeAtraccion.DEGUSTACION);
		cataratasDeChocolate = new Atraccion(0, "Cataratas de Chocolate", 13, 3, 10, TipoDeAtraccion.DEGUSTACION);



		listaDeAtraccionesA = new ArrayList<Atraccion>();
		listaDeAtraccionesA.add(abismoDeHelm);
		listaDeAtraccionesA.add(minasDeTirith);
		
		listaDeAtraccionesB = new ArrayList<Atraccion>();
		listaDeAtraccionesB.add(lothlorien);
		listaDeAtraccionesB.add(laComarca);
		listaDeAtraccionesB.add(delicatessen);
		listaDeAtraccionesB.add(cataratasDeChocolate);
		
//		tipo Porcentual: Minas Tirith + Abismo de Helm 20% off = $ 8
		promoPaisajes = new PromocionPorcentual(1,"Promo Paisajes", TipoDeAtraccion.PAISAJE, 20,
				listaDeAtraccionesA);
		
		promoDegustacion = new PromocionPorcentual(2,"Promo Degustacion", TipoDeAtraccion.DEGUSTACION, 50, listaDeAtraccionesB);
	}

	@Test
	public void seAsignaElCostoConDescuentoCorrectamente() {
		double costoEsperado = 8;
		assertEquals(costoEsperado, promoPaisajes.getCosto(), 0);
	}
	
	@Test
	public void seAsignaElCostoConDescuentoCorrectamentePruebaDos() {
		double porcentajeAplicado = 0.5;
		double costoEsperado = (lothlorien.getCosto() + laComarca.getCosto() + delicatessen.getCosto() +
				cataratasDeChocolate.getCosto()) * porcentajeAplicado;
		assertEquals(costoEsperado, promoDegustacion.getCosto(), 0);
		
	}

}
