package turismoenlatierramedia;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

	Usuario eowyn, gandalf, sam, galadriel;
	Atraccion mordor, atraccionMuyCostosa, atraccionMuyLarga;
	List<Producto> productosEsperados;  
	
	@Before
	public void setup() {
		eowyn = new Usuario("Eowyn", 10, 8, TipoDeAtraccion.AVENTURA);
		gandalf = new Usuario("Gandalf", 100, 5, TipoDeAtraccion.PAISAJE);
		sam = new Usuario("Sam", 36, 8, TipoDeAtraccion.DEGUSTACION);
		galadriel = new Usuario("Galadriel", 120, 4, TipoDeAtraccion.PAISAJE);
		
		// orden de los parametros para construir atracción:
		// (nombre, costo, tiempoDeDuracion, cupo, tipoDeAtraccion)
		mordor = new Atraccion("Mordor", 25, 3, 4, TipoDeAtraccion.AVENTURA);
		productosEsperados = new ArrayList<Producto>();
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
	
	@Test (expected = UsuarioException.class)
	public void arrojaExcepcionSiNoLeAlcanzanLasMonedas() throws UsuarioException, AtraccionException {
		atraccionMuyCostosa = new Atraccion("Atraccion Muy Costosa", 500000, 3, 6, TipoDeAtraccion.DEGUSTACION);
		gandalf.comprarProducto(atraccionMuyCostosa);
	}
	
	@Test (expected = UsuarioException.class)
	public void arrojaExcepcionSiNoLeAlcanzaElTiempo() throws UsuarioException, AtraccionException {
		atraccionMuyLarga = new Atraccion("Atraccion Muy Costosa", 1, 24, 6, TipoDeAtraccion.DEGUSTACION);
		gandalf.comprarProducto(atraccionMuyLarga);
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
}
