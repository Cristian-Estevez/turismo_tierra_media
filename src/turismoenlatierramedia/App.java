package turismoenlatierramedia;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		
		ConstructorDeUsuario constructorUsuario;
		ArrayList<Usuario> usuarios, atracciones;
		
		
		// leer usuarios y llenar la lista
		try {
			constructorUsuario = new ConstructorDeUsuario("archivos/usuarios.in");
			usuarios =  constructorUsuario.crearListaUsuarios();
			System.out.println("Se cargaron satisfacoriamente "+ usuarios.size() + " usuarios a la lista de usuarios.");
		} catch (FileNotFoundException e) {
			System.err.println("No se encuentra el archivo en disco para crear usuarios.");
		}

		
		// leer atracciones y llenar la lista
		

		// leer promos

		// por cada usuario
		// sugerir promos
		// hay cupo? monedas? tiempo?

//		mostrar resume itinerario
		// crear archivo salida

	}

}
