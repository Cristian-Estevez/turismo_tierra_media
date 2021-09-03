package turismoenlatierramedia;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Promocion extends Producto {
	
	protected List<Atraccion> atraccionesIncluidas;

	public Promocion(String nombre, double tiempoDeDuracion, TipoDeAtraccion tipoDeAtraccion
			, List<Atraccion> atraccionesIncluidas) {
		super(nombre, tiempoDeDuracion, tipoDeAtraccion);
		this.atraccionesIncluidas = atraccionesIncluidas;
	}

	//Constructor llamado por PromocionAbsoluta
	public Promocion(String nombre, TipoDeAtraccion tipo, double costo, List<Atraccion> atraccionesIncluidas) {
		super(nombre, tipo, costo);
		this.atraccionesIncluidas = atraccionesIncluidas;
	}

	// Constructor para PromocionPorcentual
	public Promocion(String nombre, TipoDeAtraccion tipo, List<Atraccion> atraccionesIncluidas) {
		super(nombre, tipo);
		this.atraccionesIncluidas = atraccionesIncluidas;
	}

	/**
	 * 
	 * @return devuelve la menor cantidad de plazas disponibles de las atracciones 
	 * de la lista atraccionesIncluidas 
	 */
	public int getLugaresDisponibles() {
		int lugaresDisponibles = 0;
		int contador = 0;
		for (Atraccion atracciones : atraccionesIncluidas) {
			if (contador == 0) {
				lugaresDisponibles = atracciones.getLugaresDisponibles();
				contador++;
			}
			if (lugaresDisponibles > atracciones.getLugaresDisponibles()) {
				lugaresDisponibles = atracciones.getLugaresDisponibles();
			}
		}
		return lugaresDisponibles;
	}

	public void ocuparPlaza() throws AtraccionException {		
		for (Atraccion atraccion : atraccionesIncluidas) {
            atraccion.ocuparPlaza();
		}
	}

	public double getTiempoDeDuracion() {
		double tiempoTotalDeDuracion = 0;		
		for (Atraccion atraccion : atraccionesIncluidas) {
			tiempoTotalDeDuracion += atraccion.getTiempoDeDuracion();
		}
		return tiempoTotalDeDuracion;
	}
	
	public abstract String getTipoDePromocion();
		
	
	@Override
	public String toString() {
		return "Promocion de tipo "+ this.getTipoDePromocion() + ": \nNombre = " + this.getNombre()  +  "\nCosto en promoción = "
				+ costo + "\nTiempo De Duracion = " + this.getTiempoDeDuracion() + "\nTipo De Atraccion = " + tipoDeAtraccion
				+ "\nLugares Disponibles() = " + getLugaresDisponibles()   + "\nAtracciones Incluidas = " + atraccionesIncluidas;
	}

	public boolean esPromocion() {
		return true;
	}
	
	public ArrayList<Atraccion> getAtraccionesIncluidas(){
		return (ArrayList<Atraccion>) atraccionesIncluidas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(atraccionesIncluidas);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promocion other = (Promocion) obj;
		return Objects.equals(atraccionesIncluidas, other.atraccionesIncluidas);
	}
	
	
}
