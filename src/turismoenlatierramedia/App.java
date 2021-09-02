package turismoenlatierramedia;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		
		String rutaArchivoUsuarios = "archivos/usuarios.in";
		ConstructorDeUsuario constructorUsuario;
		ArrayList<Usuario> usuarios;
		
		String rutaArchivoAtracciones = "archivos/atracciones";
		ConstructorDeAtraccion constructorAtraccion;
		ArrayList<Atraccion> atracciones;
		
		
		// leer usuarios y llenar la lista
		try {			
			constructorUsuario = new ConstructorDeUsuario(rutaArchivoUsuarios);
			usuarios =  constructorUsuario.crearListaUsuarios();
			System.out.println("Se cargaron satisfacoriamente "+ usuarios.size() + " usuarios a la lista de usuarios.");
		} catch (FileNotFoundException e) {
			System.err.println("No se encontró el archivo de usuarios al momento de crearlos.");
		}

		// leer atracciones y llenar la lista
		try {			
			constructorAtraccion = new ConstructorDeAtraccion(rutaArchivoAtracciones);
			atracciones = constructorAtraccion.crearListaAtracciones();
		} catch (FileNotFoundException e) {
			System.err.println("No se encontró el archivo de atracciones al momento de crearlas.");
		}
		
		
		

		// leer promos

		// por cada usuario
		// sugerir promos
		// hay cupo? monedas? tiempo?

//		mostrar resume itinerario
		// crear archivo salida

	}

}
