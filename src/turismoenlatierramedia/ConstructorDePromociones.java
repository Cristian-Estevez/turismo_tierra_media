package turismoenlatierramedia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ConstructorDePromociones {

	private ArrayList<Promocion> promociones;
	private BufferedReader br;
	private ArrayList<Atraccion> atraccionesDesdeApp;
	private static final int CANTIDAD_MINIMA_DE_PARAMETROS = 5;
	private String rutaArchivo;

	public ConstructorDePromociones(String nombreArchivo, ArrayList<Atraccion> atraccionesCargadasEnApp)
			throws FileNotFoundException {
		br = new BufferedReader(new FileReader(nombreArchivo));
		promociones = new ArrayList<Promocion>();
		atraccionesDesdeApp = atraccionesCargadasEnApp;
		rutaArchivo = nombreArchivo;
	}

	/**
	 * los tres primeros parámetros de cada línea siempre son del mismo tipo
	 * 
	 * @return
	 * @throws IOException
	 * @throws ConstructorDePromocionException
	 */
	public ArrayList<Promocion> crearListaPromociones() throws IOException {
		String[] tmp;
		String tipoDePromocion, linea;
		br.readLine();// descartamos primer linea del archivo
		while ((linea = br.readLine()) != null) {
			tmp = linea.split(",");
			int cantidadDeParametros = tmp.length;
			if (cantidadDeParametros >= CANTIDAD_MINIMA_DE_PARAMETROS) {
				tipoDePromocion = tmp[0].toLowerCase();
				try {
					if (tipoDePromocion.equals("axb")) {
						agregaPromocionAxB(tmp, cantidadDeParametros);
					} else if (tipoDePromocion.equals("absoluta")) {
						agregaPromocionAbsoluta(tmp, cantidadDeParametros);
					} else if (tipoDePromocion.equals("porcentual")) {
						agregaPromocionPorcentual(tmp, cantidadDeParametros, 4);

					} else System.err.println("El primer parámetro no es válido");
				}

				catch (PromocionException e) {
					System.err.println(e.getMessage());
				}

			} else {
				System.err.println("La cantidad de parámetros para construir la promoción [" + tmp[1]
						+ "] en el archivo con nombre [" + this.rutaArchivo + "] es menor de la esperada");
			}
		}
		return promociones;

	}

	/**
	 * Maneja el input de parámetros para agregar la Promocion al
	 * ArrayList<Promocion> promociones
	 * 
	 * @param tmp
	 * @param cantidadDeParametros
	 * @param empezarDesde
	 * @throws PromocionException
	 */
	private void agregaPromocionPorcentual(String[] tmp, int cantidadDeParametros, int empezarDesde)
			throws PromocionException {
		ArrayList<Atraccion> atraccionesParaConstruirPromo;
		String[] atraccionesABuscar = new String[cantidadDeParametros - empezarDesde];
		for (int i = empezarDesde, k = 0; i < tmp.length; i++, k++) {
			atraccionesABuscar[k] = tmp[i];
		}
		atraccionesParaConstruirPromo = this.getObjetosAtracciones(atraccionesABuscar);
		promociones.add(creaPromoPorcentual(tmp, atraccionesParaConstruirPromo));
	}

	/**
	 * Valida los parámetros de input y crea un objeto de tipo PromocionPorcentual
	 * 
	 * @param tmp
	 * @param atraccionesParaConstruirPromo
	 * @return
	 * @throws PromocionException
	 */
	private PromocionPorcentual creaPromoPorcentual(String[] tmp, ArrayList<Atraccion> atraccionesParaConstruirPromo)
			throws PromocionException {
		String nombre = tmp[1];
		TipoDeAtraccion tipo = null;
		double porcentajeBonificacion = 0;
		try {
			tipo = TipoDeAtraccion.valueOf(tmp[2].toUpperCase());
			porcentajeBonificacion = Double.parseDouble(tmp[3]);
		} catch (NumberFormatException e) {
			throw new PromocionException("El argumento de [Costo] para crear la Promoción [" + tmp[1]
					+ "] en el archivo [" + this.rutaArchivo + "] es erróneo.");
		} catch (IllegalArgumentException e) {
			throw new PromocionException("El argumento de [Tipo de Atraccion] para crear la Promoción [" + tmp[1]
					+ "] en el archivo [" + this.rutaArchivo + "] es erróneo.");
		}
		return new PromocionPorcentual(nombre, tipo, porcentajeBonificacion, atraccionesParaConstruirPromo);
	}

	/**
	 * Maneja el input de parámetros para agregar la Promocion al
	 * ArrayList<Promocion> promociones
	 * 
	 * @param tmp
	 * @param cantidadDeParametros
	 * @throws PromocionException
	 */
	private void agregaPromocionAbsoluta(String[] tmp, int cantidadDeParametros) throws PromocionException {
		ArrayList<Atraccion> atraccionesParaConstruirPromo;
		String[] atraccionesABuscar = new String[cantidadDeParametros - 4];
		for (int i = 4, k = 0; i < tmp.length; i++, k++) {
			atraccionesABuscar[k] = tmp[i];
		}
		atraccionesParaConstruirPromo = this.getObjetosAtracciones(atraccionesABuscar);
		promociones.add(crearPromoAbsoluta(tmp, atraccionesParaConstruirPromo));
	}

	/**
	 * Valida los parámetros de input y crea un objeto de tipo PromocionAbsoluta
	 * 
	 * @param tmp
	 * @param atraccionesParaConstruirPromo
	 * @return objeto PromocionAbsoluta
	 * @throws PromocionException
	 */
	private PromocionAbsoluta crearPromoAbsoluta(String[] tmp, ArrayList<Atraccion> atraccionesParaConstruirPromo)
			throws PromocionException {
		String nombre = tmp[1];
		TipoDeAtraccion tipo = null;
		double costo = 0;
		;
		try {
			tipo = TipoDeAtraccion.valueOf(tmp[2].toUpperCase());
			costo = Double.parseDouble(tmp[3]);
		} catch (NumberFormatException e) {
			throw new PromocionException("El argumento de [Costo] para crear la Promoción [" + tmp[1]
					+ "] en el archivo [" + this.rutaArchivo + "] es erróneo.");
		} catch (IllegalArgumentException e) {
			throw new PromocionException("El argumento de [Tipo de Atraccion] para crear la Promoción [" + tmp[1]
					+ "] en el archivo [" + this.rutaArchivo + "] es erróneo.");
		}

		return new PromocionAbsoluta(nombre, tipo, costo, atraccionesParaConstruirPromo);
	}

	/**
	 * Maneja el input de parámetros para agregar la Promocion al
	 * ArrayList<Promocion> promociones
	 * 
	 * @param tmp
	 * @param cantidadDeParametros
	 * @throws PromocionException
	 */
	private void agregaPromocionAxB(String[] tmp, int cantidadDeParametros) throws PromocionException {
		ArrayList<Atraccion> atraccionesParaConstruirPromo;
		String[] atraccionesABuscar = new String[cantidadDeParametros - 3];
		for (int i = 3, k = 0; i < tmp.length; i++, k++) {
			atraccionesABuscar[k] = tmp[i];
		}
		atraccionesParaConstruirPromo = this.getObjetosAtracciones(atraccionesABuscar);
		promociones.add(crearPromoAxB(tmp, atraccionesParaConstruirPromo));
	}

	/**
	 * Valida los parámetros de input y crea un objeto de tipo PromocionAxB
	 * 
	 * @param tmp
	 * @param atraccionesParaConstruirPromo
	 * @return objeto PromocionAxB
	 * @throws PromocionException
	 */
	private PromocionAxB crearPromoAxB(String[] tmp, ArrayList<Atraccion> atraccionesParaConstruirPromo)
			throws PromocionException {
		String nombre = tmp[1];
		TipoDeAtraccion tipo = null;
		try {
			tipo = TipoDeAtraccion.valueOf(tmp[2].toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new PromocionException("El argumento de [Tipo de Atraccion] para crear la Promoción [" + tmp[1]
					+ "] en el archivo [" + this.rutaArchivo + "] es erróneo.");
		}
		return new PromocionAxB(nombre, tipo, atraccionesParaConstruirPromo);
	}

	/**
	 * Busca, a través de los string ingresados por input, los objetos Atraccion con
	 * el mismo nombre y los agraga a ArrayList<Atraccion> listaDeAtracciones
	 * 
	 * @param atraccionesABuscar
	 * @return ArrayList<Atraccion> listaDeAtracciones
	 */
	private ArrayList<Atraccion> getObjetosAtracciones(String[] atraccionesABuscar) {
		ArrayList<Atraccion> listaDeAtracciones = new ArrayList<Atraccion>();
		for (String atraccion : atraccionesABuscar) {
			boolean encontrado = false;
			Iterator<Atraccion> iter = atraccionesDesdeApp.iterator();
			while (!encontrado && iter.hasNext()) {
				Atraccion atraccionEnParque = iter.next();
				if (atraccion.equals(atraccionEnParque.getNombre())) {
					listaDeAtracciones.add(atraccionEnParque);
					encontrado = true;
				}
			}
		}
		return listaDeAtracciones;
	}

}
