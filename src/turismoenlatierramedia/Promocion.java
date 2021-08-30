package turismoenlatierramedia;

public class Promocion extends Producto {
	protected Atraccion[] atraccionesIncluidas;

	public Promocion(String nombre, double costo, double tiempoDeDuracion, TipoDeAtraccion tipoDeAtraccion,
			Atraccion[] atraccionesIncluidas) {
		super(nombre, costo, tiempoDeDuracion, tipoDeAtraccion);
		this.atraccionesIncluidas = atraccionesIncluidas;
	}

	public int getLugaresDisponibles() {
		return 0;

	}

public void ocuparLugar(Atraccion[] atraccionesIncluidas){
	for (int i = 0; i < atraccionesIncluidas.length; i++) {
	
	}
}

	public double calcularTiempoDeDuracion(Atraccion[] atraccionesIncluidas) {
		double tiempoTotalDeDuracion = 0;
		for (Atraccion atraccion : atraccionesIncluidas) {
			tiempoTotalDeDuracion += atraccion.getTiempoDeDuracion();
		}
		return tiempoTotalDeDuracion;
	}

}
