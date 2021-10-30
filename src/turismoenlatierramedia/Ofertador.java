package turismoenlatierramedia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ofertador {
		
	public void ofertar(ArrayList<Usuario> usuarios, ArrayList<Producto> productos) {
		Scanner scan = new Scanner(System.in);
		String respuesta = "";
		for (Usuario user : usuarios) {
			TipoDeAtraccion atraccionFavorita = user.getTipoDeAtraccionFavorita();
			productos.sort(new ProductosPorPreferencia(atraccionFavorita));			
			saludarUsuario(user);
			for (Producto prod : productos) {
				if (puedeComprar(user, prod)) {
					do {
						if(prod.esPromocion()) {
							System.out.println("Creemos que te va a gustar esta promocion: " + prod.getNombre() + "\nQue es de tipo " + prod.getTipo() + ".");
							System.out.println("y " + prod.imprimeLoQueIncluye());
						} else {
							System.out.println("Creemos que te va a gustar esta atraccion: " + prod.getNombre() + "\nQue es de tipo " + prod.getTipo() + ".");
						}
						System.out.println("Su Id es: " + prod.getId() + ". Tiene un costo de: " + prod.getCosto() + " monedas de oro" + " y una duracion de: " + prod.getTiempoDeDuracion() + " horas");
						System.out.println("¿Te interesa?");
						System.out.println("S/N");
						respuesta = scan.nextLine().toUpperCase();
						if (respuesta.equals("S")) {
							user.comprarProducto(prod);
							try {
								escribirArchivosDeUsuarios(user, "archivosDeSalida/" + "Usuario " + user.getNombre() + "-adquisiciones"
								+ ".out");
							} catch (IOException e) {
								System.err.println("No se pudo escribir en los archivos de salida.");
							}
						} else if (respuesta.equals("N")) {
							System.out.println("Qué pena! Veamos qué más tenemos para vos...");
							continue;
						}
					} while (!respuesta.equals("S") && !respuesta.equals("N"));
				}
			}
			System.out.println(user.getNombre() + ", compraste estos productos: ");
			for (Producto prod : user.getProductosComprados()) {
				System.out.println("-" + prod.getNombre());				
			}
			System.out.print("Gracias por visitarnos. Volvé pronto\n\n");
		}
		scan.close();
	
	}

	private void saludarUsuario(Usuario user) {
		System.out.println("______________________________________________________________________________________");
		System.out.println("                                        ");
		System.out.println("Hola " + user.getNombre() + "!");
		System.out.println("Sabemos que te gustan las atracciones de " + user.getTipoDeAtraccionFavorita() + ": ");
		System.out.println("Tenemos preparadas sorpresas para vos!\n");
	}
	
	private void escribirArchivosDeUsuarios(Usuario u, String file) throws IOException {
		PrintWriter salidaUsuario = new PrintWriter(new FileWriter(file));
		salidaUsuario.println("\n" + "RESUMEN DE COMPRAS DEL USUARIO " + u.getNombre().toUpperCase() + "\n" + "\n");
		if (u.getProductosComprados() != null) {
			for (Producto prod : u.getProductosComprados())
			salidaUsuario.println("Compró " + prod.esPromocionOAtraccion() + " " + prod.getNombre() + prod.imprimeLoQueIncluye() +
			". Le costó " + prod.getCosto() + " monedas y duró " + prod.getTiempoDeDuracion() + " horas.");
		
			salidaUsuario.println("A " + u.getNombre() + " le quedan " + u.getMonedasDeOro() + " monedas");
			salidaUsuario.println("Y tiene " + u.getTiempoDisponible() + " tiempo disponible");
		} else salidaUsuario.println(u.getNombre() + " no realizó ninguna compra.");  //esta linea es inutil		
		salidaUsuario.println("¡Gracias por confiar en nuestras recomendaciones!");
		salidaUsuario.close();
	}
			
	private static boolean puedeComprar(Usuario user, Producto prod) {
		return user.getMonedasDeOro() >= prod.getCosto() && user.getTiempoDisponible() >= prod.getTiempoDeDuracion()
				&& prod.getLugaresDisponibles() > 0 && !user.yaCompro(prod);
	}
	
}

