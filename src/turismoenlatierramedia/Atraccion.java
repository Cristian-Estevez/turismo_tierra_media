package turismoenlatierramedia;

public class Atraccion extends Producto {

	private int cupoDiario;
	private int plazasOcupadas;

	public Atraccion(String nombre, double costo, double tiempoDeDuracion, int cupo, TipoDeAtraccion tipoDeAtraccion) {
		super(nombre, costo, tiempoDeDuracion, tipoDeAtraccion);
		this.cupoDiario = cupo;
	}

	public String getNombre() {
		return nombre;
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

	@Override
	public String toString() {
		return "\n- " + nombre + ", Costo = " + costo + ", Tiempo De Duracion = " + tiempoDeDuracion
				+ ", Tipo De Atraccion = " + tipoDeAtraccion + ", Lugares Disponibles = " + getLugaresDisponibles() + "]";
	}

}
