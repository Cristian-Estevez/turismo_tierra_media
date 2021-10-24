package turismoenlatierramedia;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
	
    private int usuarioId;
	private String nombre;
	private double monedasDeOro;
	private double tiempoDisponible;
	private TipoDeAtraccion atraccionFavorita;
	private List<Producto> productos;

	public Usuario(int usuarioId, String nombre, double monedasDeOro, double tiempoDisponible, TipoDeAtraccion atraccionFavorita) {
		this.usuarioId = usuarioId;
		this.nombre = nombre;
		this.monedasDeOro = monedasDeOro;
		this.tiempoDisponible = tiempoDisponible;
		this.atraccionFavorita = atraccionFavorita;
		this.productos = new ArrayList<Producto>();
	}


	/*
	 * @pre app envía la confirmación de la compra, se asigna el producto comprado
	 * al usuario y se descuentan tiempo y monedasDeOro necesarios envia mensaje
	 * Atraccion.ocuparPlaza()
	 * 
	 * @param
	 * 
	 */
	public void comprarProducto(Producto atraccion) {
		this.monedasDeOro -= atraccion.getCosto();
		this.tiempoDisponible -= atraccion.getTiempoDeDuracion();
		this.productos.add(atraccion);
		atraccion.ocuparPlaza();
	}
	

	public boolean yaCompro(Producto otroProducto) {
		for (Producto miProducto : productos) {
			if (miProducto.incluye(otroProducto)) {
				return true;
			}
		}
		return false;
	}
	
	
	public double getTiempoDisponible() {
		return this.tiempoDisponible;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public int getId() {
		return this.usuarioId;
	}

	public double getMonedasDeOro() {
		return this.monedasDeOro;
	}

	public List<Producto> getProductosComprados() {
		return this.productos;
	}

	public TipoDeAtraccion getTipoDeAtraccionFavorita() {
		return this.atraccionFavorita;
	}

	@Override
	public int hashCode() {
		return Objects.hash(atraccionFavorita, monedasDeOro, nombre, productos, tiempoDisponible);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return atraccionFavorita == other.atraccionFavorita
				&& Double.doubleToLongBits(monedasDeOro) == Double.doubleToLongBits(other.monedasDeOro)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(productos, other.productos)
				&& Double.doubleToLongBits(tiempoDisponible) == Double.doubleToLongBits(other.tiempoDisponible);
	}

}
