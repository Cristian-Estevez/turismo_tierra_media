package turismoenlatierramedia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

	Usuario eowyn, gandalf, sam, galadriel, userAdineradoYConMuchoTiempo;
	Atraccion mordor, abismoDeHelm, moria, bosqueNegro;
	
	List<Producto> productosEsperados;  
	List<Atraccion> listaDeAtraccionesA;
	PromocionAbsoluta promoNueva;
	
	@Before
	public void setup() {
		eowyn = new Usuario(1, "Eowyn", 10, 8, TipoDeAtraccion.AVENTURA);
		gandalf = new Usuario(2, "Gandalf", 100, 5, TipoDeAtraccion.PAISAJE);
		sam = new Usuario(3, "Sam", 36, 8, TipoDeAtraccion.DEGUSTACION);
		galadriel = new Usuario(4, "Galadriel", 120, 4, TipoDeAtraccion.PAISAJE);
		userAdineradoYConMuchoTiempo = new Usuario(0,"Adinerado y con tiempo", 500, 24, TipoDeAtraccion.AVENTURA);
		
		// orden de los parametros para construir atracción:
		// (nombre, costo, tiempoDeDuracion, cupo, tipoDeAtraccion)
		mordor = new Atraccion(4, "Mordor", 25, 3, 4, TipoDeAtraccion.AVENTURA);
		moria = new Atraccion(1, "Moria", 10, 2, 6,  TipoDeAtraccion.AVENTURA);
		bosqueNegro = new Atraccion(8, "Bosque Negro", 3, 4, 12, TipoDeAtraccion.AVENTURA);
		abismoDeHelm = new Atraccion(5, "Abismo de Helm", 5, 2, 15, TipoDeAtraccion.PAISAJE);

		
		productosEsperados = new ArrayList<Producto>();
		
		listaDeAtraccionesA= new ArrayList<Atraccion>();
		listaDeAtraccionesA.add(mordor);
		listaDeAtraccionesA.add(moria);
		listaDeAtraccionesA.add(bosqueNegro);
		
		promoNueva = new PromocionAbsoluta("Nueva", TipoDeAtraccion.AVENTURA, 22, listaDeAtraccionesA);
		
	}
	
	@Test
	public void ususarioCompraProductoYLoGuarda() throws UsuarioException, AtraccionException {
		gandalf.comprarProducto(mordor);
		productosEsperados.add(mordor);
		assertEquals(productosEsperados, gandalf.getProductosComprados());
	}
	
	@Test
	public void descuentaMonedasDeOroCorrectamente() throws UsuarioException, AtraccionException {
		int monedasEsperadas = 75;
		gandalf.comprarProducto(mordor);
		assertEquals(monedasEsperadas, gandalf.getMonedasDeOro(), 0);
	}
	
	@Test
	public void devuelveAtraccionFavoritaCorrectamente() {
		TipoDeAtraccion atraccionEsperada = TipoDeAtraccion.AVENTURA;
		assertEquals(atraccionEsperada, eowyn.getTipoDeAtraccionFavorita());
	}
	
	@Test
	public void descuentaCorrectamenteElTiempoDisponibleAlComprar() throws UsuarioException, AtraccionException {
		double tiempoDesponibleEsperado = 1;
		galadriel.comprarProducto(mordor);
		assertEquals(tiempoDesponibleEsperado, galadriel.getTiempoDisponible(), 0);
	}
	
	@Test
	public void alComprarPromocionYaComproDevuelveSiContieneDeterminadaAtraccion() {
		userAdineradoYConMuchoTiempo.comprarProducto(promoNueva);
		assertTrue(userAdineradoYConMuchoTiempo.yaCompro(moria));
		assertTrue(userAdineradoYConMuchoTiempo.yaCompro(mordor));
		assertTrue(userAdineradoYConMuchoTiempo.yaCompro(bosqueNegro));
		assertFalse(userAdineradoYConMuchoTiempo.yaCompro(abismoDeHelm));
	}
	
	
}
