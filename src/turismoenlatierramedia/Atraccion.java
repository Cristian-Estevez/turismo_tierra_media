package turismoenlatierramedia;

/**
 * 
 * @author Micaela Trisi
 *
 */

public class Atraccion extends Producto {

	private int cupoDiario;
	private int plazasOcupadas;

	public Atraccion(String nombre, double costo, double tiempoDeDuracion, int cupo, TipoDeAtraccion tipoDeAtraccion) {
		super(nombre, costo, tiempoDeDuracion, tipoDeAtraccion);
		this.cupoDiario = cupo;
	}

	public int getLugaresDisponibles() {
		return cupoDiario - plazasOcupadas;
	}
	
	public void ocuparPlaza() throws AtraccionException {
		if (cupoDiario == plazasOcupadas) {
			throw new AtraccionException("No hay más cupo para esta atracción");
		} else {
			plazasOcupadas++;
		}
	}
	
}
