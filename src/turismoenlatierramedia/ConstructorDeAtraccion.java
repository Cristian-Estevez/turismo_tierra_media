package turismoenlatierramedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConstructorDeAtraccion {

	/**
	 * @pre debe instanciarse el objeto satisfactoriamente con el archivo de input
	 * @return ArrayList<Usuario>
	 * @throws FileNotFoundException 
	 */
	public ArrayList<Atraccion> crearListaAtracciones(String nombreArchivo) throws FileNotFoundException {
		Scanner miLector = new Scanner(new File(nombreArchivo));
		miLector.nextLine(); // Descarta primer línea
		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
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
		int atraccionId = 0;
		TipoDeAtraccion tipo = null;
		try {
			costo = Double.parseDouble(datos[1]);
			duracionHs = Double.parseDouble(datos[2]);
			cupo = Integer.parseInt(datos[3]);
			tipo = TipoDeAtraccion.valueOf(datos[4].toUpperCase());
			
		} catch (NumberFormatException e) {
			throw new AtraccionException("Uno de los parametros para crear la Atracción [" + datos[0] + "] es erroneo en el archivo.");
		} catch (IllegalArgumentException e) {
			throw new AtraccionException("El argumento de [Tipo de atracción] en la Atracción [" + datos[0] + "] es erroneo en el archivo.");
		}
		Atraccion atraccion = new Atraccion(atraccionId, nombre, costo, duracionHs, cupo, tipo);

		return atraccion;
	}
}
