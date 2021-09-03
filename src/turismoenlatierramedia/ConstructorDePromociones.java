package turismoenlatierramedia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ConstructorDePromociones {

	ArrayList<Promocion> promociones;
	BufferedReader br;
	ArrayList<Atraccion> atracciones;

	public ConstructorDePromociones(String nombreArchivo) throws FileNotFoundException {
		br = new BufferedReader(new FileReader(nombreArchivo));
		promociones = new ArrayList<Promocion>();
	}

	/**
	 * // los tres primeros parámetros siempre son iguales
	 * 
	 * @return
	 * @throws ConstructorDePromocionException
	 */
	public ArrayList<Promocion> crearListaPromociones() throws ConstructorDePromocionException {
		String[] tmp;
		String tipoDePromocion;

		try {
			br.readLine(); // descartamos primer linea del archivo
			while (br.readLine() != null) {
				tmp = br.readLine().split(",");
				tipoDePromocion = tmp[0].toLowerCase();
				switch (tipoDePromocion) {
				case "axb": {
					int cantidadDeParametros = tmp.length;
					String[] atraccionesABuscar = new String[cantidadDeParametros - 3];
					for (int i = 3, j = 0; i < tmp.length; i++, j++) {
						atraccionesABuscar[j] += tmp[i];
					}
					atracciones = this.getObjetosAtracciones(atraccionesABuscar);
					promociones.add(new PromocionAxB(tmp[1], TipoDeAtraccion.valueOf(tmp[2]), atracciones));

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
			for (Atraccion atraccionEnParque : atracciones) {
				if (atraccion.equals(atraccionEnParque)) {
					listaDeAtracciones.add(atraccionEnParque);
				}
			}
		}
		System.err.println("Get obj attr" + listaDeAtracciones.size());
		return listaDeAtracciones;
	}

}
