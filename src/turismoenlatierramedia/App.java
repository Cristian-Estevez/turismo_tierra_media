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
		ConstructorDeUsuario constructorUsuario = null;
		ArrayList<Usuario> usuarios = null;
		
		String rutaArchivoAtracciones = "archivos/atracciones.in";
		ConstructorDeAtraccion constructorAtraccion = null;
		ArrayList<Atraccion> atracciones = null;
		
		String rutaArchivoPromociones = "archivos/promociones.in";
		ConstructorDePromociones constructorPromocion = null;
		ArrayList<Promocion> promociones = null;
		
		ArrayList<Producto> productos = null;
		
		
		
		
		// los try y catch deben ir en los constructores
		// leer usuarios y llenar la lista
				
		try {
			constructorUsuario = new ConstructorDeUsuario(rutaArchivoUsuarios);
		} catch (FileNotFoundException e2) {
			System.err.println("La ruta al [" + rutaArchivoAtracciones + "] no es válida."
					+ " No se pueden cargar los Usuarios al sistema. Por favor corrijala y reinicie la aplicación.");
			System.exit(1);
		}
		usuarios = constructorUsuario.crearListaUsuarios();
		System.out.println("Se cargaron satisfacoriamente "+ usuarios.size() + " usuarios a la lista de usuarios.");
		
		// leer atracciones y llenar la lista
		try {
			constructorAtraccion = new ConstructorDeAtraccion(rutaArchivoAtracciones);
		} catch (FileNotFoundException e1) {
			System.err.println("La ruta al [" + rutaArchivoAtracciones + "] no es válida. No se pueden cargar las atraccioens al sistema."
					+ " Por favor corrijala y reinicie la aplicación.");
			System.exit(1);
		}
		atracciones = constructorAtraccion.crearListaAtracciones();
		System.out.println("Se cargaron satisfacoriamente "+ atracciones.size() + " atracciones a la lista de atracciones.");
		
		

		// leer promos
		try {
			constructorPromocion = new ConstructorDePromociones(rutaArchivoPromociones, atracciones);
			promociones = constructorPromocion.crearListaPromociones();
			System.out.println("Se cargaron satisfacoriamente "+ promociones.size() + " promociones a la lista de promociones.");
		} catch (ConstructorDePromocionException e) {
			System.err.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("No se encontró el archivo de promociones al momento de crearlas.");
		}
		
		// CREAR ARRAY productos (ya está declarado arriba, debe contener todas las promos y las atracciones por separado
		
		// productos.addAll(lista a mergear);
		// loopear por cada usuario
		
		/**
		 * pregunto preferencia al user, 
		 * ordeno el array productos
		 */
		
		
		// sugerir promos
		// hay cupo? monedas? tiempo?

//		mostrar resume itinerario
		// crear archivo salida

	}

}
