package turismoenlatierramedia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import DAO.AtraccionDAO;
import DAO.DAOFactory;
import DAO.PromocionDAO;
import DAO.UsuarioDAO;
import interaccionbbdd.MiConector;

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

	public void correrPrograma() {
		imprimirBienvenida();

		UsuarioDAO miUserDAO = (UsuarioDAO) DAOFactory.getDAO("Usuario");
		ArrayList<Usuario> usuarios = miUserDAO.getAll();
		
		AtraccionDAO miAtraccionDAO = (AtraccionDAO) DAOFactory.getDAO("Atraccion");
		ArrayList<Atraccion> atracciones = miAtraccionDAO.getAll();
		
		PromocionDAO miPromocionDAO = (PromocionDAO) DAOFactory.getDAO("Promocion");
		ArrayList<Promocion> promociones = miPromocionDAO.getAll(atracciones);
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		productos.addAll(promociones);
		productos.addAll(atracciones);
		
		miUserDAO.cargarItinerarios(usuarios, atracciones, promociones);
		
		new Ofertador().ofertar(usuarios, productos);
		
		miUserDAO.persistirUsuario(usuarios);
		
		miAtraccionDAO.persistirAtraccion(atracciones);
		
		try {
			MiConector.getConnection().close();
		} catch (SQLException e) {
			System.err.println("No se pudo cerrar la conección con la base de datos");
		}
	}

}
