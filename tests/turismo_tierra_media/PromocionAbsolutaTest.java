package turismo_tierra_media;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import turismoenlatierramedia.Atraccion;
import turismoenlatierramedia.PromocionAbsoluta;
import turismoenlatierramedia.TipoDeAtraccion;
import turismoenlatierramedia.Usuario;
import turismoenlatierramedia.UsuarioException;

public class PromocionAbsolutaTest {

	Usuario eowyn, gandalf, sam, galadriel, userAdineradoYConMuchoTiempo;
	
	Atraccion moria, minasDeTirith, laComarca, mordor, 
	          abismoDeHelm, lothlorien, erebor, bosqueNegro;
	
	List<Atraccion> listaDeAtraccionesA, listaDeAtraccionesB;
	PromocionAbsoluta packDegustacion;
	
	@Before
	public void setup() {
		eowyn = new Usuario("Eowyn", 10, 8, TipoDeAtraccion.AVENTURA);
		gandalf = new Usuario("Gandalf", 100, 5, TipoDeAtraccion.PAISAJE);
		sam = new Usuario("Sam", 36, 8, TipoDeAtraccion.DEGUSTACION);
		galadriel = new Usuario("Galadriel", 120, 4, TipoDeAtraccion.PAISAJE);
		userAdineradoYConMuchoTiempo = new Usuario("Adinerado y con tiempo", 500, 24, TipoDeAtraccion.AVENTURA);
		
		laComarca = new Atraccion("La Comarca", 3, 6.5, 150, TipoDeAtraccion.DEGUSTACION);
		lothlorien = new Atraccion("Lothlórien", 35, 1, 30, TipoDeAtraccion.DEGUSTACION);
		
		listaDeAtraccionesA = new ArrayList<Atraccion>();
		listaDeAtraccionesA.add(laComarca);
		listaDeAtraccionesA.add(lothlorien);
		
		packDegustacion = new PromocionAbsoluta("Pack Degustación", TipoDeAtraccion.DEGUSTACION, 36, listaDeAtraccionesA);
	}
	
	@Test
	public void devuelveTiempoDeDuracion() {
		double tiempoEsperado = laComarca.getTiempoDeDuracion() + lothlorien.getTiempoDeDuracion();
		assertEquals(tiempoEsperado, packDegustacion.getTiempoDeDuracion(), 0);
	}
	
	@Test
	public void devuelveLugaresDisponiblesCorrectamente() {
		int lugaresEsperados = 30;
		assertEquals(lugaresEsperados, packDegustacion.getLugaresDisponibles());
	}
	
	@Test
	public void reduceCuposDisponiblesAlComprar() throws UsuarioException {
		int lugaresDespuesDeUnaCompra = packDegustacion.getLugaresDisponibles() - 1;
		userAdineradoYConMuchoTiempo.comprarProducto(packDegustacion);
		assertEquals(lugaresDespuesDeUnaCompra, packDegustacion.getLugaresDisponibles());
	}
	
	@Test
	public void lugaresDisponiblesReducenAlComprarPromoYAtraccionPorSeparado() throws UsuarioException {
		int lugaresDespuesDeDosCompras = packDegustacion.getLugaresDisponibles() - 2;
		userAdineradoYConMuchoTiempo.comprarProducto(packDegustacion);
		sam.comprarProducto(lothlorien);
		assertEquals(lugaresDespuesDeDosCompras, packDegustacion.getLugaresDisponibles());
	}

}
