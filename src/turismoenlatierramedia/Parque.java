package turismoenlatierramedia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parque {

	private ArrayList<Usuario> usuarios;	
	private ArrayList<Atraccion> atracciones;		
	private ArrayList<Promocion> promociones;
	private ArrayList<Producto> productos = new ArrayList<Producto>();
	
	
	public Parque() {
		imprimirBienvenida();
	}

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
		Scanner scan = new Scanner(System.in);
		System.out.println("\n\n                       Presiona 'Enter' para comenzar" );
		scan.nextLine();
	}
	
	private void inicializarUsuarios() {
		
		String rutaArchivoUsuarios = "archivos/usuarios.in";
		ConstructorDeUsuario constructorUsuario = null;
		
		
		try {
			constructorUsuario = new ConstructorDeUsuario(rutaArchivoUsuarios);
		} catch (FileNotFoundException e2) {
			System.err.println("La ruta al [" + rutaArchivoUsuarios + "] no es válida."
					+ " No se pueden cargar los Usuarios al sistema. Por favor corríjala y reinicie la aplicación.");
			System.exit(1);
		}
		usuarios = constructorUsuario.crearListaUsuarios();
	}
	
	private void inicializarAtracciones() {
		String rutaArchivoAtracciones = "archivos/atracciones.in";
		ConstructorDeAtraccion constructorAtraccion = null;
		
		try {
			constructorAtraccion = new ConstructorDeAtraccion(rutaArchivoAtracciones);
		} catch (FileNotFoundException e1) {
			System.err.println("La ruta al [" + rutaArchivoAtracciones
					+ "] no es válida. No se pueden cargar las atraccioens al sistema."
					+ " Por favor corrijala y reinicie la aplicación.");
			System.exit(1);
		}
		atracciones = constructorAtraccion.crearListaAtracciones();
	}
	
	private void inicializarPromociones() {
		
		String rutaArchivoPromociones = "archivos/promociones.in";
		ConstructorDePromociones constructorPromocion = null;
		
		try {
			constructorPromocion = new ConstructorDePromociones(rutaArchivoPromociones, atracciones);
		} catch (FileNotFoundException e) {
			System.err.println("No se encontró el archivo de promociones en la ruta [" + rutaArchivoPromociones
					+ "] al momento de crearlas.");
		}
		try {
			promociones = constructorPromocion.crearListaPromociones();
		} catch (NullPointerException | IOException e) {
			System.err.println("Algo sucedió al intentar leer el archivo para la creacion de promociones."
					+ "\nPuede corregir el inconveniente y reiniciar la aplicación."
					+ "\nO si lo desea, puede continuar la ejecución del programa, pero las promociones no estarán disponibles.");
			System.exit(1);
		}
	}
	
	private void listarProductos() {
		productos.addAll(promociones);
		productos.addAll(atracciones);
	}
	
	public void correrPrograma() {
		
		Ofertador ofertador;
		this.inicializarUsuarios();
		this.inicializarAtracciones();
		this.inicializarPromociones();
		this.listarProductos();
		ofertador = new Ofertador(usuarios, productos);
		ofertador.ofertar();		
	}
	
}
