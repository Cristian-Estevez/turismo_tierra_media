package turismoenlatierramedia;

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
			
	private static boolean puedeComprar(Usuario user, Producto prod) {
		return user.getMonedasDeOro() >= prod.getCosto() && user.getTiempoDisponible() >= prod.getTiempoDeDuracion()
				&& prod.getLugaresDisponibles() > 0 && !user.yaCompro(prod);
	}
	
}

