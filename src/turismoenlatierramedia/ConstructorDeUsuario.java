package turismoenlatierramedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConstructorDeUsuario {

	Scanner miLector;
	ArrayList<Usuario> usuarios;

	public ConstructorDeUsuario(String nombreArchivo) throws FileNotFoundException {
		miLector = new Scanner(new File(nombreArchivo));
	}

	/**
	 * @pre debe instanciarse el objeto satisfactoriamente con el archivo de input
	 * @return ArrayList<Usuario>
	 */
	public ArrayList<Usuario> crearListaUsuarios(){
		miLector.nextLine(); // Descarta primer línea
		usuarios = new ArrayList<Usuario>();
		while(miLector.hasNextLine()){
			String[] u = miLector.nextLine().split(",");	
			usuarios.add(new Usuario(u[0], Double.parseDouble(u[1]), Double.parseDouble(u[2]), TipoDeAtraccion.valueOf(u[3])));
		}
		miLector.close();
		return usuarios;
	}
	

}
