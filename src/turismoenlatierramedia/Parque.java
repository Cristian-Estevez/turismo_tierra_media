package turismoenlatierramedia;

//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import DAO.AtraccionDAO;
import DAO.DAOFactory.AtraccionDAOFactory;
import DAO.DAOFactory.PromocionDAOFactory;
import DAO.DAOFactory.UsuarioDAOFactory;
import DAO.PromocionDAO;
import DAO.UsuarioDAO;

public class Parque {

	private void imprimirBienvenida() {
		System.out.println("\n	  --Bienvenidx a la agencia de turismo de Tierra Media--\n");
		System.out.println("                    . .:.:.:.:. .:\\     /:. .:.:.:.:. ,\n"
				+ "               .-._  `..:.:. . .:.:`- -':.:. . .:.:.,'  _.-.\n"
				+ "              .:.:.`-._`-._..-''_...---..._``-.._.-'_.-'.:.:.\n"
				+ "           .:.:. . .:_.`' _..-''._________,``-.._ `.._:. . .:.:.\n"
				+ "        .:.:. . . ,-'_.-''      ||_-(O)-_||      ``-._`-. . . .:.:.\n"
				+ "       .:. . . .,'_.'           '---------'           `._`.. . . .:.\n"
				+ "     :.:. . . ,','               _________               `.`. . . .:.:\n"
				+ "    `.:.:. .,','            _.-''_________``-._            `._.     _.'\n"
				+ "  -._  `._./ /            ,'_.-'' ,       ``-._`.          ,' '`:..'  _.-\n"
				+ " .:.:`-.._' /           ,','                   `.`.       /'  '  \\\\.-':.:.\n"
				+ " :.:. . ./ /          ,','               ,       `.`.    / '  '  '\\\\. .:.:\n"
				+ ":.:. . ./ /          / /    ,                      \\ \\  :  '  '  ' \\\\. .:.:\n"
				+ ".:. . ./ /          / /            ,          ,     \\ \\ :  '  '  ' '::. .:.\n"
				+ ":. . .: :    o     / /                               \\ ;'  '  '  ' ':: . .:\n"
				+ ".:. . | |   /_\\   : :     ,                      ,    : '  '  '  ' ' :: .:.\n"
				+ ":. . .| |  ((<))  | |,          ,       ,             |\\'__',-._.' ' ||. .:\n"
				+ ".:.:. | |   `-'   | |---....____                      | ,---\\/--/  ' ||:.:.\n"
				+ "------| |         : :    ,.     ```--..._   ,         |''  '  '  ' ' ||----\n"
				+ "_...--. |  ,       \\ \\             ,.    `-._     ,  /: '  '  '  ' ' ;;..._\n"
				+ ":.:. .| | -O-       \\ \\    ,.                `._    / /:'  '  '  ' ':: .:.:\n"
				+ ".:. . | |_(`__       \\ \\                        `. / / :'  '  '  ' ';;. .:.\n"
				+ ":. . .<' (_)  `>      `.`.          ,.    ,.     ,','   \\  '  '  ' ;;. . .:\n"
				+ ".:. . |):-.--'(         `.`-._  ,.           _,-','      \\ '  '  '//| . .:.\n"
				+ ":. . .;)()(__)(___________`-._`-.._______..-'_.-'_________\\'  '  //_:. . .:\n"
				+ ".:.:,' \\/\\/--\\/--------------------------------------------`._',;'`. `.:.:.\n"
				+ ":.,' ,' ,'  ,'  /   /   /   ,-------------------.   \\   \\   \\  `. `.`. `..:\n"
				+ ",' ,'  '   /   /   /   /   //                   \\\\   \\   \\   \\   \\  ` `.");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("\n\n                       Presiona 'Enter' para comenzar");
		scan.nextLine();
	}

//	private ArrayList<Usuario> inicializarUsuarios(String rutaArchivoUsuarios) {
//		 try {
//			return new ConstructorDeUsuario().crearListaUsuarios(rutaArchivoUsuarios);
//		} catch (FileNotFoundException e) {
//			System.err.println("No se encontró archivo para crear los Usuarios del parque. \nEl programa se cerrará.");
//			System.exit(-1);
//		}
//		return null;
//	}
//	
//	private ArrayList<Atraccion> inicializarAtracciones(String rutaArchivoAtracciones) {		
//		try {
//			return new ConstructorDeAtraccion().crearListaAtracciones(rutaArchivoAtracciones);
//		} catch (FileNotFoundException e) {
//			System.err.println("No se encontró el archivo para crear las atracciones del parque. \nSe cerrará el programa.");
//			System.exit(-1);
//		}
//		return null;
//	}

	private ArrayList<Promocion> inicializarPromociones(String rutaArchivoPromociones,
			ArrayList<Atraccion> atracciones) {
		try {
			return new ConstructorDePromociones().crearListaPromociones(rutaArchivoPromociones, atracciones);
		} catch (NullPointerException | IOException e) {
			System.err.println("Algo sucedió al intentar leer el archivo para la creacion de promociones."
					+ "\nPuede corregir el inconveniente y volver iniciar el programa."
					+ "\nO si lo desea, puede continuar la ejecución del programa, pero las promociones no estarán disponibles.");
		}
		return null;
	}

	public void correrPrograma() {
		imprimirBienvenida();

		UsuarioDAO miUserDAO = UsuarioDAOFactory.getUsuarioDAO("Usuario");
		ArrayList<Usuario> usuarios = miUserDAO.getAll();
		AtraccionDAO miAtraccionDAO = AtraccionDAOFactory.getAtraccionDAO("Atraccion"); // AtraccionDAOFactory.getAtraccionDAO("Atraccion")
		ArrayList<Atraccion> atracciones = miAtraccionDAO.getAll();
		// ArrayList<Usuario> usuarios =
		// this.inicializarUsuarios("archivos/usuarios.in");
		// ArrayList<Atraccion> atracciones = this.inicializarAtracciones("archivos/atracciones.in");
		PromocionDAO miPromocionDAO = PromocionDAOFactory.getPromocionDAO("Promocion");
		ArrayList<Promocion> promociones = miPromocionDAO.getAll(atracciones);
		
//		ArrayList<Promocion> promociones = this.inicializarPromociones("archivos/promociones.in", atracciones);
		ArrayList<Producto> productos = new ArrayList<Producto>();
		productos.addAll(promociones);
		productos.addAll(atracciones);
		new Ofertador().ofertar(usuarios, productos);
	}

}
