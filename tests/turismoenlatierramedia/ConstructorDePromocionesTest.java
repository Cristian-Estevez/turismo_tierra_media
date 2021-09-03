package turismoenlatierramedia;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ConstructorDePromocionesTest {

	ConstructorDePromociones cons1;
	String rutaArchivoAtracciones = "archivos/atracciones.in";
	String rutaArchivoPromociones = "archivos/promociones.in";
	ConstructorDeAtraccion constructorAtraccion;
	ArrayList<Atraccion> atracciones;
	ArrayList<Promocion> promociones;
	
	@Before
	public void setup() throws FileNotFoundException {
		atracciones = new ArrayList<Atraccion>();
		try {			
			constructorAtraccion = new ConstructorDeAtraccion(rutaArchivoAtracciones);
			atracciones = constructorAtraccion.crearListaAtracciones();
			System.out.println("Se cargaron satisfacoriamente "+ atracciones.size() + " atracciones a la lista de atracciones.");
		} catch (FileNotFoundException e) {
			System.err.println("No se encontró el archivo de atracciones al momento de crearlas.");
		}
		
		cons1 = new ConstructorDePromociones(rutaArchivoPromociones, atracciones);
		promociones = new ArrayList<Promocion>();
	}
	
	@Test
	public void construccionDePromosAxBDesdeArchivo() throws ConstructorDePromocionException {
		promociones = cons1.crearListaPromociones();
		System.out.println(promociones);
	}

}
