package turismoenlatierramedia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ConstructorDePromocionesTest {

	ConstructorDePromociones cons1, consConArchivoMalFormateado;
	String rutaArchivoAtracciones = "archivosParaTests/atraccionesParaTests.in";
	String rutaArchivoPromociones = "archivosParaTests/promocionesParaTests.in";
	ConstructorDeAtraccion constructorAtraccion;
	ArrayList<Atraccion> atracciones;
	ArrayList<Promocion> promociones;
	Usuario eowyn, gandalf, sam, galadriel, userAdineradoYConMuchoTiempo;
	
	@Before
	public void setup() throws FileNotFoundException {		
		eowyn = new Usuario(1,"Eowyn", 10, 8, TipoDeAtraccion.AVENTURA);
		gandalf = new Usuario(2,"Gandalf", 100, 5, TipoDeAtraccion.PAISAJE);
		sam = new Usuario(3,"Sam", 36, 8, TipoDeAtraccion.DEGUSTACION);
		galadriel = new Usuario(4,"Galadriel", 120, 4, TipoDeAtraccion.PAISAJE);
		userAdineradoYConMuchoTiempo = new Usuario(0,"Adinerado y con tiempo", 500, 24, TipoDeAtraccion.AVENTURA);
		
		atracciones = new ArrayList<Atraccion>();			
		constructorAtraccion = new ConstructorDeAtraccion();
		atracciones = constructorAtraccion.crearListaAtracciones(rutaArchivoAtracciones);
		cons1 = new ConstructorDePromociones();
		promociones = new ArrayList<Promocion>();
	}
	
	@Test
	public void construccionDePromosDesdeArchivo() throws PromocionException, IOException {
		promociones = cons1.crearListaPromociones(rutaArchivoPromociones, atracciones);
		assertEquals(promociones.get(0).getAtraccionesIncluidas().get(0), atracciones.get(7));
		assertTrue(promociones.get(0).getAtraccionesIncluidas().contains(atracciones.get(3)));
	}
	
	
	@Test
	public void lugaresDisponiblesDisminuyeAlComprarPromo() throws PromocionException, UsuarioException, IOException, AtraccionException {
		promociones = cons1.crearListaPromociones(rutaArchivoPromociones, atracciones);
		int plazasDisponiblesEsperadas = promociones.get(0).getLugaresDisponibles() - 1;
		userAdineradoYConMuchoTiempo.comprarProducto(promociones.get(0));
		assertEquals(plazasDisponiblesEsperadas, promociones.get(0).getLugaresDisponibles());
	}
	
}
