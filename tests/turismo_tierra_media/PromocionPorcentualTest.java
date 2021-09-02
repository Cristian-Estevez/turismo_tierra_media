package turismo_tierra_media;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import turismoenlatierramedia.Atraccion;
import turismoenlatierramedia.PromocionPorcentual;
import turismoenlatierramedia.TipoDeAtraccion;
import turismoenlatierramedia.Usuario;

public class PromocionPorcentualTest {

	Usuario eowyn, gandalf, sam, galadriel, userAdineradoYConMuchoTiempo;

	Atraccion minasDeTirith, abismoDeHelm;

	List<Atraccion> listaDeAtraccionesA;
	PromocionPorcentual promoPaisajes;

	@Before
	public void setup() {
		eowyn = new Usuario("Eowyn", 10, 8, TipoDeAtraccion.AVENTURA);
		gandalf = new Usuario("Gandalf", 100, 5, TipoDeAtraccion.PAISAJE);
		sam = new Usuario("Sam", 36, 8, TipoDeAtraccion.DEGUSTACION);
		galadriel = new Usuario("Galadriel", 120, 4, TipoDeAtraccion.PAISAJE);
		userAdineradoYConMuchoTiempo = new Usuario("Adinerado y con tiempo", 500, 24, TipoDeAtraccion.AVENTURA);

		minasDeTirith = new Atraccion("Minas de Tirith", 5, 2.5, 25, TipoDeAtraccion.PAISAJE);
		abismoDeHelm = new Atraccion("Abismo de Helm", 5, 2, 15, TipoDeAtraccion.PAISAJE);


		listaDeAtraccionesA = new ArrayList<Atraccion>();
		listaDeAtraccionesA.add(abismoDeHelm);
		listaDeAtraccionesA.add(minasDeTirith);

//		tipo Porcentual: Minas Tirith + Abismo de Helm 20% off = $ 8
		promoPaisajes = new PromocionPorcentual("Pack Degustación", TipoDeAtraccion.DEGUSTACION, 20,
				listaDeAtraccionesA);
	}

	@Test
	public void seAsignaElCostoConDescuentoCorrectamente() {
		double costoEsperado = 8;
		assertEquals(costoEsperado, promoPaisajes.getCosto(), 0);
	}

}
