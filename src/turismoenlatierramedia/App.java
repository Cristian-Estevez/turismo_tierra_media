package turismoenlatierramedia;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Bienvenido a la agencia de turismo de tierra Media");
		System.out.println("Presione la tecla 'Enter' Para comenzar:");
		
//		scan.next();		
		
		String rutaArchivoUsuarios = "archivos/usuarios.in";
		ConstructorDeUsuario constructorUsuario;
		ArrayList<Usuario> usuarios;
		
		String rutaArchivoAtracciones = "archivos/atracciones.in";
		ConstructorDeAtraccion constructorAtraccion;
		ArrayList<Atraccion> atracciones;
		
		ArrayList<Producto> productos;
		
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
			System.out.println("Se cargaron satisfacoriamente "+ atracciones.size() + " atracciones a la lista de atracciones.");
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
