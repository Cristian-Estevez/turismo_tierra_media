package turismoenlatierramedia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Bienvenido a la agencia de turismo de Tierra Media");
		System.out.println("Presione la tecla 'Enter' para comenzar:");

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

		ArrayList<Producto> productos = new ArrayList<Producto>();

		
		// leer usuarios y llenar la lista
		try {
			constructorUsuario = new ConstructorDeUsuario(rutaArchivoUsuarios);
		} catch (FileNotFoundException e2) {
			System.err.println("La ruta al [" + rutaArchivoAtracciones + "] no es válida."
					+ " No se pueden cargar los Usuarios al sistema. Por favor corríjala y reinicie la aplicación.");
			System.exit(1);
		}
		usuarios = constructorUsuario.crearListaUsuarios();
		System.out.println("Se cargaron satisfactoriamente " + usuarios.size() + " usuarios a la lista de usuarios.");

		// leer atracciones y llenar la lista
		try {
			constructorAtraccion = new ConstructorDeAtraccion(rutaArchivoAtracciones);
		} catch (FileNotFoundException e1) {
			System.err.println("La ruta al [" + rutaArchivoAtracciones
					+ "] no es válida. No se pueden cargar las atraccioens al sistema."
					+ " Por favor corrijala y reinicie la aplicación.");
			System.exit(1);
		}
		atracciones = constructorAtraccion.crearListaAtracciones();
		System.out.println(
				"Se cargaron satisfactoriamente " + atracciones.size() + " atracciones a la lista de atracciones.");

		// leer promos

		try {
			constructorPromocion = new ConstructorDePromociones(rutaArchivoPromociones, atracciones);
		} catch (FileNotFoundException e) {
			System.err.println("No se encontró el archivo de promociones en la ruta [" + rutaArchivoPromociones + "] al momento de crearlas.");
		}
		try {
			promociones = constructorPromocion.crearListaPromociones();
			System.out.println(
					"Se cargaron satisfactoriamente " + promociones.size() + " promociones a la lista de promociones.");
		} catch (NullPointerException | IOException e) {
			System.err.println("Algo sucedió al intentar leer el archivo para la creacion de promociones."
					+ "\nPuede corregir el inconveniente y reiniciar la aplicación."
					+ "\nO si lo desea, puede continuar la ejecución del programa, pero las promociones no estarán disponibles."
					);
			System.exit(1);
		}
		
		// Se agregan todos los productos en una misma lista
		productos.addAll(promociones);
		productos.addAll(atracciones);
		
//		System.out.println("\n\n ##############################################");
//		System.out.println("Sin ordenar: \n" + productos);
		
		// loopear por cada usuario
		
//		}
//		System.out.println("\n\n ##############################################");
//		System.out.println("Ordenados por tipo: \n" + productos);

		// sugerir promos
		// hay cupo? monedas? tiempo?

//		mostrar resume itinerario
		// crear archivo salida

	}

}
