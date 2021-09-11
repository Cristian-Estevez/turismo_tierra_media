package turismoenlatierramedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConstructorDeUsuario {

	private Scanner miLector;
	private ArrayList<Usuario> usuarios;
	private String rutaArchivo;

	public ConstructorDeUsuario(String nombreArchivo) throws FileNotFoundException {
		miLector = new Scanner(new File(nombreArchivo));
		this.rutaArchivo = nombreArchivo;
	}

	
	/**
	 * Crea lista de usuarios a partir del archivo this.rutaArchivo
	 * @return ArrayList<Usuario>
	 */
	public ArrayList<Usuario> crearListaUsuarios(){
		miLector.nextLine(); // Descarta primer línea
		usuarios = new ArrayList<Usuario>();
		while(miLector.hasNextLine()){
			String[] datos = miLector.nextLine().split(",");	
			try {
				usuarios.add(crearUsuario(datos));
			} catch (UsuarioException e) {
				System.err.println(e.getMessage());
			}
		}
		miLector.close();
		return usuarios;
	}
	
	/**
	 * Crea el usuario y se encarga de las validaciones al moemento de crearlos
	 * @param datos
	 * @return Usuario
	 * @throws UsuarioException
	 */
	private Usuario crearUsuario(String[] datos) throws UsuarioException {
		String nombre = datos[0];
		double monedasDeOro = 0;
		double tiempo = 0;
		TipoDeAtraccion tipo = null;
		try {
			monedasDeOro = Double.parseDouble(datos[1]);
			tiempo = Double.parseDouble(datos[2]);
			tipo = TipoDeAtraccion.valueOf(datos[3].toUpperCase());
		} catch (NumberFormatException e) {
			throw new UsuarioException("Los parámetros para crear al Usuario "
					+ "[" + datos[0] + "] son erroneos, en el archivo [" + this.rutaArchivo + "]");
		} catch (IllegalArgumentException e) {
			throw new UsuarioException("El parámetro para [Tipo de Atracción Favorita] del Usuario [" + datos[0] + "] es erroneo, en el archivo [" + this.rutaArchivo + "]");
		}
		Usuario usuario = new Usuario(nombre, monedasDeOro, tiempo, tipo);		
		return usuario;
	}
	
}
