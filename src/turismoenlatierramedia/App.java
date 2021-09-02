package turismoenlatierramedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		// leer usuarios y llenar la lista
		String pathToFile = "archivos/usuarios.in";
		try {
			File myObj = new File(pathToFile);
			Scanner myReader = new Scanner(myObj);
			myReader.nextLine(); // saltar la primera
			myReader.nextLine(); // y segunda linea
			while (myReader.hasNextLine()) {
				String[] u = myReader.nextLine().split(",");

				usuarios.add(new Usuario(u[0], Double.parseDouble(u[1]), Double.parseDouble(u[2]),
						TipoDeAtraccion.valueOf(u[3])));
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		// funciona?
		for (Usuario usuario : usuarios) {
			System.out.println(usuario.getNombre());
		}

		// leer promos

		// por cada usuario
		// sugerir promos
		// hay cupo? monedas? tiempo?

//		mostrar resume itinerario
		// crear archivo salida

	}

}
