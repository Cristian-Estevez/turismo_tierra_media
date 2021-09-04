package turismoenlatierramedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConstructorDeAtraccion {

	Scanner miLector;
	ArrayList<Atraccion> atracciones;
	String rutaRecibida;
	
	public ConstructorDeAtraccion(String nombreArchivo) throws FileNotFoundException {
		miLector = new Scanner(new File(nombreArchivo));
		this.rutaRecibida = nombreArchivo;
	}

	/**
	 * @pre debe instanciarse el objeto satisfactoriamente con el archivo de input
	 * @return ArrayList<Usuario>
	 */
	public ArrayList<Atraccion> crearListaAtracciones() {
		miLector.nextLine(); // Descarta primer línea
		atracciones = new ArrayList<Atraccion>();
		while (miLector.hasNextLine()) {
			String[] datos = miLector.nextLine().split(",");
			try {
			atracciones.add(crearAtraccion(datos));
			} catch (AtraccionException e) {
				System.err.println(e.getMessage());
			}
		}
		miLector.close();
		return atracciones;
	}

	/**
	 * Se encarga de las validaciones a la hora de crear una atracción
	 * @param datos
	 * @return Atraccion
	 * @throws AtraccionException
	 */
	private Atraccion crearAtraccion(String[] datos) throws AtraccionException {
		String nombre = datos[0];
		double costo = 0;
		double duracionHs = 0;
		int cupo = 0;
		TipoDeAtraccion tipo = null;
		try {
			costo = Double.parseDouble(datos[1]);
			duracionHs = Double.parseDouble(datos[2]);
			cupo = Integer.parseInt(datos[3]);
			tipo = TipoDeAtraccion.valueOf(datos[4].toUpperCase());
			
		} catch (NumberFormatException e) {
			throw new AtraccionException("Uno de los parametros para crear la Atracción [" + datos[0] + "] es erroneo en el archivo [" + this.rutaRecibida +"]");
		} catch (IllegalArgumentException e) {
			throw new AtraccionException("El argumento de [Tipo de atracción] en la Atracción [" + datos[0] + "] es erroneo en el archivo [" + this.rutaRecibida +"]");
		}
		Atraccion atraccion = new Atraccion(nombre, costo, duracionHs, cupo, tipo);

		return atraccion;
	}
}
