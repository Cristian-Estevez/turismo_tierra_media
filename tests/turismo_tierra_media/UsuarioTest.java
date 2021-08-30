package turismo_tierra_media;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import turismoenlatierramedia.Atraccion;
import turismoenlatierramedia.Producto;
import turismoenlatierramedia.TipoDeAtraccion;
import turismoenlatierramedia.Usuario;
import turismoenlatierramedia.UsuarioException;

public class UsuarioTest {

	Usuario eowyn, gandalf, sam, galadriel;
	Producto mordor, atraccionMuyCostosa, atraccionMuyLarga;
	Producto[] productosEsperados;  
	
	@Before
	public void setup() {
		eowyn = new Usuario("Eowyn", 10, 8, TipoDeAtraccion.AVENTURA);
		gandalf = new Usuario("Gandalf", 100, 5, TipoDeAtraccion.PAISAJE);
		sam = new Usuario("Sam", 36, 8, TipoDeAtraccion.DEGUSTACION);
		galadriel = new Usuario("Galadriel", 120, 4, TipoDeAtraccion.PAISAJE);
		mordor = new Atraccion("Mordor", 25, 3, 4, TipoDeAtraccion.AVENTURA);
		productosEsperados = new Producto[10];
	}
	
//	@Test
//	public void ususarioCompraProductoYLoGuarda() throws UsuarioException {
//		gandalf.comprarProducto(mordor);
//		productosEsperados[0] = mordor;
//		assertArrayEquals(productosEsperados, gandalf.getProductosComprados());
//	}
	
	@Test
	public void descuentaMonedasDeOroCorrectamente() throws UsuarioException {
		int monedasEsperadas = 75;
		gandalf.comprarProducto(mordor);
		assertEquals(monedasEsperadas, gandalf.getMonedasDeOro(), 0);
	}
	
	@Test (expected=UsuarioException.class)
	public void arrojaExcepcionSiNoLeAlcanzanLasMonedas() throws UsuarioException {
		atraccionMuyCostosa = new Atraccion("Atraccion Muy Costosa", 500000, 3, 6, TipoDeAtraccion.DEGUSTACION);
		gandalf.comprarProducto(atraccionMuyCostosa);
	}
	
	@Test (expected=UsuarioException.class)
	public void arrojaExcepcionSiNoLeAlcanzaElTiempo() throws UsuarioException {
		atraccionMuyLarga = new Atraccion("Atraccion Muy Costosa", 1, 24, 6, TipoDeAtraccion.DEGUSTACION);
		gandalf.comprarProducto(atraccionMuyLarga);
	}

}
