package turismoenlatierramedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConstructorDeUsuario {
	
	/**
	 * Crea lista de usuarios a partir del archivo this.rutaArchivo
	 * @return ArrayList<Usuario>
	 * @throws FileNotFoundException 
	 */
	public ArrayList<Usuario> crearListaUsuarios(String nombreArchivo) throws FileNotFoundException{
		Scanner miLector = new Scanner(new File(nombreArchivo));
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		miLector.nextLine(); // Descarta primer línea		
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
		int usuarioId = 0;
		TipoDeAtraccion tipo = null;		
		try {
			monedasDeOro = Double.parseDouble(datos[1]);
			esValorPositivo(monedasDeOro);
			tiempo = Double.parseDouble(datos[2]);
			esValorPositivo(tiempo);
			tipo = TipoDeAtraccion.valueOf(datos[3].toUpperCase());
		} catch (UsuarioException e){
			throw new UsuarioException("La cantidad de monedas de oro o tiempo disponible del usuario [" + nombre + "] deben ser mayores a 0.");
		} catch (NumberFormatException e) {
			throw new UsuarioException("Los parámetros para crear al Usuario "
					+ "[" + datos[0] + "] son erroneos.");
		} catch (IllegalArgumentException e) {
			throw new UsuarioException("El parámetro para [Tipo de Atracción Favorita] del Usuario [" + datos[0] + "] es erroneo.");
		}
	
		Usuario usuario = new Usuario(usuarioId, nombre, monedasDeOro, tiempo, tipo);		
		return usuario;
	}
	
	private void esValorPositivo(double num) throws UsuarioException {
		if (num <= 0) {
			throw new UsuarioException("El número pasado por parámetro es igual o menor a [0]");
		}
	}
	
}
