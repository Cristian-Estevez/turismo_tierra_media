package turismoenlatierramedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConstructorDeAtraccion {

	Scanner miLector;
	ArrayList<Atraccion> atracciones;

	public ConstructorDeAtraccion(String nombreArchivo) throws FileNotFoundException {
		miLector = new Scanner(new File(nombreArchivo));
	}

	/**
	 * @pre debe instanciarse el objeto satisfactoriamente con el archivo de input
	 * @return ArrayList<Usuario>
	 */
	public ArrayList<Atraccion> crearListaAtracciones(){
		miLector.nextLine(); // Descarta primer línea
		atracciones = new ArrayList<Atraccion>();
		while(miLector.hasNextLine()){
			String[] u = miLector.nextLine().split(",");			
			atracciones.add(new Atraccion(u[0], Double.parseDouble(u[1]), Double.parseDouble(u[2]), Integer.parseInt(u[3]), TipoDeAtraccion.valueOf(u[4])));
		} // CHECKEAR!!!
		miLector.close();
		return atracciones;
	}
}
