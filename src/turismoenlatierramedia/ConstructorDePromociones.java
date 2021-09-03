package turismoenlatierramedia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ConstructorDePromociones {

	ArrayList<Promocion> promociones;
	BufferedReader br;
	ArrayList<Atraccion> atraccionesDesdeApp;

	public ConstructorDePromociones(String nombreArchivo, ArrayList<Atraccion> atraccionesCargadasEnApp) throws FileNotFoundException {
		br = new BufferedReader(new FileReader(nombreArchivo));
		promociones = new ArrayList<Promocion>();
		atraccionesDesdeApp = atraccionesCargadasEnApp;
	}

	/**
	 * los tres primeros parámetros siempre son iguales
	 * 
	 * @return
	 * @throws ConstructorDePromocionException
	 */
	public ArrayList<Promocion> crearListaPromociones() throws ConstructorDePromocionException {
		String[] tmp;
		String tipoDePromocion;
		ArrayList<Atraccion> atraccionesParaConstruirPromo = new ArrayList<Atraccion>();
 		int cantidadDePromosACargar;
		try {
			cantidadDePromosACargar = Integer.parseInt(br.readLine()); 
			br.readLine();// descartamos primer linea del archivo
			
			for (int j = 0; j < cantidadDePromosACargar; j++) {
				tmp = br.readLine().split(",");
				tipoDePromocion = tmp[0].toLowerCase();
				switch (tipoDePromocion) {
				case "axb": {
					int cantidadDeParametros = tmp.length;
					String[] atraccionesABuscar = new String[cantidadDeParametros - 3];
					for (int i = 3, k = 0; i < tmp.length; i++, k++) {
						atraccionesABuscar[k] = tmp[i];
					}
					atraccionesParaConstruirPromo = this.getObjetosAtracciones(atraccionesABuscar);					
					PromocionAxB promoTmp = new PromocionAxB(tmp[1], TipoDeAtraccion.valueOf(tmp[2]), atraccionesParaConstruirPromo); 
					promociones.add(promoTmp);
					break;
				}
				
			}	
			}
		} catch (IOException e) {
			throw new ConstructorDePromocionException(
					"Hubo un error al leer una linea Del archivo para crear promociones.");
		}
		System.out.println("Se cargaron correctamente " + promociones.size() + " promociones.");
		return promociones;
	}

	private ArrayList<Atraccion> getObjetosAtracciones(String[] atraccionesABuscar) {
		ArrayList<Atraccion> listaDeAtracciones = new ArrayList<Atraccion>();
		for (String atraccion : atraccionesABuscar) {
			for (Atraccion atraccionEnParque : atraccionesDesdeApp) {
				if (atraccion.equals(atraccionEnParque.getNombre())) {
					listaDeAtracciones.add(atraccionEnParque);
				}
			}
		}
		return listaDeAtracciones;
	}
	
}
